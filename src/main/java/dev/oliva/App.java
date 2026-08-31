package dev.oliva;

import dev.oliva.dao.UserDAO;
import dev.oliva.model.User;
import dev.oliva.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting Rock & Burger System...");

        try {
            UserDAO userDAO = new UserDAO();

            System.out.println("Creating Admin user object...");
            User adminUser = new User("admin_cruz", "password123", "ADMIN");

            System.out.println("Attempting to insert user into the database...");
            userDAO.saveUser(adminUser);

            System.out.println("Database insertion test finished successfully!");

        } catch (Exception e) {
            System.err.println("An error occurred during execution: " + e.getMessage());
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}