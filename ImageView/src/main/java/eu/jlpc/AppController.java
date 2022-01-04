package eu.jlpc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AppController {
    @FXML
    private ImageView myImageView;

    Image myImage_1 = new Image(getClass().getResourceAsStream("Logo-Peace-01.png"));
    Image myImage_2 = new Image(getClass().getResourceAsStream("Logo-Ying-Yong-01.jpg"));

    int imageId = 1;

    public void displayImage(){
        if (imageId == 1){
            myImageView.setImage(myImage_2);
            imageId = 2;
        } else {
            myImageView.setImage(myImage_1);
            imageId = 1;
        }
    }
}