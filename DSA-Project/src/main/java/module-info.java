module com.example.dsaproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dsaproject to javafx.fxml;
    exports com.example.dsaproject;
}