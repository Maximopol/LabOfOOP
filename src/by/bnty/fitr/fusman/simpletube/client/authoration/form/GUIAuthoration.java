package by.bnty.fitr.fusman.simpletube.client.authoration.form;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class GUIAuthoration extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Auth to SimpleTube");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 270, 200);
        primaryStage.setScene(scene);
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Email:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);


        Button btn = new Button("Sign in");
        Button button = new Button("Forgot pass");

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);

        hbBtn.getChildren().add(button);

        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        button.setOnAction(e -> {
            Random random = new Random();
            actiontarget.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            actiontarget.setText("ЗАчем вам!");
        });

        btn.setOnAction(e -> {
            Random random = new Random();
            actiontarget.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            actiontarget.setText("Sign in button pressed");
        });
        primaryStage.show();
    }
}
