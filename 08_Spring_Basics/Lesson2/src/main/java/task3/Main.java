/**
 * Завдання 3
 * Переведіть конфігурацію XML із Завдання 2 у конфігурацію Java.
 */
package task3;

import entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        List<Student> group = new ArrayList<>();
        group.add(ctx.getBean("student1", Student.class));
        group.add(ctx.getBean("student2", Student.class));
        group.add(ctx.getBean("student3", Student.class));

        group.forEach(System.out::println);
    }
}
