/**
 *
 */
package lesson6.task3;

import lesson6.AuthorHelper;
import lesson6.BookHelper;
import lesson6.HibernateUtil;
import lesson6.entity.Author;
import lesson6.entity.Book;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        HibernateUtil hu = new HibernateUtil("lesson6-persistence-unit");
        AuthorHelper ah = new AuthorHelper(hu);
        BookHelper bh = new BookHelper(hu);

        // Вставка списка в таблицу БД
        List<Author> list = List.of(
                new Author(1, "Герберт", "Шилдт"),
                new Author(2, "Брюс", "Еккєль"),
                new Author(3, "Джошуа", "Блох"));

        list.forEach(ah::addAuthor);

        // Добавить книги
        bh.addBook((new Book("Java 8. Полное руководство", list.get(0)))); // 0. Шилдт
        bh.addBook((new Book("Java Руководство для начинающих", list.get(0)))); // 0. Шилдт
        bh.addBook((new Book("Java Библиотека профессионала, том 1", list.get(1)))); // 1. Хорстман
        bh.addBook((new Book("Java Эффективное программирование", list.get(2)))); // 2. Блох

        // загрузить книги из таблицы в список
        System.out.println("\n===== Список книг после вставки =====");
        bh.getBookList().forEach(System.out::println);

        long id = 3;
        System.out.println("\n===== Удаление книги с Id = " + id + " =====");
        bh.deleteById(id);

        // Удалить все книги автора с заданным Id
        id = 1;
        System.out.println("===== Удаление всех книг автора с Id = " + id + " =====");
        bh.deleteBooksByAuthorId(id);

        System.out.println("\n===== Список книг после удалений =====");
        bh.getBookList().forEach(System.out::println);

        hu.close();
    }
}
