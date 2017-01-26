package com.qauber.pagesresource;

/**
 * Created by erikfriedlander on 12/15/16.
 */
public class User {

    private String username;// = "user@gmail.com";
    private String password; //= "password";
    private String name; // = "Sample User";
    private String firstName;
    private String lastName;
    protected UserType userType;

    public User() {
         username="defaultUserName";
         password="defaultPassword";
         name="Default User";
         firstName = "Default";
         lastName = "User";
         userType=UserType.SAU;
    }


    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = this.firstName+" "+this.lastName;
    }

    public enum UserType {
        SAU,
        AU,
        RU
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




    public String getFirstName() {
        return firstName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
