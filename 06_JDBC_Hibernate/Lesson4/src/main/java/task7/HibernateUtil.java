package task7;

import jakarta.persistence.*;

public class HibernateUtil {
    public static EntityManagerFactory emf;
    public static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("dima-persistence-unit");
        em = emf.createEntityManager();
    }
}