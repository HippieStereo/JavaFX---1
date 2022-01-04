module eu.jlpc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens eu.jlpc to javafx.fxml;
    exports eu.jlpc;
}