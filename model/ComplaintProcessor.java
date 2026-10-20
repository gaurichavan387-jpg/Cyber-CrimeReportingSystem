
package model;

public class ComplaintProcessor extends Thread {

    private String complaintId;

    public ComplaintProcessor(String complaintId) {
        this.complaintId = complaintId;
    }

    @Override
    public void run() {
        System.out.println(
            "\n[Background Thread] Processing complaint: "
            + complaintId
        );

        try {
            Thread.sleep(2000);

            System.out.println(
                "[Background Thread] Complaint processing check completed."
            );

        } catch (InterruptedException e) {
            System.out.println("Complaint processing was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}