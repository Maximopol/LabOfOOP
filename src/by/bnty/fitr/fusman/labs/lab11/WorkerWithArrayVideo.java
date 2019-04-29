package by.bnty.fitr.fusman.labs.lab11;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;
import by.bnty.fitr.fusman.labs.lab10.video.Video;

public class WorkerWithArrayVideo {
    public static Video searchVideo(Playlist playlist, String name) {
        return playlist.getVideo(name);

    }

    public static int countLiked(Playlist playlist) {
        int count = 0;
        for (int i = 0; i < playlist.getCountVideo(); i++) {
            count += playlist.getVideo(i).getCountLikes();
        }
        return count;
    }

    public static int countDizLikes(Playlist playlist) {
        int count = 0;
        for (int i = 0; i < playlist.getCountVideo(); i++) {
            count += playlist.getVideo(i).getCountDizLikes();
        }
        return count;
    }

    public static int countViews(Playlist playlist) {
        int count = 0;
        for (int i = 0; i < playlist.getCountVideo(); i++) {
            count += playlist.getVideo(i).getCountViews();
        }
        return count;
    }
}
