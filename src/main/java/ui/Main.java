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

    static int studentCounter = 1;
    static final int TOTAL_UNITS = 23; // 3+3+3+3+3+3+2+3
    static final double RATE_PER_UNIT = 1500.0;
    static final double TOTAL_TUITION = TOTAL_UNITS * RATE_PER_UNIT; // P34,500

    static Department ccs = new Department("College of Information Technology");
    static Section IT2C = new Section("IT2C", 40);
    static Section IT2A = new Section("IT2A", 30);
    static Section IT2B = new Section("IT2B", 30);
    static Section IT2D = new Section("IT2D", 30);

    public static void main(String[] args) {
        ccs.addSection(IT2A);
        ccs.addSection(IT2B);
        ccs.addSection(IT2C);
        ccs.addSection(IT2D);

        courseService.addCourse(new Course("INFOMAN", "Information Management", 3));
        courseService.addCourse(new Course("INTEPROG", "Integrative Programming", 3));
        courseService.addCourse(new Course("SYSDE", "System Development", 3));
        courseService.addCourse(new Course("ITELECT", "IT Elective", 3));
        courseService.addCourse(new Course("INFASEC", "Information Assurance & Security", 3));
        courseService.addCourse(new Course("DISMATH", "Discrete Mathematics", 3));
        courseService.addCourse(new Course("PE", "Physical Education", 2));
        courseService.addCourse(new Course("LINUSYST", "Linux System", 3));

        instructorService.addInstructor(new Instructor("T01", "Ms. Vanessa", "CIT"));
        instructorService.addInstructor(new Instructor("T02", "Sir Febbraio", "CIT"));
        instructorService.addInstructor(new Instructor("T03", "Sir Dennis", "CIT"));
        instructorService.addInstructor(new Instructor("T04", "Sir Michael", "CIT"));
        instructorService.addInstructor(new Instructor("T05", "Sir Miguel", "CIT"));
        instructorService.addInstructor(new Instructor("T06", "Catherine", "CIT"));
        instructorService.addInstructor(new Instructor("T07", "TBA", "CIT"));

        int choice = -1;
        do {
            System.out.println("\n===== ENROLLMENT SYSTEM =====");
            System.out.println("[1] Manage Students");
            System.out.println("[2] View Courses & Professors");
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
                case 2: viewCoursesAndProfs(); break;
                case 3: instructorMenu(); break;
                case 4: enrollMenu(); break;
                case 5: viewDepartment(); break;
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
                System.out.print("Name: "); String name = sc.nextLine().trim();
                System.out.print("Email: "); String email = sc.nextLine().trim();
                String id = "DLSL-2025-" + String.format("%04d", studentCounter++);
                System.out.println("========================================");
                System.out.println("  Student Successfully Registered!");
                System.out.println("  Student ID : " + id);
                System.out.println("  Name       : " + name);
                System.out.println("  Email      : " + email);
                System.out.println("========================================");
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
                else {
                    System.out.println("\n-- All Students --");
                    for (Student s : list) System.out.println("  " + s);
                }
            }
        } catch (NumberFormatException e) { System.out.println("Invalid input!"); }
    }

    static void viewCoursesAndProfs() {
        System.out.println("\n========================================");
        System.out.println("   SUBJECTS & PROFESSORS — ALL SECTIONS");
        System.out.println("========================================");
        System.out.println("  INFOMAN  - Information Management         (3 units) | Sir Dennis");
        System.out.println("  INTEPROG - Integrative Programming        (3 units) | Sir Miguel");
        System.out.println("  SYSDE    - System Development             (3 units) | Ms. Vanessa");
        System.out.println("  ITELECT  - IT Elective                    (3 units) | Sir Michael");
        System.out.println("  INFASEC  - Info Assurance & Security      (3 units) | Sir Febbraio");
        System.out.println("  DISMATH  - Discrete Mathematics           (3 units) | Ms. Vanessa");
        System.out.println("  PE       - Physical Education             (2 units) | Catherine");
        System.out.println("  LINUSYST - Linux System                   (3 units) | TBA");
        System.out.println("----------------------------------------");
        System.out.println("  Total Units : " + TOTAL_UNITS + " units");
        System.out.println("  Total Fee   : P" + TOTAL_TUITION);
        System.out.println("========================================");
    }

    static void instructorMenu() {
        System.out.println("\n-- INSTRUCTOR MANAGEMENT --");
        System.out.println("[1] View All Instructors");
        System.out.println("[2] View Instructor Details");
        System.out.print("Choice: ");
        try {
            int c = Integer.parseInt(sc.nextLine().trim());
            if (c == 1) {
                System.out.println("\n-- INSTRUCTORS & SUBJECTS --");
                System.out.println("  [T01] Ms. Vanessa  - Intprog, Sysde");
                System.out.println("  [T02] Sir Febbraio - Infasec");
                System.out.println("  [T03] Sir Dennis   - Infoman");
                System.out.println("  [T04] Sir Michael  - ITelect");
                System.out.println("  [T05] Sir Miguel   - Inteprog");
                System.out.println("  [T06] Catherine    - PE");
                System.out.println("  [T07] TBA          - Linusyst");
            } else if (c == 2) {
                System.out.print("Instructor ID (e.g. T01): "); String id = sc.nextLine().trim();
                instructorService.getInstructorDetails(id);
            }
        } catch (NumberFormatException e) { System.out.println("Invalid input!"); }
    }

    static void viewDepartment() {
        System.out.println("\n========================================");
        System.out.println("  DEPARTMENT: " + ccs.getDeptName());
        System.out.println("========================================");

        for (Section section : ccs.getSections()) {
            System.out.println("\n  [SECTION] " + section.getSectionName()
                    + " (" + section.getEnrolledStudents().size()
                    + "/" + section.getMaxCapacity() + " students)");

            System.out.println("  Subjects & Professors:");
            System.out.println("    - INFOMAN  | Sir Dennis");
            System.out.println("    - INTEPROG | Sir Miguel");
            System.out.println("    - SYSDE    | Ms. Vanessa");
            System.out.println("    - ITELECT  | Sir Michael");
            System.out.println("    - INFASEC  | Sir Febbraio");
            System.out.println("    - DISMATH  | Ms. Vanessa");
            System.out.println("    - PE       | Catherine");
            System.out.println("    - LINUSYST | TBA");

            System.out.println("  Enrolled Students:");
            if (section.getEnrolledStudents().isEmpty()) {
                System.out.println("    - No students enrolled yet.");
            } else {
                for (Student s : section.getEnrolledStudents()) {
                    System.out.println("    - " + s);
                }
            }
        }
        System.out.println("\n========================================");
    }

    static void enrollMenu() {
        System.out.println("\n-- ENROLL STUDENT --");
        System.out.print("Student ID (e.g. DLSL-2025-0001): "); String sid = sc.nextLine().trim();
        Student student = studentService.findStudentById(sid);
        if (student == null) { System.out.println("Student not found!"); return; }
        System.out.println("Available Sections: IT2A, IT2B, IT2C, IT2D");
        System.out.print("Section: "); String sname = sc.nextLine().trim();
        Section sec;
        if (sname.equalsIgnoreCase("IT2A")) sec = IT2A;
        else if (sname.equalsIgnoreCase("IT2B")) sec = IT2B;
        else if (sname.equalsIgnoreCase("IT2C")) sec = IT2C;
        else sec = IT2D;
        try {
            enrollmentService.enrollStudentInSection(student, sec);
        } catch (SectionFullException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    static void tuitionMenu() {
        System.out.println("\n-- TUITION AND PAYMENT --");
        System.out.println("[1] Calculate Total Fee  [2] Make Payment  [3] Check Balance");
        System.out.print("Choice: ");
        try {
            int c = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Student ID (e.g. DLSL-2025-0001): "); String sid = sc.nextLine().trim();
            Student student = studentService.findStudentById(sid);
            if (student == null) { System.out.println("Student not found!"); return; }

            if (c == 1) {student.setBalance(TOTAL_TUITION);
                System.out.println("========================================");
                System.out.println("  TUITION FEE BREAKDOWN");
                System.out.println("========================================");
                System.out.println("  INFOMAN  - 3 units x P1,500 = P4,500");
                System.out.println("  INTEPROG - 3 units x P1,500 = P4,500");
                System.out.println("  SYSDE    - 3 units x P1,500 = P4,500");
                System.out.println("  ITELECT  - 3 units x P1,500 = P4,500");
                System.out.println("  INFASEC  - 3 units x P1,500 = P4,500");
                System.out.println("  DISMATH  - 3 units x P1,500 = P4,500");
                System.out.println("  PE       - 2 units x P1,500 = P3,000");
                System.out.println("  LINUSYST - 3 units x P1,500 = P4,500");
                System.out.println("----------------------------------------");
                System.out.println("  Total Units : " + TOTAL_UNITS + " units");
                System.out.println("  TOTAL FEE   : P" + TOTAL_TUITION);
                System.out.println("========================================");
            } else if (c == 2) {
                System.out.println("Current Balance: P" + student.getBalance());
                System.out.print("Payment Amount: P");
                double amount = Double.parseDouble(sc.nextLine().trim());
                tuitionService.makePayment(student, amount);
            } else if (c == 3) {
                System.out.println("========================================");
                System.out.println("  Student  : " + student.getName());
                System.out.println("  Balance  : P" + tuitionService.getRemainingBalance(student));
                System.out.println("========================================");
            }
        } catch (NumberFormatException e) { System.out.println("Invalid input!"); }
    }
}