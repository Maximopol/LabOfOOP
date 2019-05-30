package by.bnty.fitr.fusman.labs.lab11.unittests;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.ArrayVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.LinkedVideo;
import by.bnty.fitr.fusman.labs.lab10.video.Video;
import by.bnty.fitr.fusman.labs.lab11.WorkerWithArrayVideo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WorkerWithArrayVideoTest {

    @Test
    public void searchVideo1() {
        ArrayVideo arrayVideo = new ArrayVideo();
        arrayVideo.add(new Video());
        assertEquals(new Video().toString(), WorkerWithArrayVideo.searchVideo(arrayVideo, "").toString());
    }

    @Test
    public void searchVideo2() {
        assertNull(WorkerWithArrayVideo.searchVideo(new ArrayVideo(), ""));
    }

    @Test
    public void searchVideo3() {
        assertNull(WorkerWithArrayVideo.searchVideo(new LinkedVideo(), ""));
    }

    @Test
    public void searchVideo4() {
        LinkedVideo arrayPlaylist = new LinkedVideo();
        arrayPlaylist.add(new Video());
        assertEquals(new Video().toString(), WorkerWithArrayVideo.searchVideo(arrayPlaylist, "").toString());

    }

//    @Test
//    public void searchVideo5() {
//        assertNull(WorkerWithArrayVideo.searchVideo(new HashVideo(), ""));
//    }

    @Test
    public void searchVideo6() {
        ArrayVideo arrayVideo = new ArrayVideo();
        arrayVideo.add(new Video());
        arrayVideo.add(new Video("BNTU"));
        arrayVideo.add(new Video("Opol"));
        arrayVideo.get("kek");

        assertEquals(new Video("BNTU").toString(), WorkerWithArrayVideo.searchVideo(arrayVideo, "BNTU").toString());
    }

    @Test
    public void countLiked1() {
        assertEquals(0, WorkerWithArrayVideo.countLiked(new ArrayVideo()));
    }

    @Test
    public void countDizLikes1() {
        assertEquals(0, WorkerWithArrayVideo.countDizLikes(new ArrayVideo()));
    }

    @Test
    public void countLiked2() {
        ArrayVideo arrayVideo = new ArrayVideo();
        Video video = new Video();
        video.setCountLikes(10);
        arrayVideo.add(video);
        assertEquals(10, WorkerWithArrayVideo.countLiked(arrayVideo));
    }

    @Test
    public void countDizLikes2() {
        ArrayVideo arrayVideo = new ArrayVideo();
        Video video = new Video();
        video.setCountDizLikes(10);
        arrayVideo.add(video);
        assertEquals(10, WorkerWithArrayVideo.countDizLikes(arrayVideo));
    }

    @Test
    public void countViews1() {
        assertEquals(0, WorkerWithArrayVideo.countViews(new ArrayVideo()));
    }

    @Test
    public void countViews2() {
        ArrayVideo arrayVideo = new ArrayVideo();
        Video video = new Video();
        video.setCountViews(10);
        arrayVideo.add(video);
        assertEquals(10, WorkerWithArrayVideo.countViews(arrayVideo));
    }
}