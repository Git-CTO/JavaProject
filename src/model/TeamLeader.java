package model;

import builder.TaskBuilder;
import controller.Controller;
import util.eRole;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader extends Employee implements ITask{
    List<String> employeesTeamIds;

    public TeamLeader(){
        role = eRole.TeamLeader;
        employeesTeamIds = new ArrayList<>();
    }

    public void setEmployeesTeam(List<String> employeesTeamIds) {
        this.employeesTeamIds = employeesTeamIds;
    }

    public void addEmployeeToTeam(String employeeId){
        employeesTeamIds.add(employeeId);
    }

    public List<String> getEmployeesTeamIds() {
        return employeesTeamIds;
    }

    @Override
    public Task createTask(String id) {
        return Controller.createTaskForEmployeeById(id);
    }
}
