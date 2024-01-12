package cloneable;

import java.util.ArrayList;
import java.util.List;

public class Cohort {
    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Mentor> mentors = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addMentor(Mentor mentor) {
        mentors.add(mentor);
    }

    public void info() {
        System.out.println("The "+ name + " cohort has " + students.size() + " students and " + mentors.size() + " mentors.");
    }

    public Cohort(String name) {
        this.name = name;
        students.clear();
        mentors.clear();
    }
}
