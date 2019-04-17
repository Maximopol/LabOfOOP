package by.bnty.fitr.fusman.labs.lab10.arrays;

import by.bnty.fitr.fusman.labs.lab10.storage.ArrayVideo;
import by.bnty.fitr.fusman.labs.lab10.video.Video;

import java.util.ArrayList;

public class Playlist implements ArrayVideo {
    private String name;
    private ArrayList<Video> playlist;
    private int countVideo;

    public Playlist() {
        playlist = new ArrayList<>();
        countVideo = 0;
    }

    public Playlist(String name) {
        this();
        this.name = name;
    }

    public Playlist(Playlist playlist) {
        this.playlist = playlist.playlist;
        name = playlist.name;
        countVideo = playlist.countVideo;
    }

    public void remove(Video video) {
        playlist.remove(video);
        countVideo--;
    }


    public void add(Video video) {
        playlist.add(video);
        countVideo++;
    }

    public Video getVideo(String name) {
        for (Video video : playlist) {
            if (video.getName().equals(name)) {
                return video;
            }
        }
        return null;
    }


    public int getCountVideo() {
        return countVideo;
    }


    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", playlist=" + playlist +
                ", countVideo=" + countVideo +
                '}';
    }
}
