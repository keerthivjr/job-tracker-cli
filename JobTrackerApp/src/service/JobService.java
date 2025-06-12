package service;

import dao.JobDAO;
import model.Job;

import java.sql.Date;
import java.util.List;

public class JobService {
    private JobDAO jobDAO = new JobDAO();

    public boolean addJob(String company, String role, String status, Date appliedDate, Date deadline) {
        Job job = new Job(company, role, status, appliedDate, deadline);
        return jobDAO.addJob(job);
    }

    public List<Job> getAllJobs() {
        return jobDAO.getAllJobs();
    }

    public boolean updateStatus(int id, String status) {
        return jobDAO.updateStatus(id, status);
    }

    public boolean deleteJob(int id) {
        return jobDAO.deleteJob(id);
    }
}
