import entities.Course;
import entities.Student;
import services.TuitionServicelmpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TuitionServiceTest {

    @Test
    public void testCalculateFee_CorrectAmount() {
        Student student = new Student("S01", "Juan", "juan@email.com");
        Course course = new Course("IT101", "Intro to IT", 3);
        TuitionServicelmpl service = new TuitionServicelmpl();
        double fee = service.calculateFee(student, course);
        assertEquals(4500.0, fee);
    }

    @Test
    public void testMakePayment_ReducesBalance() {
        Student student = new Student("01", "Juan", "juan@email.com");
        Course course = new Course("IT101", "Intro to IT", 3);
        TuitionServicelmpl service = new TuitionServicelmpl();
        service.calculateFee(student, course);
        service.makePayment(student, 2000.0);
        assertEquals(2500.0, service.getRemainingBalance(student));
    }
}
