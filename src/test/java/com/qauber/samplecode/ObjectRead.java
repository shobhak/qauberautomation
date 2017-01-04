package com.qauber.samplecode;

import com.qauber.pagesresource.FileManager;
import com.qauber.pagesresource.User;

import java.io.IOException;

/**
 * Created by erikfriedlander on 1/3/17.
 */
public class ObjectRead {
    public static void main(String args[]) throws IOException {

        User user = FileManager.getConfigObject("newUser.txt", User.class);

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

}
