package by.bnty.fitr.fusman.labs.lab10.arrays.common;

public abstract class Playlists extends Storage<Playlist> {

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
