package com.kkjz.pojo;

public class Video {
    private String videoID;

    private String videoName;

    private String videolookTime;

    private String videoTime;

    private String videoState;

    private String videocAtegory;

    private String videoImage;

    private String videoAddress;

    private String videoCollection;

    private String videoLeaving;

    private String userID;

    private String userName;

    private String videoDescribe;

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID == null ? null : videoID.trim();
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getVideolookTime() {
        return videolookTime;
    }

    public void setVideolookTime(String videolookTime) {
        this.videolookTime = videolookTime == null ? null : videolookTime.trim();
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime == null ? null : videoTime.trim();
    }

    public String getVideoState() {
        return videoState;
    }

    public void setVideoState(String videoState) {
        this.videoState = videoState == null ? null : videoState.trim();
    }

    public String getVideocAtegory() {
        return videocAtegory;
    }

    public void setVideocAtegory(String videocAtegory) {
        this.videocAtegory = videocAtegory == null ? null : videocAtegory.trim();
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage == null ? null : videoImage.trim();
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress == null ? null : videoAddress.trim();
    }

    public String getVideoCollection() {
        return videoCollection;
    }

    public void setVideoCollection(String videoCollection) {
        this.videoCollection = videoCollection == null ? null : videoCollection.trim();
    }

    public String getVideoLeaving() {
        return videoLeaving;
    }

    public void setVideoLeaving(String videoLeaving) {
        this.videoLeaving = videoLeaving == null ? null : videoLeaving.trim();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID == null ? null : userID.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getvideoDescribe() {
        return videoDescribe;
    }

    public void setvideoDescribe(String videoDescribe) {
        this.videoDescribe = videoDescribe;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoID='" + videoID + '\'' +
                ", videoName='" + videoName + '\'' +
                ", videolookTime='" + videolookTime + '\'' +
                ", videoTime='" + videoTime + '\'' +
                ", videoState='" + videoState + '\'' +
                ", videocAtegory='" + videocAtegory + '\'' +
                ", videoImage='" + videoImage + '\'' +
                ", videoAddress='" + videoAddress + '\'' +
                ", videoCollection='" + videoCollection + '\'' +
                ", videoLeaving='" + videoLeaving + '\'' +
                ", userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", videoDescribe='" + videoDescribe + '\'' +
                '}';
    }
}