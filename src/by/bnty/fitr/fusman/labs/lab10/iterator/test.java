package by.bnty.fitr.fusman.labs.lab10.iterator;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist.ArrayPlaylists;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.ArrayVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.LinkedVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;
import by.bnty.fitr.fusman.labs.lab10.video.Video;

import static Printer.Printer.println;

public class test {
    public static void main(String[] args) {
        Playlist arrayVideo = new LinkedVideo();
        arrayVideo.add(new Video());

        arrayVideo.add(new Video("Lol"));

        Playlist lol = new ArrayVideo();
        lol.add(new Video("OOP"));

        Playlists playlists = new ArrayPlaylists();
        playlists.add(arrayVideo);
        playlists.add(lol);

        IIterator kek = playlists.createIterator();

        while (kek.hasNext()) {

            println(kek.next());
        }

    }
}
