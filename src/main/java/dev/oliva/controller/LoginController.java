package dev.oliva.controller;

import dev.oliva.dao.UserDAO;
import dev.oliva.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setTextFill(Color.RED);
            statusLabel.setText("Please fill in all fields.");
            return;
        }

        User authenticatedUser = userDAO.authenticate(username, password);

        if (authenticatedUser != null) {
            statusLabel.setTextFill(Color.GREEN);
            statusLabel.setText("Access granted! Role: " + authenticatedUser.getRole());
        } else {
            statusLabel.setTextFill(Color.RED);
            statusLabel.setText("Invalid username or password.");
        }
    }
}