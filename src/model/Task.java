package model;

import util.ePriority;
import util.eStatus;

import java.util.Date;

public class Task {
    private int taskNum;
    private Date startDate;
    private Date endDate;
    private Date ActualDate = null;
    private eStatus status;
    private ePriority priority;
    private String details;
    private String projectName;
    
    public String toString(){
        return
                "Task Num: " + taskNum + "\n"
                + "Start Date: " + startDate + "\n"
                        + "End Date: " + endDate + "\n"
                        + "Priority: " + priority + "\n"
                        + "Details: " + details + "\n"
                        + "Project Name: " + projectName + "\n"
                        + "Status: " + status + "\n";
    }

    public int getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(int taskNum) {
        this.taskNum = taskNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getActualDate() {
        return ActualDate;
    }

    public void setActualDate(Date actualDate) {
        ActualDate = actualDate;
    }

    public eStatus getStatus() {
        return status;
    }

    public void setStatus(eStatus status) {
        this.status = status;
    }

    public ePriority getPriority() {
        return priority;
    }

    public void setPriority(ePriority priority) {
        this.priority = priority;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
