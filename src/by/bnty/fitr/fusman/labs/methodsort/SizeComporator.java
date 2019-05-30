package by.bnty.fitr.fusman.labs.methodsort;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;

import java.util.Comparator;

public class SizeComporator implements Comparator<Playlist> {
    public int compare(Playlist p1, Playlist p2) {
        return Integer.compare(p1.size(), p2.size());
    }
}
