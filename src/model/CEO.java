package model;

public class CEO extends Employee{
    TeamLeader[] teamLeaders;

    public TeamLeader[] getTeamLeaders() {
        return teamLeaders;
    }

    public void setTeamLeaders(TeamLeader[] teamLeaders) {
        this.teamLeaders = teamLeaders;
    }
}
