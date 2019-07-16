package by.bnty.fitr.fusman.tasks.task5;

import java.util.Objects;
import java.util.Random;


public class Music {
    private int MAX_DURATION = 1000;
    private MusicGenre genre;
    private String name;
    private int duration_seconds;

    public Music() {
        genre = MusicGenre.Unknown;
        name = "Untitled";
        duration_seconds = new Random().nextInt(MAX_DURATION);
    }

    public Music(String name, int duration_seconds, MusicGenre genre) {
        this.name = name;
        this.duration_seconds = duration_seconds;
        this.genre = genre;
    }

    public Music(Music music) {
        genre = music.genre;
        name = music.name;
        duration_seconds = music.duration_seconds;
    }


    public int getDuration() {
        return duration_seconds;
    }

    public void setDuration(int duration) {
        if (duration > 0 && duration < MAX_DURATION) {
            this.duration_seconds = duration;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return duration_seconds == music.duration_seconds &&
                getGenre() == music.getGenre() &&
                Objects.equals(getName(), music.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGenre(), getName(), duration_seconds);
    }

    public String toString() {
        return "Music{ genre=" + genre +
                ", name='" + name + '\'' +
                ", duration_seconds=" + duration_seconds +
                '}';
    }
}
