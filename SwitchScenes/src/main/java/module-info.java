module eu.jlpc.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.jlpc to javafx.fxml;
    exports eu.jlpc;
}