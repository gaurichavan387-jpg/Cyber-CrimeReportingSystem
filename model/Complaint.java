

package model;

public class Complaint extends Report implements Trackable {

    

    // Data hiding: private fields
    private String complaintId;
    private String complainantName;
    private String contact;
    private String crimeType;
    private String description;
    private String evidencePath;
    private String status;

    // Constructor: accepts details entered by the user
    public Complaint(String complaintId,
                     String complainantName,
                     String contact,
                     String crimeType,
                     String description,
                     String evidencePath) {
                        super(complaintId);

        this.complaintId = complaintId;
        this.complainantName = complainantName;
        this.contact = contact;
        this.crimeType = crimeType;
        this.description = description;
        this.evidencePath = evidencePath;
        this.status = "SUBMITTED";
    }

    // Getter methods
    public String getComplaintId() {
        return complaintId;
    }

    public String getComplainantName() {
        return complainantName;
    }

    public String getContact() {
        return contact;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public String getDescription() {
        return description;
    }

    public String getEvidencePath() {
        return evidencePath;
    }

    public String getStatus() {
        return status;
    }

    // Update complaint status
    public void updateStatus(String status) {
        this.status = status;
    }

    // Display complaint details
    public void displayDetails() {
        System.out.println("\n===== COMPLAINT DETAILS =====");
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("Name: " + complainantName);
        System.out.println("Contact: " + contact);
        System.out.println("Crime Type: " + crimeType);
        System.out.println("Description: " + description);
        System.out.println("Evidence Path: " + evidencePath);
        System.out.println("Status: " + status);
    }
    
    // Method Overloading 1
    public void displayDetails(String message) {
        System.out.println("\n" + message);
        displayDetails();
    }

    // Method Overloading 2
    public void displayDetails(boolean showDescription) {
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("Crime Type: " + crimeType);

        if (showDescription) {
            System.out.println("Description: " + description);
        }
    }
    
    @Override
    public void displayReportType() {
        System.out.println("Report Type: Cyber Crime Complaint");
    }

    @Override
    public void trackComplaint(String complaintId) {
        if (this.complaintId.equals(complaintId)) {
            System.out.println("Complaint Status: " + status);
        } else {
            System.out.println("Complaint not found.");
        }
    }
    
    public void validateComplaint() throws InvalidComplaintException {

    // Check 1: name must not be empty
    if (complainantName == null || complainantName.trim().isEmpty()) {
        throw new InvalidComplaintException(
            "Complainant name cannot be empty."
        );
    }

    // Check 2 (NEW): name must have only letters and spaces
    if (!complainantName.matches("[A-Za-z ]+")) {
        throw new InvalidComplaintException(
            "Name must contain only letters and spaces."
        );
    }

    // Check 3 (NEW): name must have at least 3 characters
    if (complainantName.trim().length() < 3) {
        throw new InvalidComplaintException(
            "Name must be at least 3 characters long."
        );
    }

    // Check 4: contact must be exactly 10 digits
    if (contact == null || !contact.matches("[0-9]{10}")) {
        throw new InvalidComplaintException(
            "Contact number must contain exactly 10 digits."
        );
    }

    // Check 5: description must not be empty
    if (description == null || description.trim().isEmpty()) {
        throw new InvalidComplaintException(
            "Complaint description cannot be empty."
        );
    }
}
}