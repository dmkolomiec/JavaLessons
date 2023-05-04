/**
 * Задание 2
 * Настроить логирование для проекта с дополнительным заданием.
 * Задание 4
 * К дополнительному заданию добавить метод обновления имени автора по id.
 * (То, что было на уроке, только реализовать это правильно).
 * Аналогично сделать и в классе BookHelper с предыдущего ДЗ.
 * Задание 5*
 * В классе BookHelper создать метод, который получает название книг и имя автора.
 */
package lesson5.task2_4_5;

import lesson5.AuthorHelper;
import lesson5.BookHelper;
import lesson5.HibernateUtil;
import lesson5.entity.Author;
import lesson5.entity.Book;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        HibernateUtil hu = new HibernateUtil("lesson5-persistence-unit");

        AuthorHelper ah = new AuthorHelper(hu);

        // Вставка списка в таблицу БД
        List<Author> list = List.of(
                new Author(1, "Герберт", "Шилдт"),
                new Author(2, "Брюс", "Еккєль"),
                new Author(3, "Джошуа", "Блох"));

        list.forEach(ah::addAuthor);

        // загрузить авторов из таблицы в список
        System.out.println("===== Список после вставки =====");
        ah.getAuthorList().forEach(System.out::println);

        // Найти автора по Id
        long id = 2;
        Author author = ah.getAuthorById(id);
        if (author != null) {
            System.out.println("===== Автор c Id = " + id + " =====");
            System.out.println(author);

            // Обновить автора по Id
            author.setName("Кей");
            author.setLastName("Хортсман");

            System.out.println("===== Обновление автора c Id = " + id + " =====");
            System.out.println(ah.updateAuthorById(author));

            System.out.println("===== Список после обновления =====");
            ah.getAuthorList().forEach(System.out::println);
        } else System.out.println("===== Автор c Id = " + id + " не найден =====");

        BookHelper bh = new BookHelper(hu);

        // Добавить книги
        bh.addBook((new Book("Java 8. Полное руководство", list.get(0)))); // 0. Шилдт
        bh.addBook((new Book("Java Руководство для начинающих", list.get(0)))); // 0. Шилдт
        bh.addBook((new Book("Java Эффективное программирование", list.get(2)))); // 2. Блох

        System.out.println("\n\n===== Список книг после добавления  =====");
        bh.getBookList().forEach(System.out::println);

        // Найти книгу
        id = 3;
        Book book = bh.getBookById(id);
        if (book != null) {
            System.out.println("===== Книга c Id = " + id + " =====");
            System.out.println(book);

            // Обновить книгу по Id
            book.setName("Effective Java");

            System.out.println("===== Обновление книги c Id = " + id + " =====");
            System.out.println(bh.updateBookById(book));

            System.out.println("===== Список книг после обновления =====");
            bh.getBookList().forEach(System.out::println);
        } else System.out.println("===== Книга c Id = " + id + " не найдена =====");

        hu.close();
    }
}
