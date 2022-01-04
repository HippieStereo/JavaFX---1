package eu.jlpc;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class AppController implements Initializable {
    @FXML
    private Pane  idPane;
    @FXML
    private Label idSongLabel;
    @FXML
    private ProgressBar idSongProgressBar;
    @FXML
    private Button idPlay;
    @FXML
    private Button idPause;
    @FXML
    private Button idReset;
    @FXML
    private Button idPrevious;
    @FXML
    private Button idNext;
    @FXML
    private ComboBox<String> idSpeed;
    @FXML
    private Slider idVolumeSlide;

    private File[] files;
    private ArrayList<File> songs;
    private int songNumber;
    private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};
    private Timer timer;
    private TimerTask timerTask;
    private boolean running;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        songs = new ArrayList<File>();

        try {
            files = (new File(getClass().getResource("/music").toURI())).listFiles();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if(files != null){
            for(File file : files){
                songs.add(file);
            }
        }

        media = new Media(songs.get(songNumber).toURI().toString());

        mediaPlayer = new MediaPlayer(media);

        idSongLabel.setText(songs.get(songNumber).getName());

        for (int i = 0 ; i < speeds.length ; i++){
            idSpeed.getItems().add(Integer.toString(speeds[i]) + " %");
        }

        idSpeed.setOnAction(this::onSpeed);

        idVolumeSlide.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(idVolumeSlide.getValue() * 0.01);
            }
        });

        idSongProgressBar.setStyle("-fx-accent: #00FF00;");
    }

    public void onPlay(){
        initTimer();
        onSpeed(null);
        mediaPlayer.setVolume(idVolumeSlide.getValue() * 0.01);
        mediaPlayer.play();
    }

    public void onPause(){
        cancelTimer();
        mediaPlayer.pause();
    }

    public void onReset(){
        idSongProgressBar.setProgress(0);
        mediaPlayer.seek(Duration.seconds(0.0));
    }

    public void onPrevious(){
        if(songNumber > 0){
            songNumber--;

            mediaPlayer.stop();

            if(running){cancelTimer();}

            media = new Media(songs.get(songNumber).toURI().toString());

            mediaPlayer = new MediaPlayer(media);

            onPlay();
        } else {
            songNumber = songs.size() - 1;

            mediaPlayer.stop();

            if(running){cancelTimer();}

            media = new Media(songs.get(songNumber).toURI().toString());

            mediaPlayer = new MediaPlayer(media);

            onPlay();
        }
    }

    public void onNext(){
        if(songNumber < songs.size() - 1){
            songNumber++;

            mediaPlayer.stop();

            if(running){cancelTimer();}

            media = new Media(songs.get(songNumber).toURI().toString());

            mediaPlayer = new MediaPlayer(media);

            onPlay();
        } else {
            songNumber = 0;

            mediaPlayer.stop();

            if(running){cancelTimer();}

            media = new Media(songs.get(songNumber).toURI().toString());

            mediaPlayer = new MediaPlayer(media);

            onPlay();
        }
    }

    public void onSpeed(ActionEvent event){
        if(idSpeed.getValue() == null){
            mediaPlayer.setRate(1.0);
        } else {
            String result = Optional.ofNullable(idSpeed.getValue())
                    .map(str -> str.substring(0, str.length() - 2))
                    .orElse(idSpeed.getValue());

            mediaPlayer.setRate(Integer.parseInt(result) * 0.01);
        }
    }

    public void initTimer(){
        timer = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                running = true;

                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();

                idSongProgressBar.setProgress(current / end);

                if(current / end == 1){
                    cancelTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void cancelTimer(){
        running = false;

        timer.cancel();
    }
}