package dev.oliva;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import dev.oliva.model.User; // <-- Cambio aquí

public class App {
    public static void main(String[] args) {
        System.out.println("Starting Rock & Burger Database Engine...");

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        configuration.addAnnotatedClass(User.class); // <-- Cambio aquí

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
             
            System.out.println("Success! Connection established and 'users' table generated.");
            
        } catch (Exception e) {
            System.err.println("Error starting Hibernate: " + e.getMessage());
            e.printStackTrace();
        }
    }
}