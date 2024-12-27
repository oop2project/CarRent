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
    opens database_layer to org.hibernate.orm.core, javafx.base;


    exports com.example.carrent;
    exports com.example.carrent.administrator;
    exports com.example.carrent.operator;
    opens com.example.carrent.administrator to javafx.fxml;
    opens com.example.carrent.operator to javafx.fxml;


}