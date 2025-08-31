package java_19.models;

import java_19.service.UserService;

public class User {
    private String userName;
    private String phoneNumber;
    private String gmail;
    private String password;
    public User() {}
    public User(String userName, String phoneNumber, String gmail, String password) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.gmail = gmail;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getGmail() {
        return gmail;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "service.impl.User{" +
                "userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gmail='" + gmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
