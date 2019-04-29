package by.bnty.fitr.fusman.labs.lab10.storage;

import by.bnty.fitr.fusman.labs.lab10.video.Video;

import java.util.List;

public abstract class Playlist {
    protected String name;
    protected int countVideo;

    protected List<Video> playlist;


    public void remove(Video video) {
        if (playlist.remove(video)) {
            countVideo--;
        }
    }


    public void add(Video video) {
        playlist.add(video);
        countVideo++;

    }

    public Video getVideo(String name) {
        for (int i = 0; i < countVideo; i++) {
            if (playlist.get(i).getName().equals(name)) {
                return playlist.get(i);
            }

        }
        return null;
    }

    public int getCountVideo() {
        return countVideo;
    }
}
