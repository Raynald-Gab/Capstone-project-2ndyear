package entities;

import java.util.ArrayList;

public class Section {
    private String sectionName;
    private int maxCapacity;
    private Instructor instructor;
    private ArrayList<Student> enrolledStudents;

    public Section(String sectionName, int maxCapacity, Instructor instructor) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new  ArrayList<>();
    }

    public String getSectionName() {
        return sectionName;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }



}
