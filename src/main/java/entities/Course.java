package entities;

public class Course {
    private String courseCode;
    private String courseName;
    private int units;

    public Course(String courseCode, String courseName, int units) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.units = units;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }
    public String toString() {
        return courseCode + " - " + courseName + " (" + units + " units)";
    }
}
