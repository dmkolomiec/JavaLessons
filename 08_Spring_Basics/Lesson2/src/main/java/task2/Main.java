/**
 * Завдання 2
 * Створіть новий клас із будь-якої предметної області з кількома полями.
 * Деякі поля мають бути задані за допомогою конструктора, деякі – за допомогою setter-методу, а деякі – за допомогою методу init,
 * який ви маєте вказати під час оголошення біну в конфігурації.
 */
package task2;

import entity.Course;
import entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        List<Student> group = new ArrayList<>();

        group.add(ctx.getBean("student1", Student.class));

        group.add(ctx.getBean("student2", Student.class));
        group.get(1).addCourse(ctx.getBean("course1", Course.class));
        group.get(1).addCourse(ctx.getBean("course2", Course.class));
        group.get(1).addCourse(ctx.getBean("course3", Course.class));

        group.add(ctx.getBean("student3", Student.class));

        group.forEach(System.out::println);
    }
}
