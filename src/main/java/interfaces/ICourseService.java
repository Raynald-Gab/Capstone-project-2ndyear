package interfaces;

import entities.Course;
import java.util.ArrayList;

public interface ICourseService {
    void addCourse(Course course);
    void updateCourse(String courseCode, String newName, int newUnits);
    void removeCourse(String courseCode);
    ArrayList<Course> getAllCourses();
    Course findCourseByCode(String courseCode);
}