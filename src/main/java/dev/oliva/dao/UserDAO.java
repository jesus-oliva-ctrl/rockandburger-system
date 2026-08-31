package dev.oliva.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import dev.oliva.util.HibernateUtil;
import dev.oliva.model.User;

public class UserDAO {

    public void saveUser(User user) {
        Transaction transaction = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            transaction = session.beginTransaction();
            
            session.persist(user);
            
            transaction.commit();
            
            System.out.println("User '" + user.getUsername() + "' saved successfully!");
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error saving user: " + e.getMessage());
            e.printStackTrace();
        }
    }
}