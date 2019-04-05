package by.bnty.fitr.fusman.tasks.task5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ControllerTest {

    @Test
    public void countAllDuration1() {
        assertEquals(0, Controller.countAllDuration(new Disk(3)));
    }

    @Test
    public void countAllDuration2() {
        Music music = new Music();
        music.setDuration(5);

        Music music2 = new Music();
        music2.setDuration(10);

        Disk disk = new Disk(3);

        disk.add(music);
        disk.add(music2);

        assertEquals(music.getDuration() + music2.getDuration(), Controller.countAllDuration(disk));
    }

    @Test
    public void searchShortSongInDisk1() {
        Music music = new Music();
        music.setDuration(5);

        Music music2 = new Music();
        music2.setDuration(10);

        Disk disk = new Disk(3);

        disk.add(music);
        disk.add(music2);
        assertEquals(music.toString(), Controller.searchShortSongInDisk(disk));
    }

    @Test
    public void searchShortSongInDisk2() {
        assertNull(Controller.searchShortSongInDisk(new Disk(2)));
    }
}