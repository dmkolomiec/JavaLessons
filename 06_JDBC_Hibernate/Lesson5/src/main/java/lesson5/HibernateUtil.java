package lesson5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    public EntityManagerFactory emf;
    public EntityManager em;

    public HibernateUtil(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }
}