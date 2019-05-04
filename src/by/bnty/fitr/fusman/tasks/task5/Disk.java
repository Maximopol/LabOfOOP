package by.bnty.fitr.fusman.tasks.task5;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Storage;

import java.util.ArrayList;

public class Disk extends Storage<Folder> {


    public Disk() {
        playlist = new ArrayList<>();

    }

    public String toString() {
        return "Disk{" +
                "playlist=" + playlist +
                '}';
    }
}
