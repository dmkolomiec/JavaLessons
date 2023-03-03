/*
Завдання 5. пакет. Створити клас Animal з ім'ям String, int віком, хвостом Boolean. У класі перевизначити метод toString,
            щоб висновок був наступним «Ім'я: Васька, вік: 45, хвіст: ні». У класі Animal перевизначити методи equals & hashCode.
 */
package step5;

import java.util.Objects;

public class Animal implements Cloneable {
    private final String name;
    private final boolean tail;
    private int age;

    public Animal(String name, int age, boolean tail) {
        this.name = name;
        this.age = age;
        this.tail = tail;
    }

    public Animal(Animal clone) {
        this(clone.name, clone.age, clone.tail);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Animal cat = new Animal("Васька", 45, false), dog = new Animal("Стрєлка", 5, true);

        cat.print();
        dog.print();

        System.out.println("\n" + cat.getName() + ".equals(" + dog.getName() + ") = " + cat.equals(dog));

        Animal dogClone1 = (Animal) dog.clone();  // Клонування в.1
        Animal dogClone2 = new Animal(dog);      // Клонування в.2

        dogClone1.print("========= Клон №1", dog);
        dogClone2.print("========= Клон №2", dog);

        // клон №2 змінився
        dogClone2.changeAge();
        dogClone2.print("========= Клон №2(змін.)", dog);

    }

    public String getName() {
        return name;
    }

    public String getNameWAddr() {
        return name + "{" + super.toString() + "}";
    }

    public int changeAge() {
        return ++this.age;
    }

    @Override
    public String toString() {
        return String.format("Ім'я: %s, вік: %d, хвіст: %s", name, age, tail ? "так" : "ні");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        if (tail != animal.tail) return false;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        int result = 17 + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (tail ? 1 : 0);
        return result;
    }

    public void print() {
        System.out.println(this);
        System.out.println("hashcode = " + hashCode());
    }

    public void print(String title, Animal otherAnimal) {
        System.out.println(title);
        this.print();
        System.out.println(this.getNameWAddr() + ".equals(" + otherAnimal.getNameWAddr() + ") = " + this.equals(otherAnimal));
    }
}
