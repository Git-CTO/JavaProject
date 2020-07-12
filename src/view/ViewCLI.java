package view;

import controller.Controller;
import model.Employee;
import model.Task;
import util.eRole;
import util.eStatus;
import util.fields.eEmployeeInputFields;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewCLI {
    static Scanner scanner = new Scanner(System.in);
    static boolean toExit;
    private static ViewCLI viewCLIInstance = null;
    private static boolean toLogout;


    private ViewCLI() {

    }

    public static ViewCLI createViewCli() {
        if (viewCLIInstance == null) {
            viewCLIInstance = new ViewCLI();
        }
        return viewCLIInstance;
    }

    void initView() {
        do {
            String employeeId = LoginView.createLoginViewInstance().loginAuthenticateUser();
            eRole role = Controller.loginToSystemByEmployeeId(employeeId);
            Controller.initData();
            toLogout = false;
            toExit = false;

            while (!toExit) {
                System.out.println("\n--Main--");
                System.out.println("Choose Action:");
                switch (role) {
                    case TeamLeader:
                        System.out.println("1- Show Team");
                        System.out.println("2- Create Task For Employee");
                        System.out.println("3- Change Personal Details");
                        System.out.println("4- Add Employee To Team");
                        System.out.println("5- Show Team's tasks");
                        System.out.println("6- Show Tasks");
                        System.out.println("7- Change Task Status");
                        System.out.println("\n0 <-- 👋 Exit");
                        System.out.println("\n999 <-- \uD83D\uDD01 Logout\n");
                        selectActionForTeamLeader(scanner.nextInt(), employeeId);
                        break;
                    case MinorWorker:
                        System.out.println("1- Show Employee Card");
                        System.out.println("2- Show Tasks");
                        System.out.println("3- Change Personal Details");
                        System.out.println("4- Change Task's Status");
                        System.out.println("\n0 <-- 👋 Exit");
                        System.out.println("\n999 <-- \uD83D\uDD01 Logout\n");
                        selectActionForMinorEmployee(scanner.nextInt(), employeeId);
                        break;
                    case CEO:
                    case Root:
                        System.out.println("1- Add Employee To Company");
                        System.out.println("2- Show All Employees Cards");
                        System.out.println("3- Show All Tasks In Company");
                        System.out.println("4- Delete Employee From Company");
                        System.out.println("5- Change Salary To Employee");
                        System.out.println("6- Get Employee Card And His Tasks");
                        System.out.println("7- Create Task For Employee");
                        System.out.println("8- Show All Teams In Company");
                        System.out.println("9- Change Task's Status For Employee");
                        System.out.println("\n0 <-- 👋 Exit");
                        System.out.println("\n999 <-- \uD83D\uDD01 Logout\n");
                        selectActionForRoot(scanner.nextInt());
                        break;
                }
            }
        } while (toLogout);

    }

    private void selectActionForRoot(int actionNumber) {
        switch (actionNumber) {
            case 1:
                insertNewEmployeeToCompany();
                break;
            case 2:
                showAllEmployees();
                break;
            case 3:
                showAllTasks();
                break;
            case 4:
                deleteEmployeeFromCompany();
                break;
            case 5:
                changeEmployeeSalary();
                break;
            case 6:
                getEmployeeCardAndTasks();
                break;
            case 7:
                createTaskForEmployee();
                break;
            case 8:
                showAllTeamsInCompany();
                break;
            case 9:
                changeTaskStatusForAnyEmployee();
            case 0:
                toExit = true;
                break;
            case 999:
                toLogout = true;
                toExit = true;
                break;
            default:
                System.out.println("Error! Wrong Number Entered!");
        }
    }

    private void selectActionForMinorEmployee(int actionNumber, String employeeId) {
        switch (actionNumber) {
            case 1:
                System.out.println(Controller.getEmployeeByID(employeeId));
                break;
            case 2:
                showTasksForEmployee(employeeId);
                break;
            case 3:
                changePersonalDetails(employeeId);
                break;
            case 4:
                changeStatusOfTask(employeeId);
                break;
            case 0:
                toExit = true;
                break;
            case 999:
                toLogout = true;
                toExit = true;
                break;
            default:
                System.out.println("Error! Wrong Number Entered!");
        }
    }

    private void selectActionForTeamLeader(int actionNumber, String teamLeaderId) {
        switch (actionNumber) {
            case 1:
                showTeam(teamLeaderId);
                break;
            case 2:
                createTaskForEmployeeInTeam(teamLeaderId);
                break;
            case 3:
                changePersonalDetails(teamLeaderId);
                break;
            case 4:
                addEmployeeToTeam(teamLeaderId);
                break;
            case 5:
                showTeamTasks(teamLeaderId);
                break;
            case 6:
                showTasksForEmployee(teamLeaderId);
                break;
            case 7:
                changeTaskStatusFromTeamLeader(teamLeaderId);
            break;
            case 0:
                toExit = true;
                break;
            case 999:
                toLogout = true;
                toExit = true;
                break;
            default:
                System.out.println("Error! Wrong Number Entered!");
        }
    }

    private void showTeam(String teamLeaderId) {
        List<String> teamByTeamLeaderId = Controller.getTeamByTeamLeaderId(teamLeaderId);

        if (teamByTeamLeaderId == null) {
            System.out.println("your team is Empty");
        } else {
            System.out.println("Team Size: " + teamByTeamLeaderId.size());
            if (teamByTeamLeaderId.size() > 0) {
                System.out.println("Your Employee's Name and Id In Team");
                teamByTeamLeaderId.forEach(employeeId ->
                {
                    Employee employee = Controller.getEmployeeByID(employeeId);
                    System.out.println("\n#--#--#--#--#--#--#--#");
                    System.out.println("Name: " + employee.getName()
                            + ", Id: " + employee.getEmployeeId());
                    System.out.println("#--#--#--#--#--#--#--#");
                });
            } else {
                System.out.println("your team is Empty");
            }
        }
    }

    private void addEmployeeToTeam(String teamLeaderId) {
        scanner.nextLine();
        System.out.println("Enter Employee Id To Add Your Team: ");
        String employeeId = scanner.nextLine();
        boolean isAlreadyExistInTeam = Controller.addEmployeeToTeam(teamLeaderId, employeeId);
        if (isAlreadyExistInTeam){
            System.out.println("\nemployee id: " + employeeId + " is already exist in your team!");
        }else {
            System.out.println("Employee Added your Team!\n");
        }
    }

    private void changePersonalDetails(String employeeId) {
        boolean exitBackToMain = false;
        while (!exitBackToMain) {
            scanner.nextLine();
            System.out.println("Choose Action:");
            System.out.println("1-Change First Name");
            System.out.println("2-Change Last Name");
            System.out.println("3-Change Address");
            System.out.println("4-Change Phone Number");
            System.out.println("\n0- <-- Back to main");
            Employee employee = Controller.getEmployeeByID(employeeId);
            String value;
            int numberCase = scanner.nextInt();
            switch (numberCase) {
                case 1:
                    scanner.nextLine();
                    System.out.print("New First Name: ");
                    value = scanner.nextLine();
                    employee.setFirstName(value);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("New Last Name: ");
                    value = scanner.nextLine();
                    employee.setLastName(value);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("New Address: ");
                    value = scanner.nextLine();
                    employee.setAddress(value);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("New Phone Number: ");
                    value = scanner.nextLine();
                    employee.setPhoneNumber(value);
                    break;
                case 0:
                    exitBackToMain = true;
                    break;
            }
            System.out.println(employee.toString());
            Controller.updateEmployeeList();
        }


    }

    private void changeEmployeeSalary() {
        String employeeId, newSalary;
        scanner.nextLine();
        System.out.print("enter the employee id: ");
        employeeId = scanner.nextLine();
        System.out.print("New Salary: ");
        newSalary = scanner.nextLine();
        System.out.println(Controller.changeEmployeeSalary(employeeId, newSalary).toString());
        System.out.println("Salary Is Changed!");
    }

    private void insertNewEmployeeToCompany() {
        Map<eEmployeeInputFields, String> inputFields;
        System.out.println("Insert New Employee To Company EHRP System:");
        inputFields = EmployeeCreationUi.createEmployeeCreationUi().getInputFromUserToCreateEmployee();
        System.out.println(Controller.newEmployee(inputFields).toString());
        System.out.println("new Employee Card Created!");
    }

    private void deleteEmployeeFromCompany() {
        scanner.nextLine();
        System.out.print("enter the employee id: ");
        String employeeId = scanner.nextLine();
        Controller.deleteEmployeeById(employeeId);
        System.out.println("\nEmployee with id: " + employeeId + " deleted from system");
    }

    private void showAllEmployees() {
        System.out.println("All Employees In Company: ");
        Controller.getEmployeeList().forEach(employee ->
                System.out.println("\n#--#--#--#--#--#--#--#\n"
                        + employee.toString() +
                        "\n#--#--#--#--#--#--#--#\n"));
    }

    private void showAllTasks() {
        System.out.println("All Tasks In Company: ");
        Controller.getAllTasks().forEach(System.out::println);
    }

    private void showTeamTasks(String teamLeaderId) {
        List<String> teamByTeamLeaderId = Controller.getTeamByTeamLeaderId(teamLeaderId);

        if (teamLeaderId == null) {
            System.out.println("\no Tasks To show! you Team Is empty, you haven't employees");
        } else {
            teamByTeamLeaderId.forEach(employeeId -> {
                List<Task> tasksByEmployeeId = Controller.getTasksByEmployeeId(employeeId);
                if (tasksByEmployeeId == null) {
                    System.out.println("No Tasks for employee id: " + employeeId);
                } else {
                    tasksByEmployeeId.forEach(System.out::println);
                }
            });
        }

    }

    private void changeTaskStatusFromTeamLeader(String teamLeaderId){
        List<String> teamByTeamLeaderId = Controller.getTeamByTeamLeaderId(teamLeaderId);
        scanner.nextLine();
        System.out.println("change Task's status: \n1-For Employee in your team \n2-For you");
        int userChosen = scanner.nextInt();

        switch (userChosen) {
            case 1:
            if (teamByTeamLeaderId == null) {
                System.out.println("Your team is empty,  so you can't change Task Status For employee!");
            } else {
                System.out.println("There are your employees team ids:");
                teamByTeamLeaderId.forEach(employeeId -> System.out.println("Id : " + employeeId));
                changeTaskStatusForAnyEmployee();
            }
            break;
            case 2:
                changeStatusOfTask(teamLeaderId);
        }
    }

    private void changeTaskStatusForAnyEmployee() {
        scanner.nextLine();
        System.out.println("\nPlease enter employee id:");
        String employeeId = scanner.nextLine();
        changeStatusOfTask(employeeId);
    }

    private void changeStatusOfTask(String employeeId) {
        String taskId;
        eStatus status;
        scanner.nextLine();
        System.out.println("\nEnter task id to change Task's status: ");
        taskId = scanner.nextLine();
        System.out.println("Choose status: \n0-Not Started \n1-In Process \n2-Finished");
        status = eStatus.values()[scanner.nextInt()];
        boolean changeTaskStatus = Controller.changeTaskStatus(employeeId, taskId, status);

        if (changeTaskStatus) {
            System.out.println("Task's status Updated!");
        } else {
            System.out.println("Task's id: " + taskId + ", for employee's id " + employeeId + " not exist!");
        }
        scanner.nextLine();
    }

    private void getEmployeeCardAndTasks() {
        scanner.nextLine();
        System.out.print("\nEnter Employee id: ");
        String employeeId = scanner.nextLine();
        System.out.println(Controller.getEmployeeByID(employeeId));
        System.out.println("Employee's Tasks: ");
        List<Task> tasksByEmployeeId = Controller.getTasksByEmployeeId(employeeId);
        if (tasksByEmployeeId == null) {
            System.out.println("No tasks for employee id: " + employeeId);
        } else {
            tasksByEmployeeId.forEach(System.out::println);
        }
    }

    private void showTasksForEmployee(String employeeId) {
        System.out.println("\nYour Tasks: ");
        List<Task> tasksForEmployee = Controller.getTasksForEmployee(employeeId);
        if (tasksForEmployee.size() > 0) {
            tasksForEmployee.forEach(System.out::println);
        } else {
            System.out.println("You task list is empty");
        }
    }

    private void createTaskForEmployee() {
        scanner.nextLine();
        System.out.println("\nEnter employee id to create him Task:");
        String employeeId = scanner.nextLine();
        Task task = Controller.createTaskForEmployeeById(employeeId);
        if (task != null) {
            System.out.println(Controller.createTaskForEmployeeById(employeeId));
            System.out.println("\nNew Task Created!");
        } else {
            System.out.println("\nEmployee Id Not Exist!");
        }
    }

    private void createTaskForEmployeeInTeam(String teamLeaderId) {
        List<String> teamByTeamLeaderId = Controller.getTeamByTeamLeaderId(teamLeaderId);

        if (teamByTeamLeaderId == null) {
            System.out.println("Your team is empty, you can't create task for employee!");
        } else {
            System.out.println("There are your employees team ids:");
            teamByTeamLeaderId.forEach(employeeId -> System.out.println("Id : " + employeeId));
            createTaskForEmployee();
        }
    }

    private void showAllTeamsInCompany() {
        Map<String, List<String>> allTeams = Controller.getAllTeams();
        AtomicInteger indexSize = new AtomicInteger();
        if (allTeams.size() == 0){
            System.out.println("\nThere are no teams in company, or team leader haven't employees");
        }
        for (String teamLeaderId : allTeams.keySet()) {
            System.out.println("teamLeaderId: " + teamLeaderId);
            List<String> employeesIdList = allTeams.get(teamLeaderId);
            System.out.print("employee id in this team: [ ");
            indexSize.set(employeesIdList.size());

            employeesIdList.forEach(id -> {
                if (indexSize.get() - 1 > 0) {
                    System.out.print(id + ", ");
                } else if (indexSize.get() - 1 == 0) {
                    System.out.print(id);
                } else {
                    System.out.print("empty team");
                }
                indexSize.getAndDecrement();
            });

            System.out.println(" ]");
        }
    }
}
