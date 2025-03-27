package com.mycompany.finallab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override

 public void start(Stage stage) {
    var javaVersion = System.getProperty("java.version");
    var javafxVersion = System.getProperty("javafx.version", "Unknown");

    var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    var scene = new Scene(new StackPane(label), 640, 480);
    stage.setScene(scene);
    stage.show();
}



    public static void main(String[] args) {
        launch();
    }

}