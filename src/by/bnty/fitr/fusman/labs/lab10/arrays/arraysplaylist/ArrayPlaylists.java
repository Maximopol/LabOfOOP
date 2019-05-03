package by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;

import java.util.ArrayList;

public class ArrayPlaylists extends Playlists {


    public ArrayPlaylists() {
        playlist = new ArrayList<>();
    }


    public ArrayPlaylists(String name) {
        this();
        this.name = name;
    }

    public ArrayPlaylists(ArrayPlaylists arrayPlaylist) {
        this.playlist = arrayPlaylist.playlist;
        name = arrayPlaylist.name;
    }

    public String toString() {
        return "ArrayPlaylists{" +
                ", name='" + name + '\'' +
                ", countPlaylist=" + playlist.size() +
                ", playlist=" + playlist +
                '}';
    }
}
