package com.qauber.pagesresource;

import com.qauber.pagesresource.preconditions.EntityPreconditions;
import com.qauber.pagesresource.preconditions.UsersPreconditions;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 1/4/17.
 */
public class PreconditionsResources {
    UsersPreconditions usersPreconditions;
    EntityPreconditions entityPreconditions;

    public PreconditionsResources(WebDriver driver) {
        usersPreconditions = new UsersPreconditions(driver);
        entityPreconditions = new EntityPreconditions(driver);
    }

    public UsersPreconditions getUsersPreconditions() {
        return usersPreconditions;
    }

    public EntityPreconditions getEntityPreconditions() { return entityPreconditions; }
}
