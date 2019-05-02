package by.bnty.fitr.fusman.labs.lab10.iterator;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.LinkedVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;
import by.bnty.fitr.fusman.labs.lab10.video.Video;

import static Printer.Printer.println;

public class test {
    public static void main(String[] args) {
        Playlist arrayVideo = new LinkedVideo();
        arrayVideo.add(new Video());

        arrayVideo.add(new Video("Lol"));
        Iterator<Video> iterator = arrayVideo.createIterator();
        while (iterator.hasNext()) {
            println(iterator.next());
        }
    }
}
