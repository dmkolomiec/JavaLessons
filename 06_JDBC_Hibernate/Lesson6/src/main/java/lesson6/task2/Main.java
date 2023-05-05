/** Задание 2
 * Обновить поле name для всех записей, у которых длина значения поля last_name больше 7
 * В поле name записать значение «1»
 */
package lesson6.task2;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lesson6.AuthorHelper;
import lesson6.HibernateUtil;
import lesson6.entity.Author;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        HibernateUtil hu = new HibernateUtil("lesson6-persistence-unit");
        AuthorHelper ah = new AuthorHelper(hu);

        // Вставка списка в таблицу БД
        List<Author> list = List.of(
                new Author(1, "Герберт", "Шилдт"),
                new Author(2, "Брюс", "Еккєль_Більше_7"),
                new Author(3, "Джошуа", "Блох"));

        list.forEach(ah::addAuthor);

        System.out.println("===== Список авторов после вставки в БД =====");
        ah.getAuthorList().forEach(System.out::println);

        CriteriaBuilder cb = hu.em.getCriteriaBuilder();
        CriteriaUpdate<Author> cu = cb.createCriteriaUpdate(Author.class);
        Root<Author> root = cu.from(Author.class);

        // update author a set a.name = '1' where character_length(a.last_name) > 7
        cu.where(cb.gt(cb.length(root.get("lastName")),7));
        cu.set(root.get("name"),  "1");

        //этап выполнения запроса
        hu.em.getTransaction().begin();
        Query query = hu.em.createQuery(cu);
        query.executeUpdate();
        hu.em.getTransaction().commit();

        // Какого-то фига после обновления данные не перечитываются
        hu.close();
        hu = new HibernateUtil("lesson6-persistence-unit");
        ah = new AuthorHelper(hu);

        System.out.println("===== Список авторов после обновления БД =====");
        ah.getAuthorList().forEach(System.out::println);

        hu.close();
    }
}
