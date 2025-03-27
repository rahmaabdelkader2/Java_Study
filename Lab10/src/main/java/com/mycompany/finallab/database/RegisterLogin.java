package com.mycompany.finallab.database;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegisterLogin extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login and Register");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 0);
        TextField userInput = new TextField();
        GridPane.setConstraints(userInput, 1, 0);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);
        PasswordField passInput = new PasswordField();
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 0, 2);
    loginButton.setOnAction(e -> {
    try {
        UserDTO user = new UserDTO(userInput.getText(), passInput.getText());
        DAO.login(user);
        showAlert(Alert.AlertType.INFORMATION, "login Successful!");
    } catch (Exception ex) {
        showAlert(Alert.AlertType.ERROR, "Error: " + ex.getMessage());
        ex.printStackTrace();
    }
    });

        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 1, 2);
        registerButton.setOnAction(e -> {
    UserDTO user = new UserDTO(userInput.getText(), passInput.getText());
    try {
        int result = DAO.register(user);
        if (result > 0) {
            showAlert(Alert.AlertType.INFORMATION, "Registration Successful!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration Failed!");
        }
    } catch (SQLException ex) {
        showAlert(Alert.AlertType.ERROR, "Database Error: " + ex.getMessage());
        ex.printStackTrace();
    }
});

        grid.getChildren().addAll(emailLabel, userInput, passLabel, passInput, loginButton, registerButton);
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
