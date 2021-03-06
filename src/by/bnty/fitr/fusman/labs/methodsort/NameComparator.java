package by.bnty.fitr.fusman.labs.methodsort;

import by.bnty.fitr.fusman.labs.lab10.video.Video;

import java.util.Comparator;

public class NameComparator implements Comparator<Video> {
    public int compare(Video v1, Video v2) {
        return v1.getName().compareTo(v2.getName());
    }
}