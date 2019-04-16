package by.bnty.fitr.fusman.tasks.task5;

import java.util.Arrays;

public class Disk implements Storage {
    private final int MAX_LENGTH_ARRAY_MUSIC = 100;
    private int count;
    private Music[] array;

    public Disk() {

        array = new Music[MAX_LENGTH_ARRAY_MUSIC];
    }

    public Disk(int size) {
        if (size > 0 && size < MAX_LENGTH_ARRAY_MUSIC) {
            array = new Music[size];
        } else {
            array = new Music[MAX_LENGTH_ARRAY_MUSIC];
        }
    }

    public Disk(Disk disk) {
        array = new Music[disk.getLengthDisk()];
        count = disk.getCount();
        for (int i = 0; i < count; i++) {
            array[i] = disk.getMusic(i);
        }
    }

    public void add(Music music) {
        if (count < MAX_LENGTH_ARRAY_MUSIC) {
            array[count] = music;
            count++;
        }
    }

    public void remove(int number) {
        array[number] = null;
    }


    public int getLengthDisk() {
        return array.length;
    }

    public Music getMusic(int number) {
        if (array[number] != null) {
            return array[number];
        } else {
            return null;
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "count=" + count +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
