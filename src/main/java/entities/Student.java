package entities;

import java.util.Arraylist;

public class Student {

    private String StudentID;
    private String name;
    private String email;
    private double balance;

    public Student(String StudentID, String name, String email, double balance) {
        this.StudentID = StudentID;
        this.name = name;
        this.email = email;
        this.balance = balance = 0.0;

    }
    public String getStudentID() {
        return StudentID;
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
