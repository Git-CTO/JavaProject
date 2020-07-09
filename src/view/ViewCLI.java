package view;

import controller.Controller;

import java.util.Scanner;

public class ViewCLI {
    public void initView(){
        Scanner scanner = new Scanner(System.in);
        new Login().loginAuthenticateUser();
        System.out.println("Insert New Employee To Company EHRP System:");
        System.out.println(Controller.newEmployee().toString());
        showAllEmployees();
        System.out.println("enter Id to create him Task:");
        System.out.println(Controller.createTaskForEmployeeById(scanner.nextLine()).toString());
        showAllEmployees();
    }

    public void showAllEmployees(){
        System.out.println("All Employees In Company: ");
        Controller.getEmployeeList().forEach(System.out::println);
    }
}
