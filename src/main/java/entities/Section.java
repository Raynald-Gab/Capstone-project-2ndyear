package entities;

import java.util.ArrayList;

public class Section {

    private String sectionName;
    private int maxCapacity;
    private Instructor instructor;
    private ArrayList<Student> enrolledStudents;

    public Section(String sectionName, int maxCapacity) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public ArrayList<Student> getEnrolledStudents() { return enrolledStudents; }
}