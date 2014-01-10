package by.bsu.spothot.bean;

import java.util.List;

/**
 * Created by Dmitry on 1/6/14.
 */
public class Post
{
    private String text;
    private List<Song> songs;
    private List<Video> videos;
    private List<Picture> pictures;

    private int likesCount;

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
}
