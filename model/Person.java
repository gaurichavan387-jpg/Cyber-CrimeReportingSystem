
package model;

public class Person {

    private String name;
    private String contact;

    public Person(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
    }

    
    public void showRole() {
        System.out.println("Role: General Person");
    }
}