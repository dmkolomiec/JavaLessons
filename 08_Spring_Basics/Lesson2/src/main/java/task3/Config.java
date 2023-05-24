package task3;

import entity.Course;
import entity.CourseProvider;
import entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    public Course course1() {
        return new Course(1, "Java Starter");
    }

    @Bean
    public Course course2() {
        return new Course(2, "Java Essential");
    }

    @Bean
    public Course course3() {
        return new Course(3, "Java Advanced");
    }

    @Bean
    public CourseProvider providerCbs() {
        return new CourseProvider("CyberBionic Systematics Education System");
    }

    @Bean
    public CourseProvider providerItvdn() {
        return new CourseProvider("Information Technology Video Development Network");
    }

    @Bean
    public Map<Integer, Course> getCourses() {
        Map<Integer, Course> coursesMap = new HashMap<>();
        coursesMap.put(1, course1());
        coursesMap.put(2, course2());
        coursesMap.put(3, course3());
        return coursesMap;
    }

    @Bean
    public Student student1() {
        return new Student("Дима", providerCbs(), getCourses());
    }

    /** У Наді поле Courses ініціалізується за допомогою:
     *  @see Student#setCourses(Map) ()
     *  Але це не точно.
     */
    @Bean
    public Student student2() {
        return new Student("Надя", providerItvdn());
    }

    @Bean(initMethod = "init")
    public Student student3() {
        Student student = new Student();
        student.setName("Максим");
        student.setProvider(providerCbs());
        student.setCourses(getCourses());
        return student;
    }
}
