  package model;

import java.util.Date;

public class Employee extends Person {
    String employeeId;
    Date startDate;
    String salary;
    int numOfTasks;

    public Employee(){
        startDate = new Date();
    }

    public String toString(){
        return super.toString() +
                "Employee Id: " + employeeId + "\n"
                + "Your Start Date in Company: " + startDate + '\n'
                + "Your Salary: " + salary + '\n'
                + "Num Of Task: " + numOfTasks + '\n';
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Employee setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Employee setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public Employee setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public int getNumOfTasks() {
        return numOfTasks;
    }

    public Employee setNumOfTasks(int numOfTasks) {
        this.numOfTasks = numOfTasks;
        return this;
    }
}
