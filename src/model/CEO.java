package model;

import util.eRole;

import java.util.List;

public class CEO extends Employee implements ITask{
    List<String> teamLeadersIds;

    public CEO(){
        role = eRole.CEO;
    }

    public void setTeamLeadersIds(List<String> teamLeadersIds) {
        this.teamLeadersIds = teamLeadersIds;
    }

    public void addTeamLeaderId(String teamLeaderId){
        teamLeadersIds.add(teamLeaderId);
    }
    public List<String> getTeamLeadersIds() {
        return teamLeadersIds;
    }

    @Override
    public Task createTask(String id) {
        return null;
    }
}
