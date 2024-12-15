package com.example.dsaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/dsaproject/layout.fxml")); // Load FXML
        Scene scene = new Scene(loader.load()); // Create Scene
        primaryStage.setTitle("Searching and Sorting App");
        primaryStage.setScene(scene); // Set Scene
        primaryStage.show(); // Show Stage
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX application
    }
}
