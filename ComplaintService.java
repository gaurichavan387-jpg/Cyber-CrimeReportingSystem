
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import model.Complaint;

public class ComplaintService {

    // Save a complaint to the file
    public void saveComplaint(Complaint complaint) {

        try (FileWriter writer =
                     new FileWriter("complaints.txt", true)) {

            writer.write("================================\n");
            writer.write("Complaint ID: "
                    + complaint.getComplaintId() + "\n");
            writer.write("Name: "
                    + complaint.getComplainantName() + "\n");
            writer.write("Contact: "
                    + complaint.getContact() + "\n");
            writer.write("Crime Type: "
                    + complaint.getCrimeType() + "\n");
            writer.write("Description: "
                    + complaint.getDescription() + "\n");
            writer.write("Evidence: "
                    + complaint.getEvidencePath() + "\n");
            writer.write("Status: "
                    + complaint.getStatus() + "\n\n");

            System.out.println("Complaint saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving complaint: "
                    + e.getMessage());
        }
    }

    // Display all saved complaints
    public void viewComplaints() {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("complaints.txt"))) {

            String line;
            boolean found = false;

            System.out.println("\n===== SAVED COMPLAINTS =====");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                found = true;
            }

            if (!found) {
                System.out.println("No complaints found.");
            }

        } catch (IOException e) {
            System.out.println(
                    "No saved complaints found yet."
            );
        }
    }
}