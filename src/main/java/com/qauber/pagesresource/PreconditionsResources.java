package com.qauber.pagesresource;

import com.qauber.pagesresource.preconditions.UsersPreconditions;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 1/4/17.
 */
public class PreconditionsResources {
    UsersPreconditions usersPreconditions;

    public PreconditionsResources(WebDriver driver) {
        usersPreconditions = new UsersPreconditions(driver);
    }

    public UsersPreconditions getUsersPreconditions() {
        return usersPreconditions;
    }
}
