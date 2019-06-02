package by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.HashVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;

import java.util.HashSet;

public class HashPlaylists extends Playlists {
    private static final long serialVersionUID = 7926260492844596759L;
    private HashSet<HashVideo> playlist;

    public HashPlaylists() {
        playlist = new HashSet<>();
    }

    public HashPlaylists(String name) {
        this();
        this.name = name;
    }

    public HashPlaylists(HashPlaylists arrayPlaylist) {
        this.playlist = arrayPlaylist.playlist;
        name = arrayPlaylist.name;
    }
}
