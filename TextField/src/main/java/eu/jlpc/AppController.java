package eu.jlpc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {
    @FXML
    Label myLabel;
    @FXML
    TextField myTextField;
    @FXML
    Button myButton;

    int age;

    public void submit(ActionEvent event){
        try {
            age = Integer.parseInt(myTextField.getText());

            if (age >=  18){
                myLabel.setText(String.valueOf(age) + " >= 18 = OK");
            } else {
                myLabel.setText(String.valueOf(age) + " < 18 = NOT OK");
            }
        }
        catch (NumberFormatException e){
            myLabel.setText("Only numbers ...");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}