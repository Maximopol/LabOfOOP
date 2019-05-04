package by.bnty.fitr.fusman.tasks.task5.controler;

import by.bnty.fitr.fusman.tasks.task5.Disk;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControllerWithDiskTest {

    @Test
    public void countAllDuration1() {
        assertEquals(0, ControllerWithDisk.countAllDuration(new Disk()));
    }

    @Test
    public void countAllDuration2() {

        // assertEquals(0, ControllerWithDisk.countAllDuration(new Disk()));
    }
}