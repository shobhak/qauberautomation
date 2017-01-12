package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lenochka on 27.12.2016.
 * TODO: add asserts!
 * TODO: add to TestRail
 * TODO: (low priority) modify to create new user(s), then delete them :-)
 */
public class UserDeletionTestCase extends PageObjectModelResources {

    private int sleepTime;

    @BeforeClass
    public void setUp() throws InterruptedException {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);

//        testConfig().getTestRail().setCaseID(82764);
//        testConfig().getTestRail().setTester("MadMax");

        sleepTime = testConfig().getSleepTime();
        setUpScript();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
    }


    @Test
    public void userDeletion() throws InterruptedException {
        testDriver().get(Config.getBaseURL());
        Thread.sleep(sleepTime);

        //String emailName = "kennith.willms@hotmail.com";


        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        //preconditions
        getPreconditions().getUsersPreconditions().ensureUsersAtLeast(10);

        getNavBar().clickUsers();
        Thread.sleep(sleepTime);

        //getUserDeletion().deleteUserByEmail(emailName).click();
        // Thread.sleep(sleepTime);

        getUsers().deleteButtonByIndex(9).click();
        Thread.sleep(sleepTime);

        getUsers().deleteConfirmationButton().click();
        Thread.sleep(sleepTime);

    }


    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}