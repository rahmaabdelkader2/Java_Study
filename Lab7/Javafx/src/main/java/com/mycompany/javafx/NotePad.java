package com.mycompany.javafx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class NotePad extends Application {
    private TextArea textArea = new TextArea();
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();
        
        Menu fileMenu = new Menu("File");
        MenuItem newFile = new MenuItem("New");
        MenuItem openFile = new MenuItem("Open");
        MenuItem saveFile = new MenuItem("Save");
        MenuItem exitFile = new MenuItem("Exit");
        fileMenu.getItems().addAll(newFile, openFile, saveFile, new SeparatorMenuItem(), exitFile);
        
        Menu editMenu = new Menu("Edit");
        MenuItem undoText = new MenuItem("Undo");
        MenuItem cutText = new MenuItem("Cut");
        MenuItem copyText = new MenuItem("Copy");
        MenuItem pasteText = new MenuItem("Paste");
        MenuItem deleteText = new MenuItem("Delete");
        MenuItem selectallText = new MenuItem ("Select All");
        editMenu.getItems().addAll(undoText,new SeparatorMenuItem(),cutText, copyText, pasteText, deleteText,selectallText);
        
        Menu helpMenu = new Menu("Help");
        MenuItem aboutText = new MenuItem("About");
        helpMenu.getItems().addAll(aboutText);
        
        menuBar.getMenus().addAll(fileMenu, editMenu,helpMenu);
        root.setTop(menuBar);
        root.setCenter(textArea);

        newFile.setOnAction(e -> textArea.clear());
        openFile.setOnAction(e -> openFile());
        saveFile.setOnAction(e -> saveFile());
        exitFile.setOnAction(e -> primaryStage.close());
        
        
        undoText.setOnAction(e -> textArea.undo());
        cutText.setOnAction(e -> textArea.cut());
        copyText.setOnAction(e -> textArea.copy());
        pasteText.setOnAction(e -> textArea.paste());
        deleteText.setOnAction(e -> textArea.replaceSelection(""));
        selectallText.setOnAction(e -> textArea.selectAll());
        
        aboutText.setOnAction(e -> showAboutDialog());
        
        
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("My First Notepad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openFile() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
      private void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the author");
        alert.setHeaderText(null);
        alert.setContentText("Hello from the author: Rahma Abdelkader");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
