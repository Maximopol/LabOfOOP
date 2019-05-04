package by.bnty.fitr.fusman.labs.lab10.iterator;

import java.util.List;

public class Iterator<T> implements IIterator<T> {
    private int position = 0;
    private List<T> playlist;

    public Iterator(List<T> playlist) {
        this.playlist = playlist;
    }

    public boolean hasNext() {
        return position < playlist.size() && playlist.get(position) != null;
    }

    public T next() {
        return playlist.get(position++);
    }
}
