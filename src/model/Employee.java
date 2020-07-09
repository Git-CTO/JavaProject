package model;

import util.eRole;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee extends Person {
    String employeeId;
    Date startDate;
    String salary;
    List<Task> taskList;
    eRole role;


    public Employee() {
        startDate = new Date();
        role = eRole.junior;
        taskList = new ArrayList<>();
    }

    public String toString() {
        return super.toString() +
                "\n--Employee card information--\n"
                + "#Employee Id: " + employeeId + "\n"
                + "#Your Start Date in Company: " + startDate + '\n'
                + "#Your Salary: " + salary + '\n'
                + "#Num Of Tasks: " + 0 + '\n';
    }

    public Employee setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Employee setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Employee setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Employee setRole(eRole role) {
        this.role = role;
        return this;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

}
