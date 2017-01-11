package com.qauber.samplecode;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SAUEnsurePreconditionsForRU extends PageObjectModelResources {

    int sleepTime;

    @BeforeClass
    public void setUp() throws InterruptedException {

        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.RU); //Pass in user
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere
        //Create driver & page objects, finish setup
        setUpScript();

    }

    @Test
    public void ensureAUcanManageEntities() throws InterruptedException {
        getPreconditions().getPermissionsPreconditions().ensureRUisRegUserToAll();
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime/2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime/2);
        Assert.assertFalse(getNavBar().entitiesButton().isDisplayed());

    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
