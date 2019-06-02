package by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;

import java.util.LinkedList;

public class LinkedPlaylists extends Playlists {

    private static final long serialVersionUID = 6866870887800165544L;

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
