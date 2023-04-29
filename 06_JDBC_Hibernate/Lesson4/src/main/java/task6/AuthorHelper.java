package task6;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import task6.entity.Author;

/**
 * Created by Asus on 01.11.2017.
 */
public class AuthorHelper {
    private final SessionFactory sessionFactory;
    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList() {
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);
        cq.select(root);
        List<Author> authorList = session.createQuery(cq).getResultList();

        session.close();
        return authorList;
    }

    public Author getAuthorById(long id) {
        Session session = sessionFactory.openSession();
        return session.get(Author.class, id);
    }

    public long addAuthor(Author author) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(author); // сгенерит ID и вставит в объект
        session.getTransaction().commit();

        session.close();
        return author.getId();
    }

}
