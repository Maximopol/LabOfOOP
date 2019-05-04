package by.bnty.fitr.fusman.tasks.task5;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Storage;

import java.util.ArrayList;

public class Folder extends Storage<Music> {
    private MusicGenre musicGenre;

    public Folder() {
        playlist = new ArrayList<>();
        musicGenre = MusicGenre.Unknown;
        name = "";
    }

    public Folder(MusicGenre musicGenre, String name) {
        this();
        this.musicGenre = musicGenre;
        this.name = name;
    }

    @Override
    public void add(Music music) {
        if (music.getGenre().equals(musicGenre)) {
            super.add(music);
        }
    }


    public String toString() {
        return "Folder{" +
                "musicGenre=" + musicGenre +
                ", name='" + name + '\'' +
                ", playlist=" + playlist +
                '}';
    }
}
