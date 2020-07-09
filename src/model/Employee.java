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
    int numOfTask;


    public Employee() {
        startDate = new Date();
        role = eRole.MinorWorker;
        taskList = new ArrayList<>();
        numOfTask = 0;
    }

    public String toString() {
        return super.toString() +
                "\n--Employee card information--\n"
                + "#Employee Id: " + employeeId + "\n"
                + "#Your Start Date in Company: " + startDate + '\n'
                + "#Your Salary: " + salary + '\n'
                + "#Num Of Tasks: " + numOfTask + '\n'
                + "#Role: " + role + '\n';
    }

    public Employee setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public Employee addTask(Task task) {
        taskList.add(task);

        return this;
    }

    public Employee setNumOfTask(int numOfTask) {
        this.numOfTask = numOfTask;

        return this;
    }

    public int getNumOfTask() {
        return numOfTask;
    }

    public eRole getRole() {
        return role;
    }
}
