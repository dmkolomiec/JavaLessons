package task7;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import task7.entity.Animal;

import java.util.List;

public class AnimalHelper {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public AnimalHelper() {
        emf = Persistence.createEntityManagerFactory("dima-persistence-unit");
        em = emf.createEntityManager();
    }

    public int addAnimal(Animal animal) {
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();
        return animal.getId();
    }

    public void remove(Animal animal) {
        em.getTransaction().begin();
        em.remove(animal);
        em.getTransaction().commit();
    }

    public Animal getById(int id) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        return animal;
    }

    @SuppressWarnings("unchecked")
    public List<Animal> getAll() {
        Query query = em.createQuery("SELECT animal FROM Animal animal");
        return (List<Animal>) query.getResultList();
    }

    public void close() {
        emf.close();
    }
}
