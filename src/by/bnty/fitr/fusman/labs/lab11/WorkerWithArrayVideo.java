package by.bnty.fitr.fusman.labs.lab11;

import by.bnty.fitr.fusman.labs.lab10.storage.Playlist;
import by.bnty.fitr.fusman.labs.lab10.video.Video;

public class WorkerWithArrayVideo {
    public static Video searchVideo(Playlist playlist, String name) {
        return playlist.getVideo(name);
        
    }

}
