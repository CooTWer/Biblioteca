package com.twu.biblioteca.user;


public class User {
    private String userName;
    private String emailAddress;
    private String phoneNumber;
    private String libraryId;
    private String libraryPwd;

    public User(String userName, String emailAddress, String phoneNumber, String libraryId, String libraryPwd) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.libraryId = libraryId;
        this.libraryPwd = libraryPwd;
    }



    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public String getLibraryPwd() {
        return libraryPwd;
    }
}
