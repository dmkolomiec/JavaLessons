/**
 * Завдання 4. Створіть 2 класи, Animal та Cat. У класі Animal ініціалізуйте 3 поля різних модифікаторів.
 * У класі Cat використовуючи рефлексію, отримайте доступ до полів класу Animal та змініть вміст кожного з полів.
 **/
package step4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class Animal {
    private static int counter = 0;
    protected final int id;

    private final String name;
    protected final int age;
    final boolean gender;

    public Animal(String name, boolean gender, int age) {
        this.id = ++counter;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}

class Cat extends Animal {
    public Cat(String name, boolean gender, int age) {
        super(name, gender, age);
    }

    public Cat(String name, boolean gender) {
        super(name, gender, -1);
    }

    @Override
    public String toString() {
        return "№" + id + ". " + getName() + ", " + (age == -1 ? "вік невідомий" : age + " років") + ", стать:" + (gender ? "кіт" : "кішка");
    }

    void reflectiveUpdate() throws NoSuchFieldException, IllegalAccessException {

        Class<?> sc = this.getClass().getSuperclass();

        Field name = sc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(this, "Матільда");

        Field age = sc.getDeclaredField("age");
        age.setAccessible(true);
        age.setInt(this, 5);

        Field gender = sc.getDeclaredField("gender");
        gender.setAccessible(true);
        gender.setBoolean(this, false);
    }
}

public class Main {
    public static void main(String[] args) {
        Class<?> c = Cat.class;

        Class<?>[] paramTypes;
        Constructor<?> constructor;

        try {
            // перший кіт
            paramTypes = new Class<?>[]{String.class, boolean.class, int.class};
            constructor = c.getConstructor(paramTypes);
            Cat cat1 = (Cat) constructor.newInstance("Рижик", true, 4);
            System.out.println(cat1 + "\n");

            // другий кіт --> кішка
            paramTypes = new Class<?>[]{String.class, boolean.class};
            constructor = c.getConstructor(paramTypes);
            Cat cat2 = (Cat) constructor.newInstance("Машка", true);

            System.out.println(cat2);
            cat2.reflectiveUpdate();
            System.out.println(cat2);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
