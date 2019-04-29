package by.bnty.fitr.fusman.labs.lab12;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;
import by.bnty.fitr.fusman.labs.lab10.video.Video;
import by.bnty.fitr.fusman.labs.lab11.WorkerWithArrayVideo;

public class WorkerWithAllVideos {
    public static Video searchVideo(Playlists playlists, String name) {
        for (int i = 0; i < playlists.getCountPlaylist(); i++) {
            if (WorkerWithArrayVideo.searchVideo(playlists.getPlaylist(i), name) != null) {
                return WorkerWithArrayVideo.searchVideo(playlists.getPlaylist(i), name);
            }

        }
        return null;
    }

    public static int countLiked(Playlists playlists) {
        int count = 0;
        for (int i = 0; i < playlists.getCountPlaylist(); i++) {
            count += WorkerWithArrayVideo.countLiked(playlists.getPlaylist(i));
        }
        return count;
    }
}
