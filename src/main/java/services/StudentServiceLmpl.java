package services;

import entities.Student;
import interfaces.IStudentService;
import java.util.ArrayList;

public class StudentServiceLmpl implements IStudentService {

    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println("Error: Student ID " + student.getStudentId() + " already exists!");
                return;
            }
        }
        students.add(student);
        System.out.println("Student added successfully: " + student.getName());
    }

    @Override
    public void updateStudent(String studentId, String newName, String newEmail) {
        Student s = findStudentById(studentId);
        if (s != null) {
            s.setName(newName);
            s.setEmail(newEmail);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Error: Student ID " + studentId + " not found!");
        }
    }

    @Override
    public void removeStudent(String studentId) {
        Student s = findStudentById(studentId);
        if (s != null) {
            students.remove(s);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Error: Student ID " + studentId + " not found!");
        }
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student findStudentById(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }
}