package com.kkjz.pojo;

public class Message {
    private String messageID;

    private String messagevideoID;

    private String messageuserID;

    private String messageuserName;

    private String messageTime;

    private String message;

    private String messageHand;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID == null ? null : messageID.trim();
    }

    public String getMessagevideoID() {
        return messagevideoID;
    }

    public void setMessagevideoID(String messagevideoID) {
        this.messagevideoID = messagevideoID == null ? null : messagevideoID.trim();
    }

    public String getMessageuserID() {
        return messageuserID;
    }

    public void setMessageuserID(String messageuserID) {
        this.messageuserID = messageuserID == null ? null : messageuserID.trim();
    }

    public String getMessageuserName() {
        return messageuserName;
    }

    public void setMessageuserName(String messageuserName) {
        this.messageuserName = messageuserName == null ? null : messageuserName.trim();
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime == null ? null : messageTime.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getMessageHand() {
        return messageHand;
    }

    public void setMessageHand(String messageHand) {
        this.messageHand = messageHand == null ? null : messageHand.trim();
    }
}