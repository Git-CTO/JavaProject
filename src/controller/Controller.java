package controller;

import builder.EmployeeBuilder;
import database.DataService;
import model.Employee;
import view.EmployeeCreationUi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    public static Employee newEmployee(){
        Employee employee = EmployeeBuilder.builder(new EmployeeCreationUi().getInputFromUserToCreateEmployee());
        DataService.addEmployee(employee);

        return employee;
    }

    public static Employee getEmployeeByID(String employeeId){
        List<Employee> employeeByIdList = getEmployeeList().stream().filter(
                employee -> employee.getPersonalId() == employeeId || employee.getEmployeeId()== employeeId)
        .collect(Collectors.toList());

        return employeeByIdList.get(0);
    }

    public static List<Employee> getEmployeeList() {
        return DataService.takeDataFromDb();
    }

}
