package view;

import controller.Controller;

public class ViewCLI {
    public void initView(){
        new Login().loginAuthenticateUser();
        System.out.println("Insert New Employee To Company EHRP System:");
        System.out.println(Controller.newEmployee().toString());
        System.out.println("All Employees In Company: ");
        showAllEmployees();
    }

    public void showAllEmployees(){
        Controller.getEmployeeList().forEach(employee -> System.out.println(employee.toString()));
    }
}
