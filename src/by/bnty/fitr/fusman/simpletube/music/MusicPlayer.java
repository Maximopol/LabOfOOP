package by.bnty.fitr.fusman.simpletube.music;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MusicPlayer {

    public static void play(String path) {
        try {
            FileInputStream f = new FileInputStream(path);
            //FileInputStream f = new FileInputStream("C:\\Users\\Admin\\Downloads\\lol.mp3");
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
