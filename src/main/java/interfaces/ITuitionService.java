package interfaces;

import entities.Student;
import entities.Course;

public interface ITuitionService {
    double calculateFee(Student student, Course course);
    void makePayment(Student student, double amount);
    double getRemainingBalance(Student student);
}
