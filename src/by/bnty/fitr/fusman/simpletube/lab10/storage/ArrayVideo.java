package by.bnty.fitr.fusman.simpletube.lab10.storage;

import by.bnty.fitr.fusman.simpletube.lab10.video.Video;

public interface ArrayVideo {
    void add(Video video);

    void remove(Video video);

    Video getVideo(String name);
}
