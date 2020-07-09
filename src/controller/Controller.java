package controller;

import builder.EmployeeBuilder;
import builder.TaskBuilder;
import database.DataService;
import model.Employee;
import model.Task;
import model.TeamLeader;
import util.eRole;
import view.EmployeeCreationUi;
import view.TaskCreationUI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
    public static Employee newEmployee() {
        Employee employee = EmployeeBuilder.builder(new EmployeeCreationUi().getInputFromUserToCreateEmployee());
        DataService.addEmployee(employee);

        return employee;
    }

    public static Employee getEmployeeByID(String employeeId) {
        List<Employee> employeeByIdList = getEmployeeList().stream().filter(
                employee -> employee.getPersonalId().equals(employeeId) || employee.getEmployeeId().equals(employeeId))
                .collect(Collectors.toList());

        return employeeByIdList.get(0);
    }

    public static List<Employee> getEmployeeList(){
        return DataService.getEmployeeList();
    }

    public static List<Task> getAllTasks(){
        return DataService.getTasksFromDB();
    }

    public static Task createTaskForEmployeeById(String id) {
        Task task = TaskBuilder.taskBuilder(new TaskCreationUI().getInputFromUserToCreateTask());
        List<Task> tasksFromDB = DataService.getTasksFromDB();
        task.setEmployeeId(id);
        tasksFromDB.add(task);
        DataService.saveTasksToDB(tasksFromDB);
        initTasksToEmployees();
        getEmployeeList().forEach(System.out::println);

        return task;
    }

    public static void initTasksToEmployees() {
        List<Task> tasksFromDB = DataService.getTasksFromDB();
        getEmployeeList().forEach(employee -> employee.setNumOfTask(0));

        tasksFromDB.forEach(task -> {
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
        System.out.println("Welcome " + employeeByID.getName());
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
}
