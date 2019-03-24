package by.bnty.fitr.fusman.simpletube.lab10.musor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;

public class SimpleApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        Button btn = new Button();

        Random random = new Random();
        for(int i =0;i<100000;i++){
            Line line =  new Line();
            line.setStartX(random.nextInt()%300);
            line.setStartY(random.nextInt()%250);
            line.setEndX(random.nextInt()%300);
            line.setEndY(random.nextInt()%250);
        }
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> primaryStage.setTitle("" + random.nextInt()));

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        //Initialising path of the media file, replace this with your file path
//        String path =  "C:\\Users\\Admin\\Desktop\\2019-02-11 19.00 Открытый Онлайн Учебный курс по C# - Feb 11,2019.mp4";
//
//            Media media = new Media(new File(path).toURI().toString());
//
//
//            //Instantiating MediaPlayer class
//            MediaPlayer mediaPlayer = new MediaPlayer(media);
//
//            //Instantiating MediaView class
//            MediaView mediaView = new MediaView(mediaPlayer);
//
//            //by setting this property to true, the Video will be played
//            mediaPlayer.setAutoPlay(true);
//
//            //setting group and scene
//            Group root = new Group();
//            root.getChildren().add(mediaView);
//            Scene scene = new Scene(root, 500, 400);
//            primaryStage.setScene(scene);
//            primaryStage.setTitle("Playing video");
//            primaryStage.show();
//        }
//
//    public static void main(String[] args) {
//        launch(args);
//    }

}
