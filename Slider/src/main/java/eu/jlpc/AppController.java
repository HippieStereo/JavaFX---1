package eu.jlpc;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private Slider mySlider;
    @FXML
    private Label myLabel;

    int myTemp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myLabel.setText(Integer.toString((int) mySlider.getValue()) + " ºC");

        mySlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {

                myTemp = (int) mySlider.getValue();

                myLabel.setText(Integer.toString(myTemp) + " ºC");

            }

        });

    }

}