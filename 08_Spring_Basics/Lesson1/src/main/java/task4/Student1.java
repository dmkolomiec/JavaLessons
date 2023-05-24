package task4;

import java.util.ArrayList;

public class Student1 {

    private boolean gender;
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    private CourseProvider provider;

    public Student1(String name) {
        gender = true;
        this.name = name;
        courses.add(new Course(1, "Java Starter"));
        courses.add(new Course(2, "Java Essential"));
        courses.add(new Course(3, "Java Advanced"));

        provider = new CourseProvider("ITVDN");
    }

    @Override
    public String toString() {
        return "Student1{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                ", provider=" + provider +
                '}';
    }
}
