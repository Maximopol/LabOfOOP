package by.bnty.fitr.fusman.simpletube.common;

import by.bnty.fitr.fusman.simpletube.client.authandreg.authoration.AuthorationForm;
import by.bnty.fitr.fusman.simpletube.client.authandreg.register.form.RegisterForm;
import javafx.application.Application;
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
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class VideoExample extends Application {
    private static final Logger log = Logger.getLogger(VideoExample.class);
    private int DEFAULT_HEIGHT = 600;
    private int DEFAULT_WIDTH = 1000;
    private MediaPlayer player;


    private void playVideo(MediaView mediaView, String url) {
        Media media = new Media(url);

        player = new MediaPlayer(media);

        mediaView.setFitWidth(media.getWidth());
        mediaView.setFitHeight(media.getHeight());
        mediaView.setMediaPlayer(player);
    }

    private void uiSetup(final Stage stage) {

        StackPane root = new StackPane();
        Scene theScene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);


        final HBox buttonContainer = new HBox(0);
        final Button open_button = new Button("open");
        final Button pause_button = new Button("pause");
        final Button play_button = new Button("play");
        final Button stop_button = new Button("stop");

        final Button button_reg = new Button("reg");
        final Button button_aoth = new Button("aoth");

        final Button button_kek = new Button("get video from server");

        buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
        Insets buttonContainerPadding = new Insets(1, 1, 1, 1);
        buttonContainer.setPadding(buttonContainerPadding);
        buttonContainer.getChildren().addAll(open_button, play_button, pause_button, stop_button);

        buttonContainer.getChildren().addAll(button_reg, button_aoth, button_kek);

        final FileChooser fileChooser = new FileChooser(); // create a file chooser
        final MediaView mediaView = new MediaView(player); // create a media view


        button_reg.setOnAction(event -> {
            // RegisterForm runnable = new RegisterForm();
            RegisterForm.run();
        });

        button_aoth.setOnAction(event -> {
            //  Runnable runnable = new AuthorationForm();
            AuthorationForm.run();
        });

        button_kek.setOnAction(event -> {
            try {
                Socket s = new Socket("localhost", 65432);

                System.out.println("Подождите...");
                PrintWriter out = new
                        PrintWriter(s.getOutputStream(), true);

                out.println("walking");
                String xsdFolder = "F://clientstorage//";
                DataInputStream din = new DataInputStream(s.getInputStream());

                int filesCount = din.readInt();
                System.out.println(filesCount);

                for (int j = 0; j < filesCount; j++) {

                    long fileSize = din.readLong();
                    String fileName = din.readUTF();
                    System.out.println(fileName);
                    byte[] buffer = new byte[64 * 1024];
                    FileOutputStream outF = new FileOutputStream(xsdFolder + fileName);

                    long left = fileSize;
                    while (true) {
                        int nextPackSize = (int) Math.min(left, buffer.length);
                        int count = din.read(buffer, 0, nextPackSize);
                        if (count <= 0) {
                            throw new RuntimeException("Что-то пошло не так!");
                        }

                        outF.write(buffer, 0, count);

                        left -= count;
                        if (left == 0) {
                            break;
                        }
                    }

                    outF.flush();
                    outF.close();


                    playVideo(mediaView, "file:/" + xsdFolder + fileName);

                }

                System.out.println("Готово!");
                s.close();
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        });
//        button_kek.setOnAction(event -> {
//            try {
//
////                Socket sock = new Socket("localhost", 3128);
////                byte[] mybytearray = new byte[1024];
////                InputStream is = sock.getInputStream();
////                FileOutputStream fos = new FileOutputStream("D://2Kyrs//Kyrsovik//client//file.txt");
////                BufferedOutputStream bos = new BufferedOutputStream(fos);
////                int bytesRead = is.read(mybytearray, 0, mybytearray.length);
////                bos.write(mybytearray, 0, bytesRead);
////                bos.close();
////                sock.close();
//
//
////                Socket server = new Socket("localhost", 65432);
////                PrintWriter out = new
////                        PrintWriter(server.getOutputStream(), true);
////
////                out.println("walking");
////
////                ObjectInputStream printWriter = new ObjectInputStream(server.getInputStream());
////                Object media = printWriter.readObject();
////
////                out.close();
////                printWriter.close();
////                server.close();
////
////                Media media1 = (Media) media;
////
////                player = new MediaPlayer(media1);
////
////                mediaView.setFitWidth(media1.getWidth());
////                mediaView.setFitHeight(media1.getHeight());
////                mediaView.setMediaPlayer(player);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//        });

        open_button.setOnAction(event -> {

            try {


                File file = fileChooser.showOpenDialog(stage);
                fileChooser.setTitle("Open Video File");
                String url = file.toURI().toURL().toString();

                button_kek.setText(url);

                if (player != null)
                    player.stop();


                playVideo(mediaView, url);

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Loading Error");
                alert.setHeaderText("Error happen when loading");
                alert.setContentText("Cannot load the video");
                alert.showAndWait().ifPresent(null);

                e.printStackTrace();
            }
        });


        play_button.setOnAction(event -> player.play());


        pause_button.setOnAction(event -> player.pause());

        stop_button.setOnAction(event -> {
            if (player != null)
                player.stop();
        });

        root.getChildren().addAll(mediaView, buttonContainer); //add the media view and button container to the stackpane

        stage.setTitle("SimpleTube");

        stage.setScene(theScene);

    }

    public static void startter(String[] args) {
        log.info("Запуск приложение");
        Application.launch(args);
    }

    public static void run() {
        log.info("Запуск приложение");
        Application.launch((String[]) null);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        try {
            uiSetup(stage);
            stage.show();
        } catch (Exception e) {
            log.error(e);
            e.printStackTrace();
        }
    }
}