package by.bnty.fitr.fusman.labs.lab10.arrays.common;

public abstract class Playlists extends Storage<Playlist> {
    private static final long serialVersionUID = 1948708303599255565L;

    public Playlist get(String name) {
        for (Playlist value : playlist) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
