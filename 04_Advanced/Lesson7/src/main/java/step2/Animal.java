package step2;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    private AnimalKind kind;
    private String breed;
    private int age;
    private boolean gender;
    private String name;

    public Animal(AnimalKind kind, String breed, int age, boolean gender, String name) {
        this.kind = kind;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public AnimalKind getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return "Animal{" + "kind=" + kind + ", breed=" + breed + ", age=" + age + ", gender=" + (gender ? "male" : "female") + ", name='" + name + '\'' + '}';
    }
}

