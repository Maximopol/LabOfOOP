package by.bnty.fitr.fusman.simpletube.client.mainform;

import by.bnty.fitr.fusman.labs.lab10.blogers.Account;
import by.bnty.fitr.fusman.simpletube.client.accountform.AccountForm;
import by.bnty.fitr.fusman.simpletube.client.authandreg.authoration.form.AuthorationForm;
import by.bnty.fitr.fusman.simpletube.client.authandreg.register.form.RegisterForm;
import by.bnty.fitr.fusman.simpletube.client.authandreg.runable.Runnable;
import by.bnty.fitr.fusman.simpletube.client.loadervideo.LoaderVideo;
import by.bnty.fitr.fusman.simpletube.common.command.Command;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import static Printer.Printer.println;

public class MainForm extends Application {
    private static final Logger log = Logger.getLogger(MainForm.class);
    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDTH = 1000;
    private MediaPlayer player;
    private Account account = null;

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
            }
//            if (key == KeyCode.UP) {
//                player.setVolume(player.getVolume() + 1);
//            }
//            if (key == KeyCode.DOWN) {
//                player.setVolume(player.getVolume() - 1);
//            }
//            System.out.println(player.getVolume());
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
        final Button button_reg = new Button("reg");
        final Button button_aoth = new Button("sing in");
        final Button button_kek = new Button("download");
        final Button button_ac = new Button("Account");
        final Button button_load = new Button("Load to serv");

//        ComboBox<Playlists> cmb = new ComboBox<>();
//        cmb.getItems().add(new Playlists(){});
//        cmb.getItems().add(new Playlists(){});


//        Image defaultImage = new Image("file:/F:/4/f.png");
//        ImageView imageView = new ImageView(defaultImage);
//
//        imageView.setTranslateX(200);
//        imageView.setTranslateY(200);
//
//        imageView.setFitWidth(50);
//        imageView.setFitHeight(50);

        buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
        Insets buttonContainerPadding = new Insets(1, 1, 1, 1);
        buttonContainer.setPadding(buttonContainerPadding);

        buttonContainer.getChildren().addAll(open_button, play_button, pause_button, stop_button, button_ac);
        buttonContainer.getChildren().addAll(button_reg, button_aoth, button_kek, button_load);


        final FileChooser fileChooser = new FileChooser();
        final MediaView mediaView = new MediaView(player);


        theScene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();
            writeKeyCode(key);
        });

        button_reg.setOnAction(event -> {
            log.info("Start RegisterForm");
//            RegisterForm runnable = new RegisterForm();
            RegisterForm.run();
        });

        button_aoth.setOnAction(event -> {
            log.info("Start AuthorationForm");
//            AuthorationForm runnable = new AuthorationForm();
            account = AuthorationForm.run();
            println(account);
            //   account = new Account("maks","maximopolnate@gmail.com");
        });

        button_ac.setOnAction(event -> {
            Runnable runnable = new AccountForm();
            runnable.run();
        });

        button_load.setOnAction(event -> {
            LoaderVideo.run(new Account("ppp", "pp@mail.com"));
//            try {
//                account = new Account("root", "root@gmail.com");
//
//                Socket socket = new Socket("localhost", 65432);
//                PrintWriter out = new
//                        PrintWriter(socket.getOutputStream(), true);
//
//                //out.println(Command.LOADING + "\n" + account.getNickname() + "\n" + account.getEmail());
//
//                DataOutputStream outD = new DataOutputStream(socket.getOutputStream());
//
//                outD.writeInt(1);
//                //for (String filename : filenames) {
//                File f = new File("F://clientstorage//12.mp4");
//
//                outD.writeLong(f.length());//отсылаем размер файла
//                outD.writeUTF(f.getName());//отсылаем имя файла
//
//                System.out.println(f.length());
//                System.out.println(f.getName());
//
//                FileInputStream in = new FileInputStream(f);
//                byte[] buffer = new byte[64 * 1024];
//                int count;
//
//                while ((count = in.read(buffer)) != -1) {
//                    outD.write(buffer, 0, count);
//                }
//
//                outD.flush();
//                in.close();
//                out.close();
//                socket.close();
////                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
////                out.println(Command.LOADING + "\n" + account.getNickname() + "\n" + account.getEmail());
////
////                DataOutputStream outD = new DataOutputStream(s.getOutputStream());
////                outD.writeInt(1);
////
////                File f = new File("F://clientstorage//12.mp4");
////
////                outD.writeLong(f.length());//отсылаем размер файла
////                outD.writeUTF(f.getName());//отсылаем имя файла
////
////                System.out.println(f.length());
////                System.out.println(f.getName());
////
////                FileInputStream in = new FileInputStream(f);
////                byte[] buffer = new byte[64 * 1024];
////                int count;
////
////                while ((count = in.read(buffer)) != -1) {
////                    outD.write(buffer, 0, count);
////                }
////
////                outD.flush();
////                in.close();
////                out.close();
////                s.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        });


        button_kek.setOnAction(event -> {
            try {
                Socket s = new Socket("localhost", 65432);

                System.out.println("Подождите...");
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);

                out.println(Command.DONWLOAIDING);

                System.out.println("послано");
                String xsdFolder = "F://clientstorage//";
                DataInputStream din = new DataInputStream(s.getInputStream());

                //int filesCount = din.readInt();
                //System.out.println(filesCount);

                //for (int j = 0; j < filesCount; j++) {

                    long fileSize = din.readLong();
                    String fileName = din.readUTF();
                    System.out.println(fileName);
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


                    playVideo(mediaView, "file:/" + xsdFolder + fileName);


                System.out.println("Готово!");

                out.close();
                s.close();
            } catch (Exception e) {
                System.err.println(e.toString());
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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Loading Error");
                alert.setHeaderText("Error happen when loading");
                alert.setContentText("Cannot load the video");
                alert.showAndWait().ifPresent(null);

                log.error(e);
            }
        });

        play_button.setOnAction(event -> {
            if (player != null) {
                player.play();
            }
        });


        pause_button.setOnAction(event ->
                {
                    if (player != null) {
                        player.pause();
                    }
                }
        );

        stop_button.setOnAction(event -> {
            if (player != null) {
                player.stop();
            }
        });

        root.getChildren().addAll(mediaView, buttonContainer);

        //  root.getChildren().remove(buttonContainer);
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