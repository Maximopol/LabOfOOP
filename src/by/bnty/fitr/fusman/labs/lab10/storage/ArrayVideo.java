package by.bnty.fitr.fusman.labs.lab10.storage;

import by.bnty.fitr.fusman.labs.lab10.video.Video;

public interface ArrayVideo {
    void add(Video video);

    void remove(Video video);

    Video getVideo(String name);
}
