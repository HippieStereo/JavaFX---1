package eu.jlpc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AppController {
    @FXML
    Pane myPane;
    @FXML
    ColorPicker myColorPicker;

    public void changeColor(ActionEvent event){
        Color myColor = myColorPicker.getValue();

        myPane.setBackground(new Background(new BackgroundFill(myColor, null,null)));
    }
}