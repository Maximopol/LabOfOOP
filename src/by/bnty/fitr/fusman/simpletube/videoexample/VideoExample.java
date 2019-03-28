package by.bnty.fitr.fusman.simpletube.videoexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class VideoExample extends Application {
    private int APP_HEIGHT = 600;
    private int APP_WIDTH = 1000;
    private MediaPlayer player;


    private void uiSetup(final Stage stage) {

        StackPane root = new StackPane();
        Scene theScene = new Scene(root, APP_WIDTH, APP_HEIGHT);


        final HBox buttonContainer = new HBox(0);
        final Button open_button = new Button("open");
        final Button pause_button = new Button("pause");
        final Button play_button = new Button("play");
        final Button stop_button = new Button("stop");

        buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
        Insets buttonContainerPadding = new Insets(1, 1, 1, 1);
        buttonContainer.setPadding(buttonContainerPadding);
        buttonContainer.getChildren().addAll(open_button, play_button, pause_button, stop_button);

        final FileChooser fileChooser = new FileChooser(); // create a file chooser
        final MediaView mediaView = new MediaView(player); // create a media view


        open_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    File file = fileChooser.showOpenDialog(stage);
                    fileChooser.setTitle("Open Video File");
                    String url = file.toURI().toURL().toString();

                    if (player != null)
                        player.stop();

                    Media media = new Media(url);

                    player = new MediaPlayer(media);

                    mediaView.setFitWidth(stage.getWidth());
                    mediaView.setFitHeight(stage.getHeight());
                    mediaView.setMediaPlayer(player);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Loading Error");
                    alert.setHeaderText("Error happen when loading");
                    alert.setContentText("Cannot load the video");
                    alert.showAndWait().ifPresent(null);
                    e.printStackTrace();
                }
            }
        });


        play_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //player.setVolume();
                player.play();
            }
        });


        pause_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.pause();
            }
        });

        //this button will stop the video
        stop_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (player != null)
                    player.stop();
            }
        });

        root.getChildren().addAll(mediaView, buttonContainer); //add the media view and button container to the stackpane

        stage.setTitle("Video");

        stage.setScene(theScene);

    }

    @Override
    public void start(final Stage stage) throws Exception {

        try {
            uiSetup(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}