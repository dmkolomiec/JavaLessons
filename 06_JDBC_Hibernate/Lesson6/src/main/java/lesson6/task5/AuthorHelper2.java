package lesson6.task5;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lesson6.AuthorHelper;
import lesson6.HibernateUtil;
import lesson6.entity.Author;

import java.util.List;

public class AuthorHelper2 extends AuthorHelper {
    public AuthorHelper2(HibernateUtil hu) {
        super(hu);
    }

    @SuppressWarnings("unchecked")
    public List<Author> getAuthorList_ex_002_select_where() {
        CriteriaBuilder cb = em.getCriteriaBuilder();  // объект-конструктор запросов для Criteria API
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)
        cq.select(root); // необязательный оператор, если просто нужно получить все значения

        // Было:
        // cq.select(cb.construct(Author.class, selections)).where(cb.like(root.<String>get("name"), "%Push%"));

        // Стало:
        cq.where(cb.like(root.get("lastName"), "%Push%"));

        Query query = em.createQuery(cq);
        return query.getResultList();
    }

    public void deleteCriteria() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaDelete<Author> cd = cb.createCriteriaDelete(Author.class);
        Root<Author> root = cd.from(Author.class);
        // Было:
        // cd.where(cb.like(root.<String>get("name"), "%1%"));
        // Стало:
        cd.where(cb.like(root.get("name"), "%1%"));

        Query query = em.createQuery(cd);

        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteCriteriaLogic() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Author> cd = cb.createCriteriaDelete(Author.class);
        Root<Author> root = cd.from(Author.class);

        // Без изменений
        cd.where(cb.or(
                cb.and(
                        cb.like(root.get("name"), "%author%"),
                        cb.like(root.get("lastName"), "%2%")),
                cb.equal(root.get("lastName"), "Lermontov")));


        Query query = em.createQuery(cd);

        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
