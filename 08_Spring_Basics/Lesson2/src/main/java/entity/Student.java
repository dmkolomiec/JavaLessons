package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
public class Student {

    private boolean gender;
    private String name;
    private CourseProvider provider;
    private Map<Integer, Course> courses;

    public Student(String name, CourseProvider provider) {
        this.name = name;
        this.provider = provider;
        this.courses = new HashMap<>();
    }

    public Student(String name, CourseProvider provider, Map<Integer, Course> courses) {
        this.name = name;
        this.provider = provider;
        this.courses = courses;
    }

    public void init() {
        gender = true;
    }

    public void addCourse(Course course) {
        try {
            getCourses().put(Collections.max(getCourses().keySet()) + 1, course);
        } catch (NoSuchElementException e) {
            getCourses().put(1, course);
        }
    }

    @Autowired
    public void setCourses(Map<Integer, Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", provider=" + provider +
                ", courses=" + courses +
                '}';
    }

}
