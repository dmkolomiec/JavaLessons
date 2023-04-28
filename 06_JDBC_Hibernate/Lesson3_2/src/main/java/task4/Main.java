package task4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session s = factory.openSession();

        s.beginTransaction();

        s.persist(new Animal(5, "Котопёс", true));
        s.persist(new Animal(8, "Собака-волосака", true));

        s.getTransaction().commit();
        s.close();

    }
}