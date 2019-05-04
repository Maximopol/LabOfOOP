package by.bnty.fitr.fusman.labs.lab10.arrays.common;

public abstract class Playlists extends Storage<Playlist> {


    public Playlist get(String name) {
        for (Playlist value : playlist) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
