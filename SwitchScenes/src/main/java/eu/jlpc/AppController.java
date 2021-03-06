package eu.jlpc;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene_1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene-1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene_2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene-2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}