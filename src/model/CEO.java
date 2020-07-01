package model;

public class CEO extends Employee{
    int[] teamLeadersIds;

    public int[] getTeamLeadersIds() {
        return teamLeadersIds;
    }

    public void setTeamLeadersIds(int[] teamLeadersIds) {
        this.teamLeadersIds = teamLeadersIds;
    }
}
