package by.bnty.fitr.fusman.tasks.task5;

import static Printer.Printer.println;

public class Main {
    public static void main(String[] args) {
        Music lol = new Music();
        Disk disk = new Disk(4
        );
        println(lol);
        disk.add(lol);
        println(Controller.countAllDuration(disk));
        println("");
        println(Controller.searchShortSongInDisk(disk));
        Music kek = new Music();
        println(kek);
        disk.add(kek);
        println(Controller.countAllDuration(disk));
        println("");
        println(Controller.searchShortSongInDisk(disk));
        println(disk);
    }
}
