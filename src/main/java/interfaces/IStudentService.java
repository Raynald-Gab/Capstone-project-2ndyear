package interfaces;

import entities.Student;
import java.util.ArrayList;

public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(String studentId, String newName, String newEmail);
    void removeStudent(String studentId);
    ArrayList<Student> getAllStudents();
    Student findStudentById(String studentId);
}