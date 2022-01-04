module eu.jlpc {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.jlpc to javafx.fxml;
    exports eu.jlpc;
}