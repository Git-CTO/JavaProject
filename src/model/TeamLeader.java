package model;

public class TeamLeader extends Employee {
    Employee[] employeesTeam;

    public Employee[] getEmployeesTeam() {
        return employeesTeam;
    }

    public void setEmployeesTeam(Employee[] employeesTeam) {
        this.employeesTeam = employeesTeam;
    }
}
