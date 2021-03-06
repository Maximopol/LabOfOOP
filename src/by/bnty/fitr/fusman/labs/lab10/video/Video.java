package by.bnty.fitr.fusman.labs.lab10.video;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Video implements Serializable {
    private static final long serialVersionUID = -634875856737059338L;

    private String name;
    private String path;
    private Date data;
    private int countViews;
    private int countLikes;
    private int countDizLikes;

    public Video() {
        name = "";
        path = "";
        data = new Date();
        countViews = 0;
        countLikes = 0;
        countDizLikes = 0;
    }

    public Video(String name) {
        this();
        this.name = name;
    }

    public Video(Video video) {
        name = video.name;
        path = video.path;
        data = video.data;
        countViews = video.countViews;
        countLikes = video.countLikes;
        countDizLikes = video.countLikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return getCountViews() == video.getCountViews() &&
                getCountLikes() == video.getCountLikes() &&
                getCountDizLikes() == video.getCountDizLikes() &&
                Objects.equals(getName(), video.getName()) &&
                Objects.equals(getPath(), video.getPath()) &&
                Objects.equals(getData(), video.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPath(), getData(), getCountViews(), getCountLikes(), getCountDizLikes());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCountViews() {
        return countViews;
    }

    public void setCountViews(int countViews) {
        this.countViews = countViews;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public void setCountLikes(int countLikes) {
        this.countLikes = countLikes;
    }

    public int getCountDizLikes() {
        return countDizLikes;
    }

    public void setCountDizLikes(int countDizLikes) {
        this.countDizLikes = countDizLikes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", data=" + data +
                ", countViews=" + countViews +
                ", countLikes=" + countLikes +
                ", countDizLikes=" + countDizLikes +
                '}';
    }
}

