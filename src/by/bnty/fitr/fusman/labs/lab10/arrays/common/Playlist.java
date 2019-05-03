package by.bnty.fitr.fusman.labs.lab10.arrays.common;

import by.bnty.fitr.fusman.labs.lab10.video.Video;

public abstract class Playlist extends Storage<Video> {

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
