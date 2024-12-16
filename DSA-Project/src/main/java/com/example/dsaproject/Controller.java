package com.example.dsaproject;

import java.util.LinkedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {
    @FXML
    private TextField inputArrayField;
    @FXML
    private ComboBox<String> algorithmSelector;
    @FXML
    private Button startButton;
    @FXML
    private Pane visualizationPane;

    private SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
    private SearchingAlgorithms searchingAlgorithms = new SearchingAlgorithms();

    @FXML
    private void initialize() {
        System.out.println("Initializing the controller...");
        algorithmSelector.getItems().addAll("Bubble Sort", "Quick Sort", "Linear Search", "Binary Search");
    }

    @FXML
    public void startAlgorithm() {
        try {
            // Step 1: Get the input from the text field and process it into a LinkedList
            LinkedList<Integer> list = new LinkedList<>();
            String[] input = inputArrayField.getText().split(",");
            System.out.println("Input: " + inputArrayField.getText());
            for (String num : input) {
                list.add(Integer.parseInt(num.trim()));
            }

            // Step 2: Get the selected algorithm
            String selectedAlgorithm = algorithmSelector.getValue();
            System.out.println("Selected: " + selectedAlgorithm);
            if (selectedAlgorithm == null) {
                showAlert("Error", "Please select an algorithm.");
                return;
            }

            // Step 3: Perform sorting or searching based on the selected algorithm
            switch (selectedAlgorithm) {
                case "Bubble Sort":
                    sortingAlgorithms.bubbleSort(list);
                    break;
                case "Quick Sort":
                    sortingAlgorithms.quickSort(list, 0, list.size() - 1);
                    break;
                case "Linear Search":
                    int target = getSearchTarget();
                    int index = searchingAlgorithms.linearSearch(list, target);
                    showAlert("Result", "Target found at index: " + index);
                    return;
                case "Binary Search":
                    int binaryTarget = getSearchTarget();
                    int binaryIndex = searchingAlgorithms.binarySearch(list, binaryTarget);
                    showAlert("Result", "Target found at index: " + binaryIndex);
                    return;
            }
            visualizeList(list);  // Visualize the LinkedList

        } catch (Exception e) {
            showAlert("Error", "Invalid input. Please enter numbers separated by commas.");
        }
    }

    private int getSearchTarget() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Enter the target value:");
        return Integer.parseInt(dialog.showAndWait().orElseThrow());
    }

    private void visualizeList(LinkedList<Integer> list) {
        // Clear any existing elements in the visualization pane
        visualizationPane.getChildren().clear();

        // Determine the width for each rectangle (bar)
        double barWidth = visualizationPane.getWidth() / list.size();

        // Loop through each element in the LinkedList
        for (int i = 0; i < list.size(); i++) {
            // Get the value from the LinkedList
            int value = list.get(i);

            // Create a rectangle for each element in the list
            Rectangle rectangle = new Rectangle(barWidth - 2, value * 10);  // Height scaled by 10 for better visualization
            rectangle.setFill(Color.BLUE);  // Set color of the bars (can vary with sorting state)

            // Set the position of the rectangle
            rectangle.setX(i * barWidth);  // X position for each bar
            rectangle.setY(visualizationPane.getHeight() - rectangle.getHeight());  // Y position based on height

            // Add the rectangle to the pane
            visualizationPane.getChildren().add(rectangle);
        }

        // Create a Label to display the sorted list
        Label sortedArrayLabel = new Label("Sorted List: " + listToString(list));
        sortedArrayLabel.setLayoutX(10);  // Position the label
        sortedArrayLabel.setLayoutY(visualizationPane.getHeight() + 20);  // Below the visualization
        visualizationPane.getChildren().add(sortedArrayLabel);
    }

    // Helper method to convert the LinkedList to a string
    private String listToString(LinkedList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
