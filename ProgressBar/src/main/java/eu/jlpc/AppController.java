package eu.jlpc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private ProgressBar myProgressBar;
    @FXML
    private Button myButton;
    @FXML
    private Label myLabel;

    private BigDecimal valueProgress = new BigDecimal(String.format("%.2f", 0.0));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        valueProgress = BigDecimal.valueOf(myProgressBar.getProgress());
        myProgressBar.setStyle("-fx-accent: #00FF00;");
    }

    public void increaseBar(){
        if (valueProgress.doubleValue() < 1){
            valueProgress = new BigDecimal(String.format("%.2f", valueProgress.doubleValue() + 0.1));
            myLabel.setText((valueProgress.doubleValue() * 100) + " %");
            myProgressBar.setProgress(valueProgress.doubleValue());
        }
        if (valueProgress.doubleValue() >= 1){myButton.setDisable(true);}
    }
}