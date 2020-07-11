package controller;

import builder.EmployeeBuilder;
import builder.TaskBuilder;
import database.DataService;
import model.Employee;
import model.Task;
import util.eRole;
import util.eStatus;
import util.fields.eEmployeeInputFields;
import util.fields.eTaskInputFields;
import view.EmployeeCreationUi;
import view.TaskCreationUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    public static Employee newEmployee(Map<eEmployeeInputFields, String> inputFields) {
        Employee employee = EmployeeBuilder.builder(inputFields);
        DataService.addEmployee(employee);

        return employee;
    }

    public static void initData(){
        DataService.init();
    }

    public static Employee getEmployeeByID(String employeeId) {
        List<Employee> employeeByIdList = getEmployeeList().stream().filter(
                employee -> employee.getEmployeeId().equals(employeeId))
                .collect(Collectors.toList());
        if (employeeByIdList.size()>0)
            return employeeByIdList.get(0);
        else {
            System.out.println("Employee id not existing!");
        }
        return null;
    }

    public static List<Employee> getEmployeeList(){
        return DataService.getEmployeeList();
    }
    public static void updateEmployeeList(){
        DataService.saveEmployeesToDB(getEmployeeList());
    }

    public static List<Task> getAllTasks(){
        return DataService.getAllTasksList();
    }

    public static Task createTaskForEmployeeById(String id) {
        Task task = TaskBuilder.taskBuilder(TaskCreationUI.createTaskCreationUI().getInputFromUserToCreateTask());
        List<Task> tasksList = DataService.getAllTasksList();
        task.setEmployeeId(id);
        tasksList.add(task);
        DataService.saveTasksToDB(tasksList);
        initTasksToEmployees();
        getEmployeeList().forEach(System.out::println);

        return task;
    }

    public static List<Task> getTasksForEmployee(String employeeId){
        return DataService.getAllTasksList().stream().
                filter(task -> task.getEmployeeId().equals(employeeId)).
                collect(Collectors.toList());
    }

    public static void initTasksToEmployees() {
        List<Task> taskList = DataService.getAllTasksList();
        getEmployeeList().forEach(employee -> employee.setNumOfTask(0));

        taskList.forEach(task -> {
            Employee employee = getEmployeeByID(task.getEmployeeId()).addTask(task);
            employee.setNumOfTask(employee.getNumOfTask() + 1);

        });
    }

    public static boolean authenticateUser(String user, String password){
        boolean isApproved = false;
        Map<String, String> usersFromDB = DataService.getUsersFromDB();

        if (user.equals("root") && password.equals("root")){
            isApproved = true;
        }else if (usersFromDB.containsKey(user)) {
            isApproved = usersFromDB.get(user).equals(password);
        }


        return isApproved;
    }

    public static eRole loginToSystemByEmployeeId(String employeeId){
        if(employeeId.equals("root"))
            return eRole.Root;

        DataService.init();
        Employee employeeByID = getEmployeeByID(employeeId);
        System.out.println("\n----Welcome " + employeeByID.getName() + "!----");
        System.out.println(employeeByID.toString());

        return employeeByID.getRole();
    }

    private static List<Employee> getAllTeamLeaders(){
        List<Employee> teamLeaderList = getEmployeeList().stream().
                filter(employee -> employee.getRole() == eRole.TeamLeader).
                collect(Collectors.toList());

        return teamLeaderList;
    }

    public static List<String> getAllTeamLeadersIds(){
        List<String> teamLeadersIds = getAllTeamLeaders().stream().
                map(employee -> employee.getEmployeeId()).
                collect(Collectors.toList());

        return teamLeadersIds;
    }

    public static boolean changeTaskStatus(String employeeId, String taskId, eStatus status){
        boolean isChanged = false;
        List<Task> allTasks = getAllTasks();
        List<Task> taskOfEmployee = allTasks.stream().
                filter(task ->
                        task.getTaskId().equals(taskId) && task.getEmployeeId().equals(employeeId)).
                collect(Collectors.toList());
        if(taskOfEmployee.size()>0){
            taskOfEmployee.get(0).setStatus(status);
            DataService.saveTasksToDB(allTasks);
            isChanged = true;
        }

        return isChanged;
    }

    public static List<Employee> deleteEmployeeById(String employeeId){
        return DataService.deleteEmployeeFromDB(employeeId);
    }

    public static Employee changeEmployeeSalary(String employeeId, String salary){
        Employee employee = getEmployeeByID(employeeId).setSalary(salary);
        DataService.saveEmployeesToDB(getEmployeeList());

        return employee;
    }

    public static List<Task> getTasksByEmployeeId(String id){
        List<Task> taskList = getAllTasks().stream().
                filter(task -> task.getEmployeeId().equals(id)).
                collect(Collectors.toList());

        if(taskList.size() > 0){
            return taskList;
        }

        return null;
    }

    public static Map<String,List<String>> getAllTeams(){
        return DataService.getTeamsList();
    }
    public static List<String> getTeamByTeamLeaderId(String teamLeaderId){
        Map<String, List<String>> teamsList = DataService.getTeamsList();
        boolean isHaveTeam = teamsList.containsKey(teamLeaderId);

        if(isHaveTeam){
            return teamsList.get(teamLeaderId);
        }

        return null;
    }

    public static void addEmployeeToTeam(String teamLeaderId, String employeeId) {
        Map<String, List<String>> allTeams = Controller.getAllTeams();

        if (allTeams.containsKey(teamLeaderId)) {
            allTeams.get(teamLeaderId).add(employeeId);
        } else {
            List<String> newTeamList = new ArrayList<>();
            newTeamList.add(employeeId);
            allTeams.put(teamLeaderId, newTeamList);
        }

        DataService.saveTeamsToDB(allTeams);
    }
}
