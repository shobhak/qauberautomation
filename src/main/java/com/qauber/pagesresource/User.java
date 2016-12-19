package com.qauber.pagesresource;

/**
 * Created by erikfriedlander on 12/15/16.
 */
public class User {

    private String username = "user@gmail.com";
    private String password = "password";
    private String name = "Sample User";
    protected UserType userType;

    public User(ConfigOOP config) {

     }

     public User() {
         username="defaultUserName";
         password="defaultPassword";
         name="Default User";
         userType=UserType.SAU;
     }

    public enum UserType {
        SAU,
        AU,
        RU,
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return this.userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void listUserProperties() {
        System.out.println("User Type:"+getUserType().toString());
        System.out.println("User Name:"+getUsername());
        System.out.println("User Password:"+getPassword());
    }
}
