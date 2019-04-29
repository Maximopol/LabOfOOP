package by.bnty.fitr.fusman.labs.lab10.arrays.common;

import by.bnty.fitr.fusman.labs.lab10.video.Video;

import java.util.List;

public abstract class Playlist implements BaseStorage<Video> {
    protected String name;


    protected List<Video> playlist;


    public void remove(Video video) {
        playlist.remove(video);
    }

    public void add(Video video) {
        playlist.add(video);


    }

    public Video getVideo(int i) {
        return playlist.get(i);
    }

    public Video getVideo(String name) {
        for (Video video : playlist) {
            if (video.getName().equals(name)) {
                return video;
            }

        }
        return null;
    }

    public int getCountVideo() {
        return playlist.size();
    }
}
