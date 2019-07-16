package by.bnty.fitr.fusman.simpletube.client.mainform;

import by.bnty.fitr.fusman.labs.lab10.blogers.Account;
import by.bnty.fitr.fusman.labs.lab10.video.Video;
import by.bnty.fitr.fusman.simpletube.client.accountform.AccountForm;
import by.bnty.fitr.fusman.simpletube.client.authandreg.authoration.AuthorationForm;
import by.bnty.fitr.fusman.simpletube.client.authandreg.register.form.RegisterForm;
import by.bnty.fitr.fusman.simpletube.client.loadervideo.LoaderVideo;
import by.bnty.fitr.fusman.simpletube.common.command.Command;
import by.bnty.fitr.fusman.simpletube.common.conveter.Converter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MainForm extends Application {
    private static final Logger log = Logger.getLogger(MainForm.class);
    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDTH = 1000;
    private MediaPlayer player;
    private Account account = null;
    private Video video;

    public static void run() {
        log.info("Запуск приложение");
        Application.launch((String[]) null);
    }

    private void playVideo(MediaView mediaView, String url) {
        log.info("Open to watch:" + url);
        Media media = new Media(url);

        player = new MediaPlayer(media);

        mediaView.setFitWidth(media.getWidth());
        mediaView.setFitHeight(media.getHeight());
        mediaView.setMediaPlayer(player);
    }

    private void writeKeyCode(KeyCode key) {
        if (player != null) {

            if (key == KeyCode.RIGHT) {
                if (player.getStatus().equals(MediaPlayer.Status.PAUSED)) {
                    player.play();
                } else {
                    player.pause();
                }
                log.info(player.getStatus());
            }
        }
    }

    private void uiSetup(final Stage stage) {

        StackPane root = new StackPane();
        Scene theScene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);

        setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);

        final HBox buttonContainer = new HBox(1);

        final Button open_button = new Button("open");
        final Button pause_button = new Button("pause");
        final Button play_button = new Button("play");
        final Button stop_button = new Button("stop");
        final Button reg_button = new Button("reg");
        final Button sign_button = new Button("sing in");
        final Button download_button = new Button("download");
        final Button about_account_button = new Button("Account");
        final Button load_button = new Button("Load to serv");

        final Slider cycleSlider = new Slider(1, 5, 1);
        cycleSlider.setMajorTickUnit(1);
        cycleSlider.setShowTickLabels(true);

        buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
        Insets buttonContainerPadding = new Insets(1, 1, 1, 1);
        buttonContainer.setPadding(buttonContainerPadding);

        buttonContainer.getChildren().addAll(open_button, play_button, pause_button, stop_button, about_account_button);
        buttonContainer.getChildren().addAll(reg_button, sign_button, download_button, load_button, cycleSlider);


        final FileChooser fileChooser = new FileChooser();
        final MediaView mediaView = new MediaView(player);

        cycleSlider.valueProperty().addListener(ov -> {
            if (cycleSlider.isValueChanging()) {
                if (player != null) {
                    player.seek(Duration.seconds(cycleSlider.getValue()));
                }
            }
        });

        theScene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();
            writeKeyCode(key);
        });

        reg_button.setOnAction(event -> {
            log.info("Start RegisterForm");
            RegisterForm.run();
        });

        sign_button.setOnAction(event -> {
            log.info("Start AuthorationForm");
            account = AuthorationForm.run();
            log.info(account);
        });

        about_account_button.setOnAction(event -> {
            if (account != null) {
                video = AccountForm.run(account);
                log.info("Select video" + video);
            }
        });

        load_button.setOnAction(event -> {
            if (account != null) {
                LoaderVideo.run(account);
            }
        });

        download_button.setOnAction(event -> {
            if (video != null & account != null) {
                log.info(video.getPath());
                log.info(Converter.convertToUnique(account.getNickname(), account.getEmail()));
                String ss = Converter.convertToUnique(account.getNickname(), account.getEmail()) + "//" + video.getPath();
                log.info(ss);
                try {
                    Socket s = new Socket("192.168.1.7", 65432);

                    log.info("wait");
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true);

                    out.println(Command.DONWLOAIDING);
                    out.println(ss);
                    log.info(ss);
                    log.info("sent");
                    String xsdFolder = "F://clientstorage//";
                    DataInputStream din = new DataInputStream(s.getInputStream());

                    long fileSize = din.readLong();
                    String fileName = din.readUTF();

                    log.info("File name:" + fileName + " size:" + fileSize);

                    byte[] buffer = new byte[64 * 1024];
                    FileOutputStream outF = new FileOutputStream(xsdFolder + fileName);

                    long left = fileSize;
                    do {
                        int nextPackSize = (int) Math.min(left, buffer.length);
                        int count = din.read(buffer, 0, nextPackSize);
                        if (count <= 0) {
                            throw new RuntimeException("Что-то пошло не так!");
                        }

                        outF.write(buffer, 0, count);

                        left -= count;
                    } while (left != 0);

                    outF.flush();
                    outF.close();
                    out.close();
                    s.close();

                    log.info("Done!");
                    playVideo(mediaView, "file:/" + xsdFolder + fileName);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        });

        open_button.setOnAction(event -> {
            try {
                File file = fileChooser.showOpenDialog(stage);
                fileChooser.setTitle("Open Video File");

                if (player != null) {
                    player.stop();
                }
                //String filename = "file:///F:/serverstorage/kekeke.mp4";
                //String filename = "http://techslides.com/demos/sample-videos/small.mp4";
                playVideo(mediaView, file.toURI().toURL().toString());

            } catch (Exception e) {
                try {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Loading Error");
                    alert.setHeaderText("Error happen when loading");
                    alert.setContentText("Cannot load the video");
                    alert.showAndWait().ifPresent(null);

                } catch (Exception ee) {
                    log.error(ee);
                }
                log.error(e);
            }
        });

        play_button.setOnAction(event -> {
            if (player != null) {
                cycleSlider.setMax(player.getCycleDuration().toSeconds());
                player.play();
            }
        });

        pause_button.setOnAction(event -> {
            if (player != null) {
                player.pause();
            }
        });

        stop_button.setOnAction(event -> {
            if (player != null) {
                player.stop();
            }
        });

        root.getChildren().addAll(mediaView, buttonContainer);

        String url = "file:/F:/4/VSwP4iYYJlY.png";
        root.setBackground(new Background(new BackgroundImage(new Image(url, DEFAULT_WIDTH, DEFAULT_HEIGHT, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        stage.setMinHeight(DEFAULT_HEIGHT);
        stage.setMinWidth(DEFAULT_WIDTH);
        stage.setTitle("SimpleTube");

        stage.setScene(theScene);
    }

    @Override
    public void start(final Stage stage) {
        uiSetup(stage);
        stage.show();
    }
}