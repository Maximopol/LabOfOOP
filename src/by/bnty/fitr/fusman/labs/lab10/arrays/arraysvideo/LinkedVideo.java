package by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;

import java.util.ArrayList;

public class LinkedVideo extends Playlist {
    private static final long serialVersionUID = -4881828769718186337L;

    public LinkedVideo() {
        playlist = new ArrayList<>();
    }

    public LinkedVideo(String name) {
        this();
        this.name = name;
    }

    public LinkedVideo(LinkedVideo arrayPlaylist) {
        this.playlist = arrayPlaylist.playlist;
        name = arrayPlaylist.name;
    }

    public String toString() {
        return "LinkedVideo{" +
                "name='" + name + '\'' +
                ", countPlaylist=" + playlist.size() +
                ", playlist=" + playlist +
                '}';
    }
}
