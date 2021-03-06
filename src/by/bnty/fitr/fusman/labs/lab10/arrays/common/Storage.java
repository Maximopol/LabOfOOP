package by.bnty.fitr.fusman.labs.lab10.arrays.common;

import by.bnty.fitr.fusman.labs.lab10.iterator.IIterator;
import by.bnty.fitr.fusman.labs.lab10.iterator.Iterator;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public abstract class Storage<T> implements BaseStorage<T>, Serializable {
    protected static final long serialVersionUID = 3101383866512353095L;

    protected String name;

    protected List<T> playlist;

    public T get(int i) {
        return playlist.get(i);
    }

    public void remove(T t) {
        playlist.remove(t);
    }

    public void remove(int position) {
        playlist.remove(position);
    }

    public void add(T t) {
        playlist.add(t);
    }

    public IIterator<T> createIterator() {
        return new Iterator<>(playlist);
    }

    public int size() {
        return playlist.size();
    }

    public String getName() {
        return name;
    }

    public void sort(Comparator<T> comparator) {
        playlist.sort(comparator);
    }
}
