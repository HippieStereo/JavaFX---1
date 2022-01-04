package eu.jlpc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AppController {
    @FXML
    private ImageView myImageView;
    @FXML
    private CheckBox myCheckBox;

    Image lampOn = new Image(getClass().getResourceAsStream("lamp-on.png"));
    Image lampOff = new Image(getClass().getResourceAsStream("lamp-off.png"));

    @FXML
    protected void changeLamp(ActionEvent event) {
        if (myCheckBox.isSelected()){
            myImageView.setImage(lampOn);
        } else {
            myImageView.setImage(lampOff);
        }
    }
}