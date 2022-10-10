package com.kkjz.pojo;

/**
 * @author kkjz
 * @create 2022-09-23 14:47
 */
public class Favourite {
    private int favouriteID;

    private String videoID;

    private String videoName;

    private String videoImage;

    private String userID;

    private String favouriteTime;

    public int getFavouriteID() {
        return favouriteID;
    }

    public void setFavouriteID(int favouriteID) {
        this.favouriteID = favouriteID;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFavouriteTime() {
        return favouriteTime;
    }

    public void setFavouriteTime(String favouriteTime) {
        this.favouriteTime = favouriteTime;
    }
}
