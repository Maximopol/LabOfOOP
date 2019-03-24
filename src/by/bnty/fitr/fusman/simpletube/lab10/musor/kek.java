package by.bnty.fitr.fusman.simpletube.lab10.musor;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class kek {

    public static void main(String[] args) {
        try {
            FileInputStream f = new FileInputStream("C:\\Users\\Admin\\Downloads\\lol.mp3");
            try {
                Player player = new Player(f);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
