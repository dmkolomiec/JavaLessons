package task4;

import java.util.Set;
import java.util.TreeSet;

public class Student2 {

    private boolean gender;
    private String name;
    private Set<Course> courses = new TreeSet<>();

    private CourseProvider provider;

    public Student2(boolean gender, String name, CourseProvider provider) {
        this.gender = gender;
        this.name = name;
        this.provider = provider;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        getCourses().add(course);
    }

    public CourseProvider getProvider() {
        return provider;
    }

    public void setProvider(CourseProvider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                ", provider=" + provider +
                '}';
    }
}
