package com.qauber.samplecode;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.PageResources;
import com.qauber.pagesresource.PageResourcesFactory;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SAUEnsurePreconditions extends PageObjectModelResources {

    int sleepTime;

    @BeforeClass
    public void setUp() throws InterruptedException {

        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.AU); //Pass in user
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere
        //Create driver & page objects, finish setup
        setUpScript();

    }

    @Test
    public void ensureAUcanManageEntities() throws InterruptedException {
        getPreconditions().getPermissionsPreconditions().ensureAUIsAdminAllEntities();
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime/2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime/2);
        getNavBar().entitiesButton().click();

    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
