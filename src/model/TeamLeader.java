package model;

public class TeamLeader extends Employee {
    Employee[] employeesTeam;

    public Employee setEmployeesTeam(Employee[] employeesTeam) {
        this.employeesTeam = employeesTeam;
        return this;
    }
}
