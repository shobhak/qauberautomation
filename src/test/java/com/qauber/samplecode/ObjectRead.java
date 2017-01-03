package com.qauber.samplecode;

import com.qauber.pagesresource.FileManager;
import com.qauber.pagesresource.User;

/**
 * Created by erikfriedlander on 12/29/16.
 */
public class ObjectRead {
    public static void main(String args[]) {


        User user = new User();
        user.setUsername("Denys@bestemail.com");
        user.setPassword("bestPassword");
        FileManager.writeConfigObject(user, "newUser.txt", "These are very important comments");
//        driver.quit();
    }
}
