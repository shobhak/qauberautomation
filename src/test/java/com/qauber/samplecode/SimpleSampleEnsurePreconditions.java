package com.qauber.samplecode;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by erikfriedlander on 1/03/16.
 * This test case demonstrates the use of preconditions.
 */
public class SimpleSampleEnsurePreconditions extends PageObjectModelResources {

    int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void ensureUsersAtLeastPreconditionTest() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
//        Thread.sleep(sleepTime);

        //Log in...
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().clickEntities();

        ///////ENSURE PRECONDITION: AT LEAST n USERS
        getPreconditions().getUsersPreconditions().ensureUsersAtLeast(28);
//        getPreconditions().getSamplePreconditionsAsSeparateUser().ensureUsersAtLeast(22);
//        getPreconditions().getSamplePreconditionsAsSeparateUser().ensureUsersAtLeast(24);

    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
