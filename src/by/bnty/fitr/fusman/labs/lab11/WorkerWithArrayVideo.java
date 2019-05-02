package by.bnty.fitr.fusman.labs.lab11;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;
import by.bnty.fitr.fusman.labs.lab10.iterator.Iterator;
import by.bnty.fitr.fusman.labs.lab10.video.Video;

public class WorkerWithArrayVideo {
    public static Video searchVideo(Playlist playlist, String name) {
        return playlist.getVideo(name);

    }

    public static int countLiked(Playlist playlist) {
        int count = 0;
        Iterator<Video> iterator = playlist.createIterator();
        while (iterator.hasNext()) {
            count += iterator.next().getCountLikes();
        }
        return count;
    }

    public static int countDizLikes(Playlist playlist) {
        int count = 0;
        Iterator<Video> iterator = playlist.createIterator();
        while (iterator.hasNext()) {
            count += iterator.next().getCountDizLikes();
        }
        return count;
    }

    public static int countViews(Playlist playlist) {
        int count = 0;
        Iterator<Video> iterator = playlist.createIterator();
        while (iterator.hasNext()) {
            count += iterator.next().getCountViews();
        }
        return count;
    }
}
