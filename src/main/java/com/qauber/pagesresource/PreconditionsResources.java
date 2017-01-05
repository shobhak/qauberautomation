package com.qauber.pagesresource;

import com.qauber.pagesresource.preconditions.UsersPreconditionsSampleRunAsSeparateUser;
import com.qauber.pagesresource.preconditions.UsersPreconditions;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 1/4/17.
 */
public class PreconditionsResources {
    UsersPreconditions usersPreconditions;
    UsersPreconditionsSampleRunAsSeparateUser samplePreconditionsAsSeparateUser;

    public PreconditionsResources(WebDriver driver) {
        usersPreconditions = new UsersPreconditions(driver);
        samplePreconditionsAsSeparateUser = new UsersPreconditionsSampleRunAsSeparateUser();
    }

    public UsersPreconditions getUsersPreconditions() {
        return usersPreconditions;
    }

    public UsersPreconditionsSampleRunAsSeparateUser getSamplePreconditionsAsSeparateUser() {
        return samplePreconditionsAsSeparateUser;
    }
}
