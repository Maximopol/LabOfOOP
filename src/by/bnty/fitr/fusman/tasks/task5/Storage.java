package by.bnty.fitr.fusman.tasks.task5;

public interface Storage {
    void add(Music music);

    Music getMusic(int number);

    void remove(int number);
}
