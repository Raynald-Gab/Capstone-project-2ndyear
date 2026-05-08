package services;

import entities.Instructor;
import entities.Section;
import interfaces.IlnstructorService;
import java.util.ArrayList;

public class InstructorServicelmpl implements IlnstructorService {

    private ArrayList<Instructor> instructors = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        for (Instructor i : instructors) {
            if (i.getInstructorId().equals(instructor.getInstructorId())) {
                System.out.println("Error: Instructor ID " + instructor.getInstructorId() + " already exists!");
                return;
            }
        }
        instructors.add(instructor);
        System.out.println("Instructor added successfully: " + instructor.getName());
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section sec) {
        sec.setInstructor(instructor);
        System.out.println(instructor.getName() + " assigned to " + sec.getSectionName());
    }

    @Override
    public void assignInstructor(Instructor instructor, Section section) {
        section.setInstructor(instructor);
        System.out.println(instructor.getName() + " assigned to " + section.getSectionName());
    }

    @Override
    public void getInstructorDetails(String instructorId) {
        Instructor i = findInstructorById(instructorId);
        if (i != null) {
            System.out.println("ID: " + i.getInstructorId());
            System.out.println("Name: " + i.getName());
            System.out.println("Department: " + i.getDepartment());
        } else {
            System.out.println("Error: Instructor not found!");
        }
    }

    @Override
    public ArrayList<Instructor> getAllInstructors() { return instructors; }

    @Override
    public Instructor findInstructorById(String instructorId) {
        for (Instructor i : instructors) {
            if (i.getInstructorId().equals(instructorId)) return i;
        }
        return null;
    }
}