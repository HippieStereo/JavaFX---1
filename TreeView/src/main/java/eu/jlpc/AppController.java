package eu.jlpc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private TreeView myTreeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootItemTop = new TreeItem<>("Files");

        TreeItem<String> rootItemVideos = new TreeItem<>("Videos", new ImageView(
                new Image(getClass().getResourceAsStream("folder-icon.png"))
        ));
        TreeItem<String> rootItemMusic = new TreeItem<>("Music", new ImageView(
                new Image(getClass().getResourceAsStream("folder-icon.png"))
        ));
        TreeItem<String> rootItemPictures = new TreeItem<>("Pictures", new ImageView(
                new Image(getClass().getResourceAsStream("folder-icon.png"))
        ));

        TreeItem<String> pictures_1 = new TreeItem<>("Pictures 1");
        TreeItem<String> pictures_2 = new TreeItem<>("Pictures 2");
        TreeItem<String> pictures_3 = new TreeItem<>("Pictures 3");

        rootItemTop.getChildren().addAll(rootItemVideos, rootItemMusic, rootItemPictures);
        rootItemPictures.getChildren().addAll(pictures_1, pictures_2, pictures_3);

        myTreeView.setShowRoot(false);
        myTreeView.setRoot(rootItemTop);
    }

    public void itemSelected(){
        Optional<String> item = Optional.ofNullable(((TreeItem<String>) myTreeView.getSelectionModel().getSelectedItem()).getValue());

        if (item != null){System.out.println(
                ((TreeItem<String>) myTreeView.getSelectionModel().getSelectedItem()).getValue()
        );}
    }
}