package by.bnty.fitr.fusman.labs.lab11.unittests;

import by.bnty.fitr.fusman.labs.lab10.arrays.ArrayPlaylist;
import by.bnty.fitr.fusman.labs.lab10.arrays.LinkedPlaylist;
import by.bnty.fitr.fusman.labs.lab10.video.Video;
import by.bnty.fitr.fusman.labs.lab11.WorkerWithArrayVideo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WorkerWithArrayVideoTest {

    @Test
    public void searchVideo1() {
        ArrayPlaylist arrayPlaylist = new ArrayPlaylist();
        arrayPlaylist.add(new Video());
        assertEquals(new Video().toString(), WorkerWithArrayVideo.searchVideo(arrayPlaylist, "").toString());

    }

    @Test
    public void searchVideo2() {
        assertNull(WorkerWithArrayVideo.searchVideo(new ArrayPlaylist(), ""));
    }

    @Test
    public void searchVideo3() {
        assertNull(WorkerWithArrayVideo.searchVideo(new LinkedPlaylist(), ""));
    }

}