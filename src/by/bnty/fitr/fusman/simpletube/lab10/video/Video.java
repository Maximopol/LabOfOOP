package by.bnty.fitr.fusman.simpletube.lab10.video;

import java.util.Date;

public class Video {
    private String name;
    private Date data;
    private int countViews;

    private int countLikes;

    private int countDizLikes;

    public Video() {
        data = new Date();

    }

    public Video(Video video) {
        name = video.name;
        data = video.data;

    }

    public String toString() {
        return "Name:" + name + "\ndata add:" + data;
    }

}

