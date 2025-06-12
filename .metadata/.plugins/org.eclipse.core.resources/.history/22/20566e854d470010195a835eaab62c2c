package model;

import java.sql.Date;

public class Job {
    private int id;
    private String companyName;
    private String role;
    private String status;
    private Date appliedDate;
    private Date deadline;

    // Constructors
    public Job() {}

    public Job(String companyName, String role, String status, Date appliedDate, Date deadline) {
        this.companyName = companyName;
        this.role = role;
        this.status = status;
        this.appliedDate = appliedDate;
        this.deadline = deadline;
    }

    public Job(int id, String companyName, String role, String status, Date appliedDate, Date deadline) {
        this.id = id;
        this.companyName = companyName;
        this.role = role;
        this.status = status;
        this.appliedDate = appliedDate;
        this.deadline = deadline;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getAppliedDate() { return appliedDate; }
    public void setAppliedDate(Date appliedDate) { this.appliedDate = appliedDate; }

    public Date getDeadline() { return deadline; }
    public void setDeadline(Date deadline) { this.deadline = deadline; }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Company: %s | Role: %s | Status: %s | Applied: %s | Deadline: %s",
            id, companyName, role, status, appliedDate, deadline
        );
    }
}
