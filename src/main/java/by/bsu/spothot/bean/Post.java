package by.bsu.spothot.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by Dmitry on 1/6/14.
 */
public class Post
{
    private Integer id;
    private String domain;
    private Date date;
    private String text;
    private List<Song> songs;
    private List<Video> videos;
    private List<Picture> pictures;

    private int likesCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public List<Song> getSongs()
    {
        return songs;
    }

    public void setSongs(List<Song> songs)
    {
        this.songs = songs;
    }

    public List<Video> getVideos()
    {
        return videos;
    }

    public void setVideos(List<Video> videos)
    {
        this.videos = videos;
    }

    public List<Picture> getPictures()
    {
        return pictures;
    }

    public void setPictures(List<Picture> pictures)
    {
        this.pictures = pictures;
    }

    public int getLikesCount()
    {
        return likesCount;
    }

    public void setLikesCount(int likesCount)
    {
        this.likesCount = likesCount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", domain='" + domain + '\'' + '\n' +
                ", date='" + date + '\'' + '\n' +
                ", text='" + text + '\'' + '\n' +
                ", songs=" + songs + '\n' +
                ", videos=" + videos + '\n' +
                ", pictures=" + pictures + '\n' +
                ", likesCount=" + likesCount + '\n' +
                '}';
    }
}
