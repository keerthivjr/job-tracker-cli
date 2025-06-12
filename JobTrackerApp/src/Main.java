import service.JobService;
import model.Job;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final JobService jobService = new JobService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Job Tracker Menu ===");
            System.out.println("1. Add Job");
            System.out.println("2. View All Jobs");
            System.out.println("3. Update Job Status");
            System.out.println("4. Delete Job");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addJob();
                case 2 -> viewJobs();
                case 3 -> updateStatus();
                case 4 -> deleteJob();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void addJob() {
        System.out.print("Enter Company Name: ");
        String company = scanner.nextLine();
        System.out.print("Enter Role: ");
        String role = scanner.nextLine();
        System.out.print("Enter Status (Applied/Interview/Rejected/Offer): ");
        String status = scanner.nextLine();
        System.out.print("Enter Applied Date (yyyy-mm-dd): ");
        String applied = scanner.nextLine();
        System.out.print("Enter Deadline (yyyy-mm-dd): ");
        String deadline = scanner.nextLine();

        boolean success = jobService.addJob(company, role, status, Date.valueOf(applied), Date.valueOf(deadline));
        System.out.println(success ? "Job added successfully." : "Failed to add job.");
    }

    private static void viewJobs() {
        List<Job> jobs = jobService.getAllJobs();
        if (jobs.isEmpty()) {
            System.out.println("No jobs found.");
            return;
        }
        System.out.printf("%-5s %-20s %-20s %-15s %-15s %-15s\n", "ID", "Company", "Role", "Status", "Applied", "Deadline");
        for (Job job : jobs) {
            System.out.printf("%-5d %-20s %-20s %-15s %-15s %-15s\n",
                    job.getId(), job.getCompanyName(), job.getRole(), job.getStatus(),
                    job.getAppliedDate(), job.getDeadline());
        }
    }

    private static void updateStatus() {
        System.out.print("Enter Job ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new status: ");
        String status = scanner.nextLine();
        boolean success = jobService.updateStatus(id, status);
        System.out.println(success ? "Status updated." : "Failed to update status.");
    }

    private static void deleteJob() {
        System.out.print("Enter Job ID to delete: ");
        int id = scanner.nextInt();
        boolean success = jobService.deleteJob(id);
        System.out.println(success ? "Job deleted." : "Failed to delete job.");
    }
}
