package com.mycompany.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    private TextArea textArea;
    private TextField messageField;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket socket;

    @Override
    public void start(Stage primaryStage) {
        textArea = new TextArea();
        textArea.setEditable(false);

        messageField = new TextField();
        Button sendButton = new Button("Send");

        FlowPane inputPane = new FlowPane(10, 10);
        inputPane.getChildren().addAll(messageField, sendButton);

        BorderPane root = new BorderPane();
        root.setCenter(textArea);
        root.setBottom(inputPane);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Client 1");
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            socket = new Socket("localhost", 5005);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            new Thread(this::receiveMessages).start();
        } catch (IOException e) {
            textArea.appendText("No connection available.\n");
        }

        sendButton.setOnAction(e -> sendMessage());
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            try {
                // bab3aat msg y3ni b 5arag output
                dos.writeBytes(message + "\n"); 
                dos.flush();
                messageField.clear();
            } catch (IOException e) {
                textArea.appendText("Error sending message.\n");
            }
        }
    } 

    private void receiveMessages() {
        try {
            while (true) {
                // b receive 3ndi f b read input gayli
                String message = dis.readLine();
                textArea.appendText("msg from client: " + message + "\n");
            }
        } catch (IOException e) {
            textArea.appendText("Disconnected from server.\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
