package by.bnty.fitr.fusman.labs.lab10.arrays;

import by.bnty.fitr.fusman.labs.lab10.storage.Playlist;

import java.util.ArrayList;

public class LinkedPlaylist extends Playlist {
    public LinkedPlaylist() {
        playlist = new ArrayList<>();
        countVideo = 0;
    }

    public LinkedPlaylist(String name) {
        this();
        this.name = name;
    }

    public LinkedPlaylist(LinkedPlaylist arrayPlaylist) {
        this.playlist = arrayPlaylist.playlist;
        name = arrayPlaylist.name;
        countVideo = arrayPlaylist.countVideo;
    }

    public String toString() {
        return "LinkedPlaylist{" +
                "name='" + name + '\'' +
                ", countVideo=" + countVideo +
                ", playlist=" + playlist +
                '}';
    }
}
