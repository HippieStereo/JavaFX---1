package eu.jlpc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class AppController {

    @FXML
    private Circle myCircle;
    private double x;
    private double y;

    @FXML
    private void upButton(ActionEvent e){
        myCircle.setCenterY(y-=10);
    }
    @FXML
    public void downButton(ActionEvent e){
        myCircle.setCenterY(y+=10);
    }
    @FXML
    public void leftButton(ActionEvent e){
        myCircle.setCenterX(x-=10);
    }
    @FXML
    public void rightButton(ActionEvent e){
        myCircle.setCenterX(x+=10);
    }
}
