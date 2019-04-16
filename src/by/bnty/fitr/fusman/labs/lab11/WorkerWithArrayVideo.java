package by.bnty.fitr.fusman.labs.lab11;

import by.bnty.fitr.fusman.simpletube.lab10.storage.ArrayVideo;

public class WorkerWithArrayVideo {
    public static String searchVideo(ArrayVideo playlist, String name) {
        return playlist.getVideo(name).toString();
    }

}
