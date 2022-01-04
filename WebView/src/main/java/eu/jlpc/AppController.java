package eu.jlpc;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private WebView webView;
    @FXML
    private TextField textField;
    private WebEngine engine;
    private String homePage = "http://www.jlpc.eu";
    private WebHistory history;

    public void loadPage(){
        engine.load(textField.getText());
        displayHistory();
    }

    public void refreshPage(){
        engine.reload();
    }

    public void zoomIn(){
        webView.setZoom(webView.getZoom() + 0.25);
    }

    public void zoomOut(){
        webView.setZoom(webView.getZoom() - 0.25);
    }

    public void setZoomDefault(){
        webView.setZoom(1.0);
    }

    public void displayHistory(){
        history = engine.getHistory();

        ObservableList<WebHistory.Entry> entries = history.getEntries();

        for(WebHistory.Entry entry : entries){
            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
        }
    }

    public void back(){
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void forward(){
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void executeJS(){
        engine.executeScript("window.location = \"https://www.youtube.com\";");
        textField.setText("https://www.youtube.com");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = webView.getEngine();

        webView.setContextMenuEnabled(false);

        textField.setText(homePage);

        engine.load(homePage);
    }
}