package model;

import java.util.Date;

public class Employee extends Person {
    String employeeId;
    Date startDate;
    String salary;
    int numOfTasks;
    static int employeeCount;

    public Employee() {
        startDate = new Date();
        employeeId = "" + ++employeeCount;
        numOfTasks = 0;
    }

    public String toString() {
        return super.toString() +
                "\n--Employee card information--\n"
                + "#Employee Id: " + employeeId + "\n"
                + "#Your Start Date in Company: " + startDate + '\n'
                + "#Your Salary: " + salary + '\n'
                + "#Num Of Tasks: " + numOfTasks + '\n';
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

    public Employee setNumOfTasks(int numOfTasks) {
        this.numOfTasks = numOfTasks;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
