package view;

import controller.Controller;
import model.Employee;
import model.TeamLeader;
import util.eRole;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewCLI {
    static Scanner scanner = new Scanner(System.in);
    static boolean toExit = true;


    public void initView() {
        String employeeId = new Login().loginAuthenticateUser();
        eRole role = Controller.loginToSystemByEmployeeId(employeeId);
        while (toExit) {
            System.out.println("--Main--");
            System.out.println("Choose Action:");
            switch (role) {
                case TeamLeader:
                    System.out.println("1- Show Team");
                    System.out.println("2- Create Task For Employee");
                    System.out.println("3- Change Personal Details");
                    System.out.println("4- Add Employee To Team");
                    System.out.println("\n0- <-- Exit");
                    selectActionForTeamLeader(scanner.nextInt(), employeeId);
                    break;
                case MinorWorker:
                    System.out.println("1- Show Employee Card");
                    System.out.println("2- Show Tasks");
                    System.out.println("3- Change Personal Details");
                    System.out.println("\n0- <-- Exit");
                    selectActionForMinorEmployee(scanner.nextInt(), employeeId);
                    break;
                case CEO:
                case Root:
                    System.out.println("1- Add Employee To Company");
                    System.out.println("2- Show All Employees Cards");
                    System.out.println("3- Show All Tasks In Company");
                    System.out.println("4- delete Employee From Company");
                    System.out.println("5- Change Salary To Employee");
                    System.out.println("6- Get Employee Card And His Tasks");
                    System.out.println("7- Create Task For Employee");
                    System.out.println("\n0- <-- Exit");
                    selectActionForRoot(scanner.nextInt());
                    break;
            }
        }


        showAllEmployees();
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
                getEmployeeCard();
                break;
            case 7:
                createTaskForEmployee();
                break;
            case 0:
                toExit = true;
                break;
        }
    }

    private void selectActionForMinorEmployee(int actionNumber, String employeeId) {
        switch (actionNumber) {
            case 1:
                Controller.getEmployeeByID(employeeId);
                break;
            case 2:
                showTasksForEmployee(employeeId);
            case 0:
                toExit = true;
                break;
        }
    }

    private void selectActionForTeamLeader(int actionNumber, String employeeId) {
        switch (actionNumber) {
            case 1:
                showTeam(employeeId);
                break;
            case 2:
                createTaskForEmployee();
                break;
            case 3:
                changePersonalDetails(employeeId);
                break;
            case 4:
                addEmployeeTeam(employeeId);
                break;
            case 0:
                toExit = true;
                break;
        }
    }

    public void showTeam(String teamLeaderId){
        List<String> employeesTeamIds = ((TeamLeader) Controller.getEmployeeByID(teamLeaderId)).getEmployeesTeamIds();
        System.out.println("Your Team:");
        if (employeesTeamIds.size()>0){
        Controller.getEmployeeList().stream().
                filter(employee -> employeesTeamIds.
                        contains(employee.getEmployeeId())).
                forEach(System.out::println);
        }else{
            System.out.println("your team is Empty");
        }
    }

    public void addEmployeeTeam(String teamLeaderId){
        System.out.println("Enter Employee Id To Add Your Team: ");
        ((TeamLeader) Controller.getEmployeeByID(teamLeaderId)).addEmployeeToTeam(scanner.nextLine());

    }
    private void changePersonalDetails(String employeeId) {
        System.out.println("1-Change First Name");
        System.out.println("2-Change Last Name");
        System.out.println("3-Change Address");
        System.out.println("4-Change Phone Number");
        System.out.println("\n0- <-- Back to main");
        Employee employee = Controller.getEmployeeByID(employeeId);
        boolean exitBackToMain = false;
        while(!exitBackToMain){
            switch (scanner.nextInt()){
                case 1:
                    System.out.print("New First Name: ");
                    employee.setFirstName(scanner.nextLine());
                case 2:
                    System.out.print("New Last Name: ");
                    employee.setLastName(scanner.nextLine());
                case 3:
                    System.out.print("New Address: ");
                    employee.setAddress(scanner.nextLine());
                case 4:
                    System.out.print("New Phone Number: ");
                    employee.setPhoneNumber(scanner.nextLine());
                case 0:
                    exitBackToMain = true;
                    break;
            }
            Controller.updateEmployeeList();
        }


    }

    private void changeEmployeeSalary() {
        String employeeId, newSalary;
        System.out.print("enter the employee id: ");
        employeeId = scanner.nextLine();
        System.out.print("New Salary: ");
        newSalary = scanner.nextLine();
        System.out.println(Controller.changeEmployeeSalary(employeeId, newSalary).toString());
        System.out.println("Salary Is Changed!");
    }

    private void insertNewEmployeeToCompany() {
        System.out.println("Insert New Employee To Company EHRP System:");
        Controller.newEmployee();
    }

    private void deleteEmployeeFromCompany() {
        System.out.print("enter the employee id: ");
        Controller.deleteEmployeeById(scanner.nextLine());
    }

    public void showAllEmployees() {
        System.out.println("All Employees In Company: ");
        Controller.getEmployeeList().forEach(System.out::println);
    }

    private void showAllTasks() {
        System.out.println("All Tasks In Company: ");
        Controller.getAllTasks().forEach(System.out::println);
    }

    private void getEmployeeCard() {
        System.out.print("Enter Employee id: ");
        System.out.println(Controller.getEmployeeByID(scanner.nextLine()).toString());
    }

    private void showTasksForEmployee(String employeeId) {
        System.out.println("Your Tasks: ");
        Controller.getTasksForEmployee(employeeId).forEach(System.out::println);
    }

    private void createTaskForEmployee() {
        System.out.println("enter Id to create him Task:");
        System.out.println(Controller.createTaskForEmployeeById(scanner.nextLine()).toString());
        System.out.println("New Task Created!");
    }
}
