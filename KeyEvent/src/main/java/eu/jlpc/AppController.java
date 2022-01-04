package eu.jlpc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppController {
    @FXML
    Label labelResult;

    public void moveUp(){
        labelResult.setText("UP");
    }

    public void moveRight(){
        labelResult.setText("RIGHT");
    }

    public void moveDown(){
        labelResult.setText("DOWN");
    }

    public void moveLeft(){
        labelResult.setText("LEFT");
    }
}