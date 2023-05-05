/**
 * Задание 2
 * <p> <p>
 * Настроить логирование для проекта с дополнительным заданием.
 */
package lesson6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lesson6.entity.Author;

import java.util.List;

public class AuthorHelper {
    protected static EntityManager em;

    public AuthorHelper(HibernateUtil hu) {
        em = hu.em;
    }

    public long addAuthor(Author author) {

        em.getTransaction().begin();

        if (author.getId() == 0) em.persist(author);
        else em.merge(author); // во избежание ошибки: detached entity passed to persist: lesson5.entity.Author
        em.getTransaction().commit();

        return author.getId();
    }

    public Author getAuthorById(long id) {

        return em.find(Author.class, id);
    }

    public boolean updateAuthorById(Author author) {
        return addAuthor(author) != 0;
    }

    public void delete(Author author) {
        em.getTransaction().begin();
        em.remove(author);
        em.getTransaction().commit();
    }

    public void deleteById(long authorId) {
        Author author = em.find(Author.class, authorId);
        if (author != null) {
            delete(author);
        }
    }

    public void addAuthorBulk(int count) {

        em.getTransaction().begin();
        for (int i = 1; i <= count; i++) {
            em.persist(new Author("Name №" + i, "Lastname №" + i));
            if (i % 10 == 0) {
                em.flush();
            }
        }
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Author> getAuthorList() {
        CriteriaBuilder cb = em.getCriteriaBuilder();  // объект-конструктор запросов для Criteria API
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)
        cq.select(root); // необязательный оператор, если просто нужно получить все значения
        Query query = em.createQuery(cq);

        return query.getResultList();
    }
}
