package eu.jlpc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    MediaView myMediaView;
    @FXML
    Button playButton;
    @FXML
    Button pauseButton;
    @FXML
    Button resetButton;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("/Users/HippieStereoBroo/Desktop/_LIXO_/vid.mp4");
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        myMediaView.setMediaPlayer(mediaPlayer);
    }

    public void onPlay(){
        mediaPlayer.play();
    }

    public void onPause(){
        mediaPlayer.pause();
    }

    public void onReset() {
        mediaPlayer.seek(Duration.ZERO);
    }
}