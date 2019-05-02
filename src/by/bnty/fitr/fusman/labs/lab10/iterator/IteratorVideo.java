package by.bnty.fitr.fusman.labs.lab10.iterator;

import by.bnty.fitr.fusman.labs.lab10.video.Video;

import java.util.List;

public class IteratorVideo implements Iterator<Video> {
    private int position = 0;
    private List<Video> playlist;
    // private

    public IteratorVideo(List<Video> playlist) {
        this.playlist = playlist;
    }

    public boolean hasNext() {
        return position < playlist.size() && playlist.get(position) != null;
    }

    public Video next() {


        return playlist.get(position++);
    }
}
