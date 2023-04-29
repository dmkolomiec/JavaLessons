package task6;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import task6.entity.Book;

import java.util.List;

public class BookHelper {

    private final SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Book addBook(Book book) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(book); // сгенерит ID и вставит в объект
        session.getTransaction().commit();
        session.close();
        return book;
    }

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);
        List<Book>  bookList = session.createQuery(cq).getResultList();

        session.close();
        return bookList;
    }



}
