package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

/**
 * Created by Jing Xu on 12/27/2016.
 */
public class InviteUserFromUsersListTestCase extends PageObjectModelResources {
    private int sleepTime;

    @BeforeTest
    public void setUp() {
        setUpWithConfigFile(); //Read config file from disk, create if not present

        //Misc configuration
        sleepTime = testConfig().getSleepTime();
    }

    @Test
    public void testAsSAU() throws InterruptedException {
        testConfig().getTestRail().setCaseID(82799);
        testConfig().getTestRail().setTester("Jing");
        setUpUser(User.UserType.SAU); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        setUpScript();
        inviteUserFromUsersList();

        breakDownHelper();//used to close window
    }
    @Test(priority = 1)
    public void testAsAU() throws InterruptedException {
        testConfig().getTestRail().setCaseID(82799);
        testConfig().getTestRail().setTester("Jing");
        setUpUser(User.UserType.AU); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        setUpScript();
        inviteUserFromUsersList();

    }
    public void inviteUserFromUsersList() throws InterruptedException {
        Faker faker = new Faker();
        String email = faker.name().firstName().toLowerCase() + "." + faker.name().lastName().toLowerCase() + "@mailinator.com";

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().usersButton().click();
        Thread.sleep(sleepTime/2);

        getUsers().inviteUserButton().click();
        Thread.sleep(sleepTime/2);

        getUsers().inviteUserEmailField().sendKeys(email);
        Thread.sleep(sleepTime/2);

        getUsers().cancelButton().click();
        Thread.sleep(sleepTime/2);

        getUsers().inviteUserButton().click();
        Thread.sleep(sleepTime/2);

        getUsers().inviteUserEmailField().sendKeys(email);
        Thread.sleep(sleepTime/2);

        getUsers().sendInviteButton().click();
        Thread.sleep(sleepTime);

        while (getUsers().nextPageButtonEnabled()){
            getUsers().nextPageButton().click();
            Thread.sleep(sleepTime/2);
        }


        try {
            Assert.assertEquals(email, getUsers().userNameRows().get(getUsers().userNameRows().size() - 1).getText());
        } catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Invited user email address not match: " + e.getLocalizedMessage() );
            throw e;
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test Passed.");
        Thread.sleep(sleepTime*2);

    }

    @AfterTest
    public void breakDown(){
        breakDownHelper();
    }
}
