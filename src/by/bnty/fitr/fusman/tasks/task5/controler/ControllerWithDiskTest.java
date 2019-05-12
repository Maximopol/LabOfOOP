package by.bnty.fitr.fusman.tasks.task5.controler;

import by.bnty.fitr.fusman.tasks.task5.Disk;
import by.bnty.fitr.fusman.tasks.task5.Folder;
import by.bnty.fitr.fusman.tasks.task5.Music;
import by.bnty.fitr.fusman.tasks.task5.MusicGenre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControllerWithDiskTest {

    @Test
    public void countAllDuration1() {
        assertEquals(0, ControllerWithDisk.countAllDuration(new Disk()));
    }

    @Test
    public void countAllDuration2() {
        Disk disk = new Disk();
        Folder folder = new Folder();
        Music music = new Music();
        Music music1 = new Music("Lol", 5, MusicGenre.Unknown);
        Music music2 = new Music("Kek", 15, MusicGenre.Unknown);

        folder.add(music);
        folder.add(music1);
        folder.add(music2);

        Folder folder2 = new Folder(MusicGenre.Classical, "LOLKEK");
        Music music3 = new Music("wTF", 24, MusicGenre.Classical);
        Music music4 = new Music("wT123", 21, MusicGenre.Classical);

        Music music5 = new Music("wTF", 24, MusicGenre.Rock);

        folder2.add(music3);
        folder2.add(music4);
        folder2.add(music5);

        disk.add(folder);
        disk.add(folder2);

        assertEquals(ControletWithFolder.countAllDuration(folder) + ControletWithFolder.countAllDuration(folder2),
                ControllerWithDisk.countAllDuration(disk)
        );
    }
}