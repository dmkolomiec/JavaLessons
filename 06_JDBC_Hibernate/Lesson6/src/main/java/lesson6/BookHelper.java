package lesson6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lesson6.entity.*;

import java.util.List;


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
    public Book getBookById(long id) {
        return em.find(Book.class, id);
    }

    public boolean updateBookById(Book book) {
        return addBook(book) != 0;
    }

    public void delete(Book book) {
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }
    public void deleteById(long bookId) {
        Book book = em.find(Book.class, bookId);
        if (book != null) {
            delete(book);
        }
    }

    public void deleteBooksByAuthorId(long authorId) {
        // этап подготовки запроса
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Book> cd = cb.createCriteriaDelete(Book.class);
        Root<Book> root = cd.from(Book.class);

        cd.where(cb.equal(root.get("author").get("id"), authorId));
        Query query = em.createQuery(cd);

        //этап выполнения запроса
        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
    }


    @SuppressWarnings("unchecked")
    public List<Book> getBookList() {

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


}
