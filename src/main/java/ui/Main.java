package ui;

import entities.*;
import exceptions.SectionFullException;
import interfaces.*;
import services.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static IStudentService studentService = new StudentServiceLmpl();
    static ICourseService courseService = new CourseServicelmpl();
    static IlnstructorService instructorService = new InstructorServicelmpl();
    static ITuitionService tuitionService = new TuitionServicelmpl();
    static IEnrollmentService enrollmentService = new EnrollmentServicelmpl();
    static Scanner sc = new Scanner(System.in);

    static Department ccs = new Department("College of Information Technology");
    static Section IT2C = new Section("IT2C", 40);
    static Section IT2A = new Section("IT2A", 30);
    static Section IT2B = new Section("IT2B", 30);
    static Section IT2D = new Section("IT2D", 30);

    public static void main(String[] args) {
        ccs.addSection(IT2C);
        ccs.addSection(IT2A);
        ccs.addSection(IT2B);
        ccs.addSection(IT2D);

        int choice = -1;
        do {
            System.out.println("\n===== ENROLLMENT SYSTEM =====");
            System.out.println("[1] Manage Students");
            System.out.println("[2] Manage Courses");
            System.out.println("[3] Manage Instructors");
            System.out.println("[4] Enroll Student in Section");
            System.out.println("[5] View Department Hierarchy");
            System.out.println("[6] Tuition and Payment");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {
                case 1: studentMenu(); break;
                case 2: courseMenu(); break;
                case 3: instructorMenu(); break;
                case 4: enrollMenu(); break;
                case 5: enrollmentService.viewDepartmentHierarchy(ccs); break;
                case 6: tuitionMenu(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void studentMenu() {
        System.out.println("\n-- STUDENT MANAGEMENT --");
        System.out.println("[1] Add  [2] Update  [3] Remove  [4] View All");
        System.out.print("Choice: ");
        try {
            int c = Integer.parseInt(sc.nextLine().trim());
            if (c == 1) {
                System.out.print("Student ID: "); String id = sc.nextLine().trim();
                System.out.print("Name: "); String name = sc.nextLine().trim();
                System.out.print("Email: "); String email = sc.nextLine().trim();
                studentService.addStudent(new Student(id, name, email));
            } else if (c == 2) {
                System.out.print("Student ID to update: "); String id = sc.nextLine().trim();
                System.out.print("New Name: "); String name = sc.nextLine().trim();
                System.out.print("New Email: "); String email = sc.nextLine().trim();
                studentService.updateStudent(id, name, email);
            } else if (c == 3) {
                System.out.print("Student ID to remove: "); String id = sc.nextLine().trim();
                studentService.removeStudent(id);
            } else if (c == 4) {
                ArrayList<Student> list = studentService.getAllStudents();
                if (list.isEmpty()) { System.out.println("No students found."); }
                else { for (Student s : list) System.out.println("  " + s); }
            }
        } catch (NumberFormatException e) { System.out.println("Invalid input!"); }
    }

    static void courseMenu() {
        System.out.println("\n-- COURSE MANAGEMENT --");
        System.out.println("[1] Add  [2] Update  [3] Remove  [4] View All");
        System.out.print("Choice: ");
        try {
            int c = Integer.parseInt(sc.nextLine().trim());
            if (c == 1) {
                System.out.print("Course Code: "); String code = sc.nextLine().trim();
                System.out.print("Course Name: "); String name = sc.nextLine().trim();
                System.out.print("Units: "); int units = Integer.parseInt(sc.nextLine().trim());
                courseService.addCourse(new Course(code, name, units));
            } else if (c == 2) {
                System.out.print("Course Code to update: "); String code = sc.nextLine().trim();
                System.out.print("New Name: "); String name = sc.nextLine().trim();
                System.out.print("New Units: "); int units = Integer.parseInt(sc.nextLine().trim());
                courseService.updateCourse(code, name, units);
            } else if (c == 3) {
                System.out.print("Course Code to remove: "); String code = sc.nextLine().trim();
                courseService.removeCourse(code);
            } else if (c == 4) {
                ArrayList<Course> list = courseService.getAllCourses();
                if (list.isEmpty()) { System.out.println("No courses found."); }
                else { for (Course course : list) System.out.println("  " + course); }
            }
        } catch (NumberFormatException e) { System.out.println("Invalid input!"); }
    }

    static void instructorMenu() {
        System.out.println("\n-- INSTRUCTOR MANAGEMENT --");
        System.out.println("[1] Add  [2] Assign to Section  [3] View Details  [4] View All");
        System.out.print("Choice: ");
        try {
            int c = Integer.parseInt(sc.nextLine().trim());
            if (c == 1) {
                System.out.print("Instructor ID: "); String id = sc.nextLine().trim();
                System.out.print("Name: "); String name = sc.nextLine().trim();
                System.out.print("Department: "); String dept = sc.nextLine().trim();
                instructorService.addInstructor(new Instructor(id, name, dept));
            } else if (c == 2) {
                System.out.print("Instructor ID: "); String id = sc.nextLine().trim();
                Instructor instructor = instructorService.findInstructorById(id);
                if (instructor == null) { System.out.println("Instructor not found!"); return; }
                System.out.println("Sections: IT2C, IT2A, IT2B, IT2D");
                System.out.print("Section: "); String sname = sc.nextLine().trim();
                Section sec;
                if (sname.equalsIgnoreCase("IT2C")) sec = IT2C;
                else if (sname.equalsIgnoreCase("IT2A")) sec = IT2A;
                else if (sname.equalsIgnoreCase("IT2B")) sec = IT2B;
                else sec = IT2D;
                instructorService.assignInstructorToSection(instructor, sec);
            } else if (c == 3) {
                System.out.print("Instructor ID: "); String id = sc.nextLine().trim();
                instructorService.getInstructorDetails(id);
            } else if (c == 4) {
                ArrayList<Instructor> list = instructorService.getAllInstructors();
                if (list.isEmpty()) { System.out.println("No instructors found."); }
                else { for (Instructor i : list) System.out.println("  " + i); }
            }
        } catch (NumberFormatException e) { System.out.println("Invalid input!"); }
    }

    static void enrollMenu() {
        System.out.println("\n-- ENROLL STUDENT --");
        System.out.print("Student ID: "); String sid = sc.nextLine().trim();
        Student student = studentService.findStudentById(sid);
        if (student == null) { System.out.println("Student not found!"); return; }
        System.out.println("Sections: IT2C, IT2A, IT2B, IT2D");
        System.out.print("Section: "); String sname = sc.nextLine().trim();
        Section sec;
        if (sname.equalsIgnoreCase("IT2C")) sec = IT2C;
        else if (sname.equalsIgnoreCase("IT2A")) sec = IT2A;
        else if (sname.equalsIgnoreCase("IT2B")) sec = IT2B;
        else sec = IT2D;
        try {
            enrollmentService.enrollStudentInSection(student, sec);
        } catch (SectionFullException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    static void tuitionMenu() {
        System.out.println("\n-- TUITION AND PAYMENT --");
        System.out.println("[1] Calculate Fee  [2] Make Payment  [3] Check Balance");
        System.out.print("Choice: ");
        try {
            int c = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Student ID: "); String sid = sc.nextLine().trim();
            Student student = studentService.findStudentById(sid);
            if (student == null) { System.out.println("Student not found!"); return; }

            if (c == 1) {
                System.out.print("Course Code: "); String code = sc.nextLine().trim();
                Course course = courseService.findCourseByCode(code);
                if (course == null) { System.out.println("Course not found!"); return; }
                tuitionService.calculateFee(student, course);
            } else if (c == 2) {
                System.out.print("Payment Amount: P");
                double amount = Double.parseDouble(sc.nextLine().trim());
                tuitionService.makePayment(student, amount);
            } else if (c == 3) {
                System.out.println("Remaining Balance: P" + tuitionService.getRemainingBalance(student));
            }
        } catch (NumberFormatException e) { System.out.println("Invalid input!"); }
    }
}