package dev.oliva.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dev.oliva.util.HibernateUtil;
import dev.oliva.model.Product;

public class ProductDAO {

    public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            System.out.println("Product '" + product.getName() + "' saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error saving product: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Product", Product.class).list();
        } catch (Exception e) {
            System.err.println("Error retrieving products: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}