package by.bnty.fitr.fusman.simpletube.client.authandreg.authoration;

import by.bnty.fitr.fusman.labs.lab10.arrays.arraysplaylist.ArrayPlaylists;
import by.bnty.fitr.fusman.labs.lab10.arrays.arraysvideo.ArrayVideo;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlist;
import by.bnty.fitr.fusman.labs.lab10.arrays.common.Playlists;
import by.bnty.fitr.fusman.labs.lab10.video.Video;
import by.bnty.fitr.fusman.simpletube.server.workersql.WorkerSQL;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

import static Printer.Printer.println;

public class CreatePlaulistFromServ {
    public static Playlists create(StringBuilder bufferedReader) {
        Playlists playlists = new ArrayPlaylists();

        Scanner scanner = new Scanner(new BufferedReader(new StringReader(bufferedReader.toString())));
        while (scanner.hasNextLine()) {
            String playlist = scanner.nextLine();
            if (playlists.get(playlist) == null) {
                Playlist playlist1 = new ArrayVideo(playlist);
                playlists.add(playlist1);
            }

            String videoname = scanner.nextLine();
            String videopath = scanner.nextLine();
            String videodate = scanner.nextLine();
            int videoviews = Integer.parseInt(scanner.nextLine());
            int videolikes = Integer.parseInt(scanner.nextLine());
            int videodizlikes = Integer.parseInt(scanner.nextLine());

            Video video = new Video(videoname);
            video.setCountLikes(videolikes);
            video.setCountDizLikes(videodizlikes);
            video.setCountViews(videoviews);
            // video.setData(new Date(videodate));
            video.setPath(videopath);

            playlists.get(playlist).add(video);
        }
        scanner.close();
        return playlists;
    }

    //    public static Playlists create2(BufferedReader bufferedReader) {
//        Playlists playlists = new ArrayPlaylists();
//
//       // Scanner scanner = new Scanner(bufferedReader.toString());
//        try {
//
//
//            while (bufferedReader.ready()) {
//                String playlist = bufferedReader.readLine();
//                if (playlists.get(playlist) == null) {
//                    Playlist playlist1 = new ArrayVideo(playlist);
//                    playlists.add(playlist1);
//                }
//
//                String videoname = bufferedReader.readLine();
//                String videopath = bufferedReader.readLine();
//                String videodate = bufferedReader.readLine();
//                int videoviews = Integer.parseInt(bufferedReader.readLine());
//                int videolikes = Integer.parseInt(bufferedReader.readLine());
//                int videodizlikes = Integer.parseInt(bufferedReader.readLine());
//
//                Video video = new Video(videoname);
//                video.setCountLikes(videolikes);
//                video.setCountDizLikes(videodizlikes);
//                video.setCountViews(videoviews);
//                // video.setData(new Date(videodate));
//                video.setPath(videopath);
//
//                System.out.println(video);
//                playlists.get(playlist).add(video);
//            }
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return playlists;
//    }
    public static Playlists create(BufferedReader bufferedReader) {
        Playlists playlists = new ArrayPlaylists();

        Scanner scanner = new Scanner(bufferedReader);
        while (scanner.hasNextLine()) {
            String playlist = scanner.nextLine();
            if (playlists.get(playlist) == null) {
                Playlist playlist1 = new ArrayVideo(playlist);
                playlists.add(playlist1);
            }

            String videoname = scanner.nextLine();
            String videopath = scanner.nextLine();
            String videodate = scanner.nextLine();
            int videoviews = Integer.parseInt(scanner.nextLine());
            int videolikes = Integer.parseInt(scanner.nextLine());
            int videodizlikes = Integer.parseInt(scanner.nextLine());

            Video video = new Video(videoname);
            video.setCountLikes(videolikes);
            video.setCountDizLikes(videodizlikes);
            video.setCountViews(videoviews);
            // video.setData(new Date(videodate));
            video.setPath(videopath);

            playlists.get(playlist).add(video);
        }
        scanner.close();
        return playlists;
    }

    public static void main(String[] args) {
        println(CreatePlaulistFromServ.create(new WorkerSQL().getPlaylist("ppp345845514".toUpperCase())));
    }
}
