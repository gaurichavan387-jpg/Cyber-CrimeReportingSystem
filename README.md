# gaurichavStart
  |
  v
Show menu: 1. Register a Complaint / 2. View Saved Complaints
  |
  |-- Choice 2 --> Read complaints.txt --> Display all complaints --> End
  |
  `-- Choice 1
        |
        v
Enter name, contact, crime type (1-7), description, evidence path
        |
        v
Generate complaint ID (CCR + timestamp)
        |
        v
Create Complaint object (status = SUBMITTED)
        |
        v
Validate complaint
        |-- Invalid --> Show "Validation Error" --> End (nothing saved)
        |
        `-- Valid
              |
              v
Show OOP demonstrations (abstract class, interface, overloading, polymorphism)
              |
              v
Save complaint to complaints.txt
              |
              v
Start background thread (processing message, 2 second wait, completion message)
              |
              v
Display Complaint ID --> Endan

