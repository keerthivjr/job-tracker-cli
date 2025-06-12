package dao;

import model.Job;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    // Insert new job
    public boolean addJob(Job job) {
        String sql = "INSERT INTO jobs (company_name, role, status, applied_date, deadline) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, job.getCompanyName());
            ps.setString(2, job.getRole());
            ps.setString(3, job.getStatus());
            ps.setDate(4, job.getAppliedDate());
            ps.setDate(5, job.getDeadline());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // View all jobs
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs";
        try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Job job = new Job(
                    rs.getInt("id"),
                    rs.getString("company_name"),
                    rs.getString("role"),
                    rs.getString("status"),
                    rs.getDate("applied_date"),
                    rs.getDate("deadline")
                );
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    // Update status
    public boolean updateStatus(int id, String newStatus) {
        String sql = "UPDATE jobs SET status = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newStatus);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete job
    public boolean deleteJob(int id) {
        String sql = "DELETE FROM jobs WHERE id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
