package eu.jlpc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class AppController {
    @FXML
    RadioButton idFood;
    @FXML
    RadioButton idWeed;
    @FXML
    RadioButton idSports;
    @FXML
    Label myLabel;;

    public void getToDo(ActionEvent actionEvent) {
        if (idFood.isSelected()){
            myLabel.setText(idFood.getText());
        }

        if (idWeed.isSelected()){
            myLabel.setText(idWeed.getText());
        }

        if (idSports.isSelected()){
            myLabel.setText(idSports.getText());
        }
    }
}