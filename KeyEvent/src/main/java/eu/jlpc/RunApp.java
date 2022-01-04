package eu.jlpc;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RunApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = fxmlLoader.load();
        AppController controller =fxmlLoader.getController();
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case UP:
                        controller.moveUp();
                        break;
                    case RIGHT:
                        controller.moveRight();
                        break;
                    case DOWN:
                        controller.moveDown();
                        break;
                    case LEFT:
                        controller.moveLeft();
                        break;
                    default:
                        break;
                }
            }
        });

        stage.setScene(scene);
        stage.setTitle("KeyEvent");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}