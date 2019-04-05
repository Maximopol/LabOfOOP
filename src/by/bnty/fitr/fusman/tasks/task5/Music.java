package by.bnty.fitr.fusman.tasks.task5;

import java.util.Random;

//Тут я не стал использвать наследование, т.к. достаточно этот класс и класс GenreOfMusic
public class Music {
    private int MAX_DURATION = 1000;
    private GenreOfMusic genre;
    private String name;
    private int duration;

    public Music() {
        genre = GenreOfMusic.Unknown;
        name = "Untitled";
        duration = new Random().nextInt(MAX_DURATION);
    }

    public Music(String name, int duration, GenreOfMusic genre) {
        this.name = name;
        this.duration = duration;
        this.genre = genre;
    }

    public Music(Music music) {
        genre = music.genre;
        name = music.name;
        duration = music.duration;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration > 0 && duration < MAX_DURATION) {
            this.duration = duration;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreOfMusic getGenre() {
        return genre;
    }

    public void setGenre(GenreOfMusic genre) {
        this.genre = genre;
    }

    public String toString() {
        return "Music{ genre=" + genre +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
