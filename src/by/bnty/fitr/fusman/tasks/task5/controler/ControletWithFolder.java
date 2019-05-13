package by.bnty.fitr.fusman.tasks.task5.controler;

import by.bnty.fitr.fusman.labs.lab10.iterator.IIterator;
import by.bnty.fitr.fusman.tasks.task5.Folder;
import by.bnty.fitr.fusman.tasks.task5.Music;

public class ControletWithFolder {
    public static int countAllDuration(Folder folder) {
        int count = 0;
        IIterator<Music> iterator = folder.createIterator();
        while (iterator.hasNext()) {
            count += iterator.next().getDuration();
        }
        return count;
    }

    public static Music searchShortSongInDisk(Folder folder) {
        if (folder.size() > 0) {
            int minIndex = 0;
            for (int i = 0; i < folder.size(); i++) {
                if (folder.get(minIndex).getDuration() > folder.get(i).getDuration()) {
                    minIndex = i;
                }
            }
            return folder.get(minIndex);
        }
        return null;
    }

    public static Music searchName(Folder folder, String name) {
        for (int i = 0; i < folder.size(); i++) {
            if (folder.get(i).getName().equals(name)) {
                return folder.get(i);
            }
        }
        return null;
    }
}