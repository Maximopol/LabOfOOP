package by.bnty.fitr.fusman.tasks.task5.controler;

import by.bnty.fitr.fusman.tasks.task5.Folder;
import by.bnty.fitr.fusman.tasks.task5.Music;
import by.bnty.fitr.fusman.tasks.task5.MusicGenre;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ControletWithFolderTest {

    @Test
    public void countAllDuration1() {
        assertEquals(0, ControletWithFolder.countAllDuration(new Folder()));
    }

    @Test
    public void countAllDuration2() {
        Folder folder = new Folder();

        Music music = new Music();
        Music music1 = new Music("Lol", 5, MusicGenre.Unknown);
        Music music2 = new Music("Kek", 15, MusicGenre.Unknown);

        folder.add(music);
        folder.add(music1);
        folder.add(music2);

        assertEquals(music.getDuration() + music1.getDuration() + music2.getDuration(), ControletWithFolder.countAllDuration(folder));
    }

    @Test
    public void searchShortSongInDisk1() {
        Folder folder = new Folder();

        Music music = new Music("Lolel", 10, MusicGenre.Unknown);
        Music music1 = new Music("Lol", 5, MusicGenre.Unknown);
        Music music2 = new Music("Kek", 15, MusicGenre.Unknown);

        folder.add(music);
        folder.add(music1);
        folder.add(music2);

        assertEquals(music1, ControletWithFolder.searchShortSongInDisk(folder));
    }

    @Test
    public void searchShortSongInDisk2() {
        assertNull(ControletWithFolder.searchShortSongInDisk(new Folder()));
    }

    @Test
    public void searchName1() {
        assertNull(ControletWithFolder.searchName(new Folder(), ""));
    }

    @Test
    public void searchName2() {
        Folder folder = new Folder();
        Music music = new Music();
        folder.add(music);

        assertEquals(music, Objects.requireNonNull(ControletWithFolder.searchName(folder, music.getName())));
    }

    @Test
    public void searchName3() {
        Folder folder = new Folder();
        Music music = new Music();
        Music music1 = new Music("Lol", 5, MusicGenre.Unknown);
        Music music2 = new Music("Kek", 5, MusicGenre.Unknown);

        folder.add(music);
        folder.add(music1);
        folder.add(music2);

        assertEquals(music2, Objects.requireNonNull(ControletWithFolder.searchName(folder, music2.getName())));
    }
}