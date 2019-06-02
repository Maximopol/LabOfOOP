package by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo;


import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;

import java.util.ArrayList;

public class ArrayVideo extends Playlist {
    private static final long serialVersionUID = 7210177661240622259L;

    //  private static final long serialVersionUID = 7210177661240622259L;

    public ArrayVideo() {
        playlist = new ArrayList<>(10);
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
