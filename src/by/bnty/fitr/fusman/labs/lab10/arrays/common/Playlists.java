package by.bnty.fitr.fusman.labs.lab10.arrays.common;

import java.util.List;

public abstract class Playlists implements BaseStorage<Playlist> {

    protected String name;

    protected List<Playlist> playlist;


    public void remove(Playlist playlis) {
        playlist.remove(playlis);

    }


    public void add(Playlist playlis) {
        playlist.add(playlis);

    }

    public Playlist getPlaylist(int i) {
        return playlist.get(i);
    }

    public Playlist getPlaylist(String name) {
        for (Playlist value : playlist) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }


    public int getCountPlaylist() {
        return playlist.size();
    }
}
