module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example to javafx.fxml;
    //exports com.example;
    exports com.example.demo;
    opens com.example.demo to javafx.fxml;
    exports com.example.controller;
    opens com.example.controller to javafx.fxml;
}