package by.bnty.fitr.fusman.labs.lab12.unittest;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist.ArrayPlaylists;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist.LinkedPlaylists;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.ArrayVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.LinkedVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;
import by.bnty.fitr.fusman.labs.lab10.video.Video;
import by.bnty.fitr.fusman.labs.lab12.WorkerWithAllVideos;
import junit.framework.TestCase;

public class WorkerWithAllVideosTest extends TestCase {

    public void testSearchVideo1() {
        assertNull(WorkerWithAllVideos.searchVideo(new ArrayPlaylists(), ""));
    }

    public void testSearchVideo2() {
        assertNull(WorkerWithAllVideos.searchVideo(new LinkedPlaylists(), ""));
    }

    public void testCountLiked1() {
        assertEquals(0, WorkerWithAllVideos.countLiked(new ArrayPlaylists()));
    }

    public void testCountLiked2() {
        Playlists playlists = new LinkedPlaylists();
        Playlist arrayVideo = new ArrayVideo();
        Playlist arrayVideo2 = new LinkedVideo();

        Video video = new Video("POP");
        video.setCountLikes(2);

        Video video2 = new Video("POPrr");
        video2.setCountLikes(22);

        Video video3 = new Video("POPrr");
        video3.setCountLikes(3);

        arrayVideo.add(video);
        arrayVideo.add(video2);

        arrayVideo2.add(video3);

        playlists.add(arrayVideo);
        playlists.add(arrayVideo2);

        //test 1
        assertEquals(video.getCountLikes() + video2.getCountLikes() + video3.getCountLikes(), WorkerWithAllVideos.countLiked(playlists));

        //test 2
        playlists.remove(arrayVideo);
        assertEquals(video3.getCountLikes(), WorkerWithAllVideos.countLiked(playlists));
    }
}