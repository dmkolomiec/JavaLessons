package task4;

public class Main {
    public static void main(String[] args) {
        Student1 student1 = new Student1("Дима");
        System.out.println(student1);

        Student2 student2 = new Student2(false, "Надя", new CourseProvider("ITVDN"));

        student2.setProvider(new CourseProvider("CyberBionic Systematics Education System"));
        student2.addCourse(new Course(1, "Java Starter"));
        student2.addCourse(new Course(2, "Java Essential"));
        student2.addCourse(new Course(3, "Java Advanced"));

        System.out.println(student2);
    }
}
