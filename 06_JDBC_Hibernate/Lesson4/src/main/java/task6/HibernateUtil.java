package task6;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Asus on 01.11.2017.
 */
public class HibernateUtil {
    private static SessionFactory factory;
    static {
        try {
             factory = new Configuration()
                    .configure() // "hibernate.cfg.xml"
                    .buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    public static SessionFactory getSessionFactory() {
        return factory;
    }
}