package by.bnty.fitr.fusman.lab10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class LLL extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {//throws Exception {
        WebView webview = new WebView();
        webview.getEngine().load(
                "https://www.youtube.com/watch?v=YBO2kxYWBF8&list=PLscFx0v8Pvuf33p1mJTEiixi8dNcVWnN8"
        );
        webview.setPrefSize(640, 390);

        stage.setScene(new Scene(webview));
        stage.show();
    }
}