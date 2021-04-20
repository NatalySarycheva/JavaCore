package JavaCore;

import java.util.ArrayList;
import java.util.List;

interface Student {
    String getName();

    List<Course> getAllCourses();
}

public class UniversityStudent implements Student {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public UniversityStudent(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courses;
    }
}

