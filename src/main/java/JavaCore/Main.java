package JavaCore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Course math = new UniversityCourse("Math");
        Course biology = new UniversityCourse("Biology");
        Course chemistry = new UniversityCourse("Chemistry");

        UniversityStudent student1 = new UniversityStudent("Oleg");
        student1.addCourse(math);
        student1.addCourse(chemistry);

        UniversityStudent student2 = new UniversityStudent("Maria");
        student2.addCourse(biology);

        UniversityStudent student3 = new UniversityStudent("Petr");
        student3.addCourse(biology);
        student3.addCourse(chemistry);

        UniversityStudent student4 = new UniversityStudent("Anna");
        student4.addCourse(math);
        student4.addCourse(biology);
        student4.addCourse(chemistry);

        List<Student> students = List.of(student1, student2, student3, student4);

        System.out.println("Uniq Courses:");
        uniqCoursesFor(students).stream().map(Course::getName).forEach(System.out::println);
        System.out.println();

        System.out.println("Top Three Curious:");
        topThreeCurious(students).stream().map(Student::getName).forEach(System.out::println);
        System.out.println();

        System.out.println("Subscribed To Course:");
        subscribedToCourse(students, math).stream().map(Student::getName).forEach(System.out::println);
        System.out.println();
    }

    public static Set<Course> uniqCoursesFor(List<Student> students) {
        HashSet<Course> result = new HashSet<Course>();
        students.stream().map(Student::getAllCourses).forEach(result::addAll);
        return result;
    }

    public static List<Student> topThreeCurious(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> {
                    int s1Size = s1.getAllCourses().size();
                    int s2Size = s2.getAllCourses().size();

                    if (s1Size > s2Size) {
                        return -1;
                    } else if (s1Size < s2Size) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> subscribedToCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}
