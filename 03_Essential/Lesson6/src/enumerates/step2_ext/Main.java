// Завдання 2. Назва тварини українською

package enumerates.step2_ext;

import java.util.Arrays;

enum AnimalsExt {
    BEAR(20, "Ведмідь"), WOLF(5, "Вовк"), BISON(10, "Зубр"), BOAR(8, "Кабан");
    private final int age;
    private final String name;

    AnimalsExt(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s (%d років)", this.name, this.age);
    }
}

public class Main {
    public static void main(String[] args) {
        Arrays.asList(AnimalsExt.values()).forEach(animal -> System.out.println(animal.toString()));
    }
}
