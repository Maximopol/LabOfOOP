package by.bnty.fitr.fusman.labs.lab12.unittest;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist.ArrayPlaylists;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.ArrayVideo;
import by.bnty.fitr.fusman.labs.lab10.video.Video;
import by.bnty.fitr.fusman.labs.lab12.WorkerWithAllVideos;
import junit.framework.TestCase;

public class WorkerWithAllVideosTest extends TestCase {

    public void testSearchVideo1() {
        assertNull(WorkerWithAllVideos.searchVideo(new ArrayPlaylists(), ""));
    }

//    public void testSearchVideo2() {
//        //  assertNull(WorkerWithAllVideos.searchVideo(new ArrayPlaylists(), ""));
//    }

    public void testCountLiked1() {
        assertEquals(0, WorkerWithAllVideos.countLiked(new ArrayPlaylists()));
    }

    public void testCountLiked2() {
        ArrayPlaylists arrayPlaylists = new ArrayPlaylists();
        ArrayVideo arrayVideo = new ArrayVideo();

        Video video = new Video("POP");
        video.setCountLikes(2);

        Video video2 = new Video("POPrr");
        video.setCountLikes(22);

        arrayVideo.add(video);
        arrayVideo.add(video2);

        arrayPlaylists.add(arrayVideo);

        assertEquals(video.getCountLikes() + video2.getCountLikes(), WorkerWithAllVideos.countLiked(arrayPlaylists));
    }
}