module com.example.carrent {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.apache.logging.log4j;
    requires jakarta.persistence;

    opens com.example.carrent to javafx.fxml;
    exports com.example.carrent;
}