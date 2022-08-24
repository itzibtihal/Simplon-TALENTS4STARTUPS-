module com.example.nawan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.example.nawan.utils;

    opens com.example.nawan to javafx.fxml;
    exports com.example.nawan;
}