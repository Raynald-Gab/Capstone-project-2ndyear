import entities.Section;
import entities.Student;
import exceptions.SectionFullException;
import services.EnrollmentServicelmpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentServiceTest {

    @Test
    public void testEnrollStudent_Success() {
        Section section = new Section("IT2C", 40);
        Student student = new Student("01", "Juan", "juan@email.com");
        EnrollmentServicelmpl service = new EnrollmentServicelmpl();
        assertDoesNotThrow(() -> service.enrollStudentInSection(student, section));
        assertEquals(1, section.getEnrolledStudents().size());
    }

    @Test
    public void testEnrollStudent_SectionFull_ThrowsException() {
        Section section = new Section("IT2C", 2);
        Student s1 = new Student("01", "Juan", "juan@email.com");
        Student s2 = new Student("02", "Maria", "maria@email.com");
        Student s3 = new Student("03", "Pedro", "pedro@email.com");
        EnrollmentServicelmpl service = new EnrollmentServicelmpl();
        assertDoesNotThrow(() -> service.enrollStudentInSection(s1, section));
        assertDoesNotThrow(() -> service.enrollStudentInSection(s2, section));
        assertThrows(SectionFullException.class,
                () -> service.enrollStudentInSection(s3, section));
    }

    @Test
    public void testEnrollStudent_SizeStaysAtMax() {
        Section section = new Section("IT2C", 2);
        Student s1 = new Student("01", "Juan", "juan@email.com");
        Student s2 = new Student("02", "Maria", "maria@email.com");
        Student s3 = new Student("03", "Pedro", "pedro@email.com");
        EnrollmentServicelmpl service = new EnrollmentServicelmpl();
        assertDoesNotThrow(() -> service.enrollStudentInSection(s1, section));
        assertDoesNotThrow(() -> service.enrollStudentInSection(s2, section));
        assertThrows(SectionFullException.class,
                () -> service.enrollStudentInSection(s3, section));
        assertEquals(2, section.getEnrolledStudents().size());
    }
}