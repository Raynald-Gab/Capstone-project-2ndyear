package services;

import entities.Course;
import entities.Student;
import interfaces.ITuitionService;

public class TuitionServicelmpl implements ITuitionService {

    private static final double RATE_PER_UNIT = 1500.0;

    @Override
    public double calculateFee(Student student, Course course) {
        double fee = course.getUnits() * RATE_PER_UNIT;
        student.setBalance(student.getBalance() + fee);
        System.out.println("Fee calculated: P" + fee);
        return fee;
    }

    @Override
    public void makePayment(Student student, double amount) {
        if (amount <= 0) {
            System.out.println("Error: Invalid payment amount!");
            return;
        }
        student.setBalance(student.getBalance() - amount);
        System.out.println("Payment accepted! Remaining balance: P" + student.getBalance());
    }

    @Override
    public double getRemainingBalance(Student student) {
        return student.getBalance();
    }
}