package model;

import util.ePriority;
import util.eStatus;

import java.util.Date;

public class Task {
    private Date startDate;
    private Date endDate;
    private eStatus status;
    private ePriority priority;
    private String details;
    private String projectName;
    private String employeeId;

    public Task() {
        startDate = new Date();
    }

    public String toString() {
        return
                "Employee Id: " + employeeId + "\n"
                        + "Start Date: " + startDate + "\n"
                        + "End Date: " + endDate + "\n"
                        + "Priority: " + priority + "\n"
                        + "Details: " + details + "\n"
                        + "Project Name: " + projectName + "\n"
                        + "Status: " + status + "\n";
    }


    public Task setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }


    public Task setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Task setStatus(eStatus status) {
        this.status = status;
        return this;
    }


    public Task setPriority(ePriority priority) {
        this.priority = priority;
        return this;
    }

    public Task setDetails(String details) {
        this.details = details;
        return this;
    }

    public Task setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
