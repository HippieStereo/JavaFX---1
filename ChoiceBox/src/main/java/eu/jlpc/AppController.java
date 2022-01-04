package eu.jlpc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> myChoiceBox;

    private String[] elementList = {"Element 1", "Element 2", "Element 3"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(elementList);
        myChoiceBox.setOnAction(this::getElement);
    }

    public void getElement(ActionEvent event){
        myLabel.setText(myChoiceBox.getValue());
    }
}