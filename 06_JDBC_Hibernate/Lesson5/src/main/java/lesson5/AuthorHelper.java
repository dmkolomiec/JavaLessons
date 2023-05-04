/**
 * Задание 2
 * <p> <p>
 * Настроить логирование для проекта с дополнительным заданием.
 */
package lesson5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import lesson5.entity.Author;

public class AuthorHelper {
    private static EntityManager em;
    private static final Logger logger = LogManager.getLogger(AuthorHelper.class);

    public AuthorHelper(HibernateUtil hu) {
        em = hu.em;
        logger.info(getClass().getName() + " START !!!");
    }

    public long addAuthor(Author author) {

        em.getTransaction().begin();

        if (author.getId() == 0) em.persist(author);
        else em.merge(author); // во избежание ошибки: detached entity passed to persist: lesson5.entity.Author
        em.getTransaction().commit();

        logger.info("addAuthor : " + author.getId());
        return author.getId();
    }

    @SuppressWarnings("unchecked")
    public List<Author> getAuthorList() {
//        Query query = em.createQuery("SELECT Author FROM Author author");
//        return (List<Author>) query.getResultList();

        // этап подготовки запроса
        CriteriaBuilder cb = em.getCriteriaBuilder();  // объект-конструктор запросов для Criteria API
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class); // первостепенный, корневой entity (в sql запросе - from)
        cq.select(root); // необязательный оператор, если просто нужно получить все значения

        // cq.orderBy(cb.asc(root.get("name"))); // сортировка по к."name"

        //этап выполнения запроса
        Query query = em.createQuery(cq);

        logger.info("getAuthorList");
        logger.info(query.getResultList());
        return query.getResultList();
    }

    public Author getAuthorById(long id) {
        Author author = em.find(Author.class, id);

        logger.info("getAuthorById");
        logger.info(author);
        return author;
    }

    public boolean updateAuthorById(Author author) {
        return addAuthor(author) != 0;
    }

    public void addAuthorBulk(int count) {

        int i;
        em.getTransaction().begin();
        for (i = 1; i <= count; i++) {
            em.persist(new Author("Name №" + i, "Lastname №" + i));
            if (i % 10 == 0) {
                em.flush();
                logger.info("addAuthorBulk " + i);
            }
        }
        em.getTransaction().commit();
        logger.info("addAuthorBulk " + i);
    }
}
