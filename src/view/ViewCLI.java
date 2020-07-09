package view;

import controller.Controller;
import model.Employee;
import util.eRole;

import java.util.Scanner;

public class ViewCLI {
    static Scanner scanner = new Scanner(System.in);

    public void initView(){
        String employeeId = new Login().loginAuthenticateUser();
        eRole role = Controller.loginToSystemByEmployeeId(employeeId);

        switch(role){
            case TeamLeader:
                System.out.println("1- show team");
                System.out.println("1- show tasks");
                System.out.println("1- change personal details");
            case MinorWorker:
                System.out.println("1- show tasks");
                System.out.println("1- change personal details");
                break;
            case CEO:
            case Root:
                System.out.println("1- Add Employee To Company");
                System.out.println("todooooo- delete Employee From Company");
                System.out.println("2- Show All Employees Cards");
                System.out.println("todoooo- Change Salary To Employee");
                System.out.println("3- Show All Tasks In Company");
                System.out.println("Get Employee Card And His Tasks");
                selectActionForRoot(scanner.nextInt());
                break;
        }
        insertNewEmployeeToCompany();
        System.out.println("enter Id to create him Task:");
        System.out.println(Controller.createTaskForEmployeeById(scanner.nextLine()).toString());
        showAllEmployees();
    }

    private void selectActionForRoot(int actionNumber) {
        switch (actionNumber){
            case 1:
                insertNewEmployeeToCompany();
                break;
            case 2:
                showAllEmployees();
                break;
            case 3:
                showAllTasks();
                break;
        }
    }

    private void insertNewEmployeeToCompany() {
        System.out.println("Insert New Employee To Company EHRP System:");
        Controller.newEmployee();
    }

    private void deleteEmployeeFromCompany(){
        System.out.print("enter the employee id: ");

    }

    public void showAllEmployees(){
        System.out.println("All Employees In Company: ");
        Controller.getEmployeeList().forEach(System.out::println);
    }

    private void showAllTasks(){
        System.out.println("All Tasks In Company: ");
        Controller.getAllTasks().forEach(System.out::println);
    }
}
