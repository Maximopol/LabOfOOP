package by.bnty.fitr.fusman.simpletube.lab10.arrays;

import by.bnty.fitr.fusman.simpletube.lab10.iarrayvideo.ArrayVideo;
import by.bnty.fitr.fusman.simpletube.lab10.video.Video;

import java.util.ArrayList;
import java.util.Arrays;

public class Playlist implements ArrayVideo {
    private String name;
    private ArrayList<Video> playlist;

    public Playlist() {
        playlist = new ArrayList<>();
    }

    public Playlist(String name) {
        this();
        this.name = name;
    }

    public Playlist(Playlist playlist) {
        this.playlist = playlist.playlist;
        name = playlist.name;
    }

    public void remove(Video video) {
        playlist.remove(video);
    }


    public void add(Video video) {
        playlist.add(video);
    }

    public Video getVideo(String name) {
        for (Video video : playlist) {
            if (video.getName().equals(name)) {
                return video;
            }
        }
        return null;
    }

    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", playlist=" + Arrays.toString(playlist.toArray()) +
                '}';
    }
}
