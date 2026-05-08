package services;

import entities.Course;
import interfaces.ICourseService;
import java.util.ArrayList;

public class CourseServicelmpl implements ICourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        for (Course c : courses) {
            if (c.getCourseCode().equals(course.getCourseCode())) {
                return; // silent, no print
            }
        }
        courses.add(course);
    }

    @Override
    public void updateCourse(String courseCode, String newName, int newUnits) {
        Course c = findCourseByCode(courseCode);
        if (c != null) {
            c.setCourseName(newName);
            c.setUnits(newUnits);
            System.out.println("Course updated successfully!");
        } else {
            System.out.println("Error: Course " + courseCode + " not found!");
        }
    }

    @Override
    public void removeCourse(String courseCode) {
        Course c = findCourseByCode(courseCode);
        if (c != null) {
            courses.remove(c);
            System.out.println("Course removed successfully!");
        } else {
            System.out.println("Error: Course " + courseCode + " not found!");
        }
    }

    @Override
    public ArrayList<Course> getAllCourses() { return courses; }

    @Override
    public Course findCourseByCode(String courseCode) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) return c;
        }
        return null;
    }
}