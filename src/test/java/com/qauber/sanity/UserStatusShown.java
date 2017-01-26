package com.qauber.sanity;

import com.qauber.assertutil.AssertUber;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 01/21/2017.
 */
public class UserStatusShown extends PageObjectModelResources {

    private int sleepTime;

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        sleepTime = testConfig().getSleepTime();
        testConfig().getTestRail().setCaseID(82811);
        testConfig().getTestRail().setTester("Alya");
        setUpScript();
    }

    @Test
    public void userStatusShown() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
        //in preconditions if users need to be created, they are created without activation
        getPreconditions().getUsersPreconditions().ensureUsersAtLeast(2);
        Thread.sleep(sleepTime);
        getNavBar().usersButton().click();
        Thread.sleep(sleepTime/2);

        AssertUber.assertTrue(getUsers().notRegistered().isDisplayed()||getUsers().active().isDisplayed(), "User status not displayed");

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
