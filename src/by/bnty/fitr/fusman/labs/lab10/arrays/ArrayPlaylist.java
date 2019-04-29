package by.bnty.fitr.fusman.labs.lab10.arrays;


import by.bnty.fitr.fusman.labs.lab10.storage.Playlist;

import java.util.ArrayList;

public class ArrayPlaylist extends Playlist {

    public ArrayPlaylist() {
        playlist = new ArrayList<>();

        countVideo = 0;
    }


    public ArrayPlaylist(String name) {
        this();
        this.name = name;
    }

    public ArrayPlaylist(ArrayPlaylist arrayPlaylist) {
        this.playlist = arrayPlaylist.playlist;
        name = arrayPlaylist.name;
        countVideo = arrayPlaylist.countVideo;
    }


    public String toString() {
        return "ArrayPlaylist{" +
                "name='" + name + '\'' +
                ", countVideo=" + countVideo +
                ", playlist=" + playlist +
                '}';
    }
}
