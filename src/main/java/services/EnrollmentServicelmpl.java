package services;

import entities.Department;
import entities.Section;
import entities.Student;
import exceptions.SectionFullException;
import interfaces.IEnrollmentService;

public class EnrollmentServicelmpl implements IEnrollmentService {

    @Override
    public void enrollStudentInSection(Student student, Section section)
            throws SectionFullException {
        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            throw new SectionFullException("Enrollment failed: " + section.getSectionName() + " is full! (" + section.getMaxCapacity() + "/" + section.getMaxCapacity() + ")");
        }
        section.getEnrolledStudents().add(student);
        System.out.println(student.getName() + " successfully enrolled in " + section.getSectionName());
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        System.out.println("\n========================================");
        System.out.println("  DEPARTMENT: " + department.getDeptName());
        System.out.println("========================================");

        if (department.getSections().isEmpty()) {
            System.out.println("  No sections available.");
            return;
        }

        for (Section section : department.getSections()) {
            System.out.println("\n  [SECTION] " + section.getSectionName()
                    + " (" + section.getEnrolledStudents().size()
                    + "/" + section.getMaxCapacity() + " students)");

            if (section.getInstructor() != null) {
                System.out.println("  Instructor: " + section.getInstructor().getName());
            } else {
                System.out.println("  Instructor: TBA");
            }

            System.out.println("  Students:");
            if (section.getEnrolledStudents().isEmpty()) {
                System.out.println("    - No students enrolled yet.");
            } else {
                for (Student s : section.getEnrolledStudents()) {
                    System.out.println("    - " + s);
                }
            }
        }
        System.out.println("========================================\n");
    }
}