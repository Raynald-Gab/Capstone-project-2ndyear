package interfaces;

import entities.Student;
import entities.Section;
import entities.Department;
import exceptions.SectionFullException;

public interface IEnrollmentService {
    void enrollStudentInSection(Student student, Section section) throws SectionFullException;
    void viewDepartmentHierarchy(Department department);
}