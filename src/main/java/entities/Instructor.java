package entities;

public class Instructor {

    private String instructorId;
    private String name;
    private String department;

    public Instructor(String instructorId, String name, String department) {
        this.instructorId = instructorId;
        this.name = name;
        this.department = department;
    }

    public String getInstructorId() { return instructorId; }
    public void setInstructorId(String instructorId) { this.instructorId = instructorId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String toString() {
        return "[" + instructorId + "] Prof. " + name;
    }
}