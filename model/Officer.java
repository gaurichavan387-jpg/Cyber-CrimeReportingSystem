
package model;

public class Officer extends Person {

    private String officerId;

    public Officer(String name, String contact, String officerId) {
        super(name, contact);
        this.officerId = officerId;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void handleComplaint() {
        System.out.println(
            "Officer can review cybercrime complaints."
        );
    }

    
    @Override
    public void showRole() {
        System.out.println("Role: Cyber Crime Officer");
    }
}