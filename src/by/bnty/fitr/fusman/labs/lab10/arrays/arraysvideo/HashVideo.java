package by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;
import by.bnty.fitr.fusman.labs.lab10.video.Video;

import java.util.HashSet;

public class HashVideo extends Playlist {
    private HashSet<Video> playlist;

    public HashVideo() {
        playlist = new HashSet<>();


    }

    public HashVideo(String name) {
        this();
        this.name = name;
    }

    public HashVideo(HashVideo arrayPlaylist) {
        this.playlist = arrayPlaylist.playlist;
        name = arrayPlaylist.name;

    }
}
