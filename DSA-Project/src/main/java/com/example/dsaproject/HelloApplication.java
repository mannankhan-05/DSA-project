package com.example.dsaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/dsaproject/layout.fxml"));
        Scene scene = new Scene(loader.load()); // Create Scene

        scene.getStylesheets().add(getClass().getResource("/com/example/dsaproject/style.css").toExternalForm());

        // Set up the stage
        primaryStage.setTitle("Searching and Sorting App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
