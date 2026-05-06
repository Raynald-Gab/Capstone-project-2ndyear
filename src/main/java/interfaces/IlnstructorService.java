package interfaces;

import entities.Instructor;
import entities.Section;
import java.util.ArrayList;

public interface IlnstructorService {
    void addInstructor(Instructor instructor);
    void assignInstructorToSection(Instructor instructor, Section sec);
    void assignInstructor(Instructor instructor, Section section);
    void getInstructorDetails(String instructorId);
    ArrayList<Instructor> getAllInstructors();
    Instructor findInstructorById(String instructorId);
}