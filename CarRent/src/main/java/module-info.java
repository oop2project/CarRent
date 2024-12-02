module com.example.carrent {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.apache.logging.log4j;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    requires java.naming;
    requires jdk.jfr;

    opens com.example.carrent to javafx.fxml;
    //opens database_layer to org.hibernate.orm.core;
    opens database_layer to org.hibernate.orm.core;

    exports com.example.carrent;


}