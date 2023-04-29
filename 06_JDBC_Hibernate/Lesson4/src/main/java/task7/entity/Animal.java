package task7.entity;


import jakarta.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String name;
    private boolean tail;

    public Animal() {
    }

    public Animal(int age, String name, boolean tail) {
        this.age = age;
        this.name = name;
        this.tail = tail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + ", вік " + age + ", хвіст " + (tail ? "присутній" : "відсутній");
    }
}
