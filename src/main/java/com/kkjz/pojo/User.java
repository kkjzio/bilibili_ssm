package com.kkjz.pojo;

public class User {
    private String userID;

    private String userMingzi;

    private String userName;

    private String usersex;

    private String passWord;

    private String userAddress;

    private String userPhone;

    private String userQQ;

    private String userEmial;

    private String userCollection;

    private String useryinghangka;

    private String userState;

    private String userLoginTime;

    private String userIP;

    private String userPaypassword;

    private String userHand;

    private String userRMB;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID == null ? null : userID.trim();
    }

    public String getUserMingzi() {
        return userMingzi;
    }

    public void setUserMingzi(String userMingzi) {
        this.userMingzi = userMingzi == null ? null : userMingzi.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserQQ() {
        return userQQ;
    }

    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ == null ? null : userQQ.trim();
    }

    public String getUserEmial() {
        return userEmial;
    }

    public void setUserEmial(String userEmial) {
        this.userEmial = userEmial == null ? null : userEmial.trim();
    }

    public String getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(String userCollection) {
        this.userCollection = userCollection == null ? null : userCollection.trim();
    }

    public String getUseryinghangka() {
        return useryinghangka;
    }

    public void setUseryinghangka(String useryinghangka) {
        this.useryinghangka = useryinghangka == null ? null : useryinghangka.trim();
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    public String getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(String userLoginTime) {
        this.userLoginTime = userLoginTime == null ? null : userLoginTime.trim();
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP == null ? null : userIP.trim();
    }

    public String getUserPaypassword() {
        return userPaypassword;
    }

    public void setUserPaypassword(String userPaypassword) {
        this.userPaypassword = userPaypassword == null ? null : userPaypassword.trim();
    }

    public String getUserHand() {
        return userHand;
    }

    public void setUserHand(String userHand) {
        this.userHand = userHand == null ? null : userHand.trim();
    }

    public String getUserRMB() {
        return userRMB;
    }

    public void setUserRMB(String userRMB) {
        this.userRMB = userRMB == null ? null : userRMB.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userMingzi='" + userMingzi + '\'' +
                ", userName='" + userName + '\'' +
                ", usersex='" + usersex + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userQQ='" + userQQ + '\'' +
                ", userEmial='" + userEmial + '\'' +
                ", userCollection='" + userCollection + '\'' +
                ", useryinghangka='" + useryinghangka + '\'' +
                ", userState='" + userState + '\'' +
                ", userLoginTime='" + userLoginTime + '\'' +
                ", userIP='" + userIP + '\'' +
                ", userPaypassword='" + userPaypassword + '\'' +
                ", userHand='" + userHand + '\'' +
                ", userRMB='" + userRMB + '\'' +
                '}';
    }
}