package by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo;


import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;

import java.util.ArrayList;

public class ArrayVideo extends Playlist {

    public ArrayVideo() {
        playlist = new ArrayList<>();


    }


    public ArrayVideo(String name) {
        this();
        this.name = name;
    }

    public ArrayVideo(ArrayVideo arrayVideo) {
        this.playlist = arrayVideo.playlist;
        name = arrayVideo.name;

    }


    public String toString() {
        return "ArrayVideo{" +
                "name='" + name + '\'' +
                ", countPlaylist=" + playlist.size() +
                ", playlist=" + playlist +
                '}';
    }
}
