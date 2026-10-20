
package model;

public class Citizen extends Person {

    public Citizen(String name, String contact) {
        super(name, contact);
    }

    public void reportCrime() {
        System.out.println(
            "Citizen can register a cybercrime complaint."
        );
    }
    
    @Override
    
    public void showRole() {
        System.out.println("Role: Citizen / Complainant");
    }
}