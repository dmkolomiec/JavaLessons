/** Задание 5
 *      Из пакета ex_002_select_where написать отдельный метод для выборки по поиску выражения
 *      и в пакете ex_003_delete методы createCriteria и createCriteriaLogic переписать правильно.
 */
package lesson6.task5;

import lesson6.HibernateUtil;
import lesson6.entity.Author;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HibernateUtil hu = new HibernateUtil("lesson6-persistence-unit");
        AuthorHelper2 ah = new AuthorHelper2(hu);

        List<Author> loadList = List.of(
                new Author("Georg", "Push"),
                new Author("Alexander", "Pushkin "),
                new Author("Karl Theodor", "Jaspers"),

                new Author("First1", "Noname"),
                new Author("Secon1d", "Anonym"),

                new Author("Unknown author", "Jaspers2"),
                new Author("Mikhail", "Lermontov"),
                new Author("Mikhail", "Lermontoff"));

        loadList.forEach(ah::addAuthor);

        System.out.println("===== Список авторов после вставки в БД =====");
        ah.getAuthorList().forEach(System.out::println);


        System.out.println("\n===== getAuthorList_ex_002_select_where(). =====");
        ah.getAuthorList_ex_002_select_where().forEach(System.out::println);


        ah.deleteCriteria();
        ah.deleteCriteriaLogic();

        System.out.println("\n===== Список авторовв в БД после двух удалений =====");
        ah.getAuthorList().forEach(System.out::println);
    }
}
