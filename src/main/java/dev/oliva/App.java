package dev.oliva;

import dev.oliva.dao.ProductDAO;
import dev.oliva.model.Product;
import dev.oliva.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting Rock & Burger Database Engine...");

        try {
            ProductDAO productDAO = new ProductDAO();
            
            System.out.println("Creating first product...");
            Product burger = new Product("Classic Burger", 5.99, "Burgers", 50);
            
            System.out.println("Attempting to insert product into the database...");
            productDAO.saveProduct(burger);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}