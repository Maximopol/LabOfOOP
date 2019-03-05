package by.bnty.fitr.fusman.lab10.playlists;

import by.bnty.fitr.fusman.lab10.video.Video;

import java.util.ArrayList;

public class Playlists {
    private String name;
    private ArrayList<Video> playlist;

    public Playlists() {
        playlist = new ArrayList<>();
    }

    public Playlists(Playlists playlists) {
        playlist = playlists.playlist;
        name = playlists.name;
    }

    public String toString() {
        return "name" + name;
    }

    public void add(Video video) {
        playlist.add(video);

    }

    public void delete() {
       // playlist.remove()
    }
}
