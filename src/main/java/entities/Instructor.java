package entities;

public class Instructor {
    private String instructorID;
    private String name;
    private String department;

    public Instructor(String instructorID, String name, String department) {
        this.instructorID = instructorID;
        this.name = name;
        this.department = department;
    }
    public String getInstructorID() {
        return instructorID;
    }
    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String toString(){
        return "{" + instructorID + ", " + name + ", " + department + "}";
    }

}
