package lesson5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

import lesson5.entity.*;


public class BookHelper {

    private static EntityManager em;

    public BookHelper(HibernateUtil hu) {
        em = hu.em;
    }

    public long addBook(Book book) {

        em.getTransaction().begin();
        if (book.getId() == 0) em.persist(book);
        else em.merge(book); // во избежание ошибки: detached entity passed to persist: lesson5.entity.Book
        em.getTransaction().commit();

        return book.getId();
    }

    @SuppressWarnings("unchecked")
    public List<Book> getBookList() {
//        Query query = em.createQuery("SELECT Book FROM Book book");
//        return (List<Book>) query.getResultList();

        // этап подготовки запроса
        CriteriaBuilder cb = em.getCriteriaBuilder();  // объект-конструктор запросов для Criteria API
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class); // первостепенный, корневой entity (в sql запросе - from)
        cq.select(root); // необязательный оператор, если просто нужно получить все значения

        //cq.orderBy(cb.asc(root.get("name"))); // сортировка по к."name"

        //этап выполнения запроса
        Query query = em.createQuery(cq);

        return query.getResultList();
    }

    public Book getBookById(long id) {
        return em.find(Book.class, id);
    }

    public boolean updateBookById(Book book) {
        return addBook(book) != 0;
    }

}
