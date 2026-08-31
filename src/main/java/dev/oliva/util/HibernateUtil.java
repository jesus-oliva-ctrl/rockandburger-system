package dev.oliva.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import dev.oliva.model.User;

public class HibernateUtil {

    // Unique instance of the SessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            System.out.println("Building Database Session Factory...");
            
            // Load configuration from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            
            // Register mapped classes
            configuration.addAnnotatedClass(User.class);
            
            return configuration.buildSessionFactory();
            
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("Database connection closed.");
        }
    }
}