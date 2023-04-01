/**
 * Завдання 3
 * Створити клас Book, зробити 3 поля та відповідні методи. Необхідно реалізувати замикання анонімного класу та лямбда-виразу.
 */
package step3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Effective Java (3rd Edition)", "Joshua Bloch", 392, 2017, 51_000),
                new Book("Java: The Complete Reference (12th Edition)", "Herbert Schildt", 1356, 2022, 52_000),
                new Book("Философія Java", "Брюс Еккель", 1168, 2012, 80_000),
                new Book("Core Java", "Сау S. Horstmann", 1850, 2014, 90000),
                new Book("Изучаем Java  на примерах и задачах", "Сеттер Р.В.", 240, 2016, 2000));

        books.forEach(System.out::println);
        System.out.println();

        Book.useLambda = true;

        books.forEach(System.out::println);

    }
}

