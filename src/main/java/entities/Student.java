package entities;

public class Student {

    private String StudentID;
    private String name;
    private String email;
    private double balance;

    public Student(String StudentID, String name, String email) {
        this.StudentID = StudentID;
        this.name = name;
        this.email = email;
        this.balance = balance = 0.0;

    }
    public String getStudentID() {
        return StudentID;
    }
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
        return "Student: " + StudentID + ", Name: " + name + ", Email: " + email;
    }

}
