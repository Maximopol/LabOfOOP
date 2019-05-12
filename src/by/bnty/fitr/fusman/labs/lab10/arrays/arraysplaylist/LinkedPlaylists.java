package by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;

import java.util.LinkedList;

public class LinkedPlaylists extends Playlists {

    public LinkedPlaylists() {
        playlist = new LinkedList<>();
    }

    public LinkedPlaylists(String name) {
        this();
        this.name = name;
    }

    public LinkedPlaylists(LinkedPlaylists arrayPlaylist) {
        this.playlist = arrayPlaylist.playlist;
        name = arrayPlaylist.name;
    }
}
