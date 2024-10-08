module com.example.carrent {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;

    opens com.example.carrent to javafx.fxml;
    exports com.example.carrent;
}