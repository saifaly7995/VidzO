package com.example.vidzo;

public class Movie {

    private String title;
    private String discription;
    private String studio;
    private String rating;
    private String streaminglink;
    private int thumbnail;

    public Movie(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Movie(String title, String discription, String studio, String rating, String streaminglink, int thumbnail) {
        this.title = title;
        this.discription = discription;
        this.studio = studio;
        this.rating = rating;
        this.streaminglink = streaminglink;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreaminglink() {
        return streaminglink;
    }

    public void setStreaminglink(String streaminglink) {
        this.streaminglink = streaminglink;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
