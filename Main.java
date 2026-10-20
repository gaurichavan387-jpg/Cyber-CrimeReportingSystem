
import java.util.Scanner;
import model.Citizen;
import model.Complaint;
import model.ComplaintProcessor;
import model.InvalidComplaintException;
import model.Officer;
import model.Person;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComplaintService service = new ComplaintService();

        try {
            System.out.println("\n1. Register a Complaint");
            System.out.println("2. View Saved Complaints");
            System.out.print("Enter your choice: ");

            int menuChoice = Integer.parseInt(sc.nextLine());

            if (menuChoice == 2) {
                service.viewComplaints();
                return;
            } else if (menuChoice != 1) {
               System.out.println("Invalid menu choice.");
                return;
            }

            System.out.println("==================================");
            System.out.println("   CYBER CRIME REPORTING SYSTEM");
            System.out.println("==================================");

            try {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();

                System.out.print("Enter your contact number: ");
                String contact = sc.nextLine();

                System.out.println("\nSelect Cybercrime Type:");
                System.out.println("1. UPI Fraud");
                System.out.println("2. Phishing");
                System.out.println("3. Hacking");
                System.out.println("4. Identity Theft");
                System.out.println("5. Cyberbullying");
                System.out.println("6. Online Shopping Fraud");
                System.out.println("7. Other");

                System.out.print("Enter choice (1-7): ");
                int choice = Integer.parseInt(sc.nextLine());

                String crimeType;

                switch (choice) {
                    case 1:
                        crimeType = "UPI Fraud";
                        break;
                    case 2:
                        crimeType = "Phishing";
                        break;
                    case 3:
                        crimeType = "Hacking";
                        break;
                    case 4:
                        crimeType = "Identity Theft";
                        break;
                    case 5:
                        crimeType = "Cyberbullying";
                        break;
                    case 6:
                        crimeType = "Online Shopping Fraud";
                        break;
                    case 7:
                        System.out.print("Enter crime type: ");
                        crimeType = sc.nextLine();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        return;
                }

                System.out.print("Describe what happened: ");
                String description = sc.nextLine();

                System.out.print("Evidence file path (press Enter to skip): ");
                String evidencePath = sc.nextLine();

                if (evidencePath.trim().isEmpty()) {
                    evidencePath = "Not provided";
                }

                String complaintId =
                        "CCR" + System.currentTimeMillis();

                Complaint complaint = new Complaint(
                        complaintId,
                        name,
                        contact,
                        crimeType,
                        description,
                        evidencePath
                );

                // User-defined exception validation
                   complaint.validateComplaint();

                System.out.println("Complaint validation successful.");
                
            // Abstract class test
            System.out.println("\n--- ABSTRACT CLASS TEST ---");
            complaint.showReportId();
            complaint.displayReportType();

            // Interface test
            System.out.println("\n--- INTERFACE TEST ---");
            complaint.trackComplaint(complaintId);

            // Test 1: Method Overloading
            System.out.println("\n--- METHOD OVERLOADING ---");
            complaint.displayDetails("Complaint Information");
            complaint.displayDetails(false);

            // Test 2: Method Overriding and Runtime Polymorphism
            System.out.println("\n--- METHOD OVERRIDING ---");

            Person person1 = new Citizen(name, contact);
            Person person2 = new Officer(
                    "Cyber Crime Officer",
                    "Not provided",
                    "OFF101"
            );

            System.out.println("\n--- RUNTIME POLYMORPHISM ---");
            person1.showRole();
            person2.showRole();

            System.out.println("\nComplaint registered successfully!");
            complaint.displayDetails();

                service.saveComplaint(complaint);
                
            // Multithreading
            ComplaintProcessor processor =
                    new ComplaintProcessor(complaintId);
            new Thread(processor).start();

                System.out.println("\nSave your Complaint ID: " + complaintId);

            }catch (NumberFormatException e) {
           System.out.println("Please enter a valid number.");
            } catch (InvalidComplaintException e) {
            System.out.println("Validation Error: " + e.getMessage());
          } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
   }
        } finally {
            sc.close();
        }
    }
}