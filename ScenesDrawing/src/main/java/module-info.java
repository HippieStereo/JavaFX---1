module eu.jlpc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens eu.jlpc to javafx.fxml;
    exports eu.jlpc;
}