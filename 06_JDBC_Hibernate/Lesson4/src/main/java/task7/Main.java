package task7;

import task7.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Animal> list = new ArrayList<>() {{
            add(new Animal(10, "Мурзік", true));
            add(new Animal(8, "Собака-кусака", true));
            add(new Animal(3, "Мєконгський бобтейл", false));
        }};

        AnimalHelper ah = new AnimalHelper();
        list.forEach(ah::addAnimal);

        int id = list.get(list.size() - 1).getId();
        System.out.println("id останньї тварини = " + id);

        list.clear();

        list = ah.getAll();
        System.out.println("===== Список =====");
        list.forEach(System.out::println);

        System.out.println("===== Тварина з id= " + id + " =====");
        System.out.println(ah.getById(id));

        System.out.println("===== Видаленя тварини з id= " + id + " =====");
        ah.remove(ah.getById(id));
        list = ah.getAll();
        System.out.println("===== Список після видалення =====");
        list.forEach(System.out::println);

        ah.close();
    }
}
