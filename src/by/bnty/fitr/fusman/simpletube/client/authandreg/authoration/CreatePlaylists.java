package by.bnty.fitr.fusman.simpletube.client.authandreg.authoration;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist.ArrayPlaylists;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.ArrayVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;
import by.bnty.fitr.fusman.labs.lab10.video.Video;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

public class CreatePlaylists {

    public static Playlists create(StringBuilder bufferedReader) {
        return createPlaylist(new Scanner(new BufferedReader(new StringReader(bufferedReader.toString()))));
    }

    public static Playlists create(BufferedReader bufferedReader) {
        return createPlaylist(new Scanner(bufferedReader));
    }

    private static Playlists createPlaylist(Scanner scann) {
        Playlists playlists = new ArrayPlaylists();

        while (scann.hasNextLine()) {
            String playlist = scann.nextLine();
            if (playlists.get(playlist) == null) {
                Playlist playlist1 = new ArrayVideo(playlist);
                playlists.add(playlist1);
            }

            String videoname = scann.nextLine();
            String videopath = scann.nextLine();
            String videodate = scann.nextLine();
            int videoviews = Integer.parseInt(scann.nextLine());
            int videolikes = Integer.parseInt(scann.nextLine());
            int videodizlikes = Integer.parseInt(scann.nextLine());

            Video video = new Video(videoname);
            video.setCountLikes(videolikes);
            video.setCountDizLikes(videodizlikes);
            video.setCountViews(videoviews);
            video.setPath(videopath);

            playlists.get(playlist).add(video);
        }
        scann.close();
        return playlists;
    }
}
