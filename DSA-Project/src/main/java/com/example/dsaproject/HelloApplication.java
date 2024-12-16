package com.example.dsaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML layout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/dsaproject/layout.fxml"));
        Scene scene = new Scene(loader.load()); // Create Scene

        // Load and apply the CSS stylesheet
        scene.getStylesheets().add(getClass().getResource("/com/example/dsaproject/style.css").toExternalForm());

        // Set up the stage
        primaryStage.setTitle("Searching and Sorting App");
        primaryStage.setScene(scene); // Set the Scene
        primaryStage.show(); // Show Stage
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX application
    }
}
