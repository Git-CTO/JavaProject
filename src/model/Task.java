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
    private String Details;
    private String projectName;

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
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
