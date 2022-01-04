package eu.jlpc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerScene_2 {
    @FXML
    Label nameLabel;

    public void displayName(String userName){
        nameLabel.setText("Hello  :  " +  userName);
    }
}