module eu.jlpc.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens eu.jlpc to javafx.fxml;
    exports eu.jlpc;
}