package eu.jlpc;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

public class RunApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);

        URL iconUrl = getClass().getResource("/images/Logo-Icon.png");
        Image icon = new Image(iconUrl.toString());

        stage.setWidth(420);
        stage.setHeight(420);
        stage.setResizable(false);
        stage.setX(50);
        stage.setY(50);
        stage.getIcons().add(icon);
        stage.setTitle("Stages");
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("\"q\" to exit");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}