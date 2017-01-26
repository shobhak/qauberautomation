package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by jingx on 1/20/2017.
 */
public class AdminCanOnlyInviteUserWithValidEmailAddress extends PageObjectModelResources {
    private int sleepTime;

    @BeforeTest
    public void setUp() {
        setUpWithConfigFile(); //Read config file from disk, create if not present

        //Misc configuration
        sleepTime = testConfig().getSleepTime();
    }

    @Test
    public void testAsSAU() throws InterruptedException {
        testConfig().getTestRail().setCaseID(82810);
        testConfig().getTestRail().setTester("Jing");
        setUpUser(User.UserType.SAU); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        setUpScript();
        adminCanOnlyInviteUserWithValidEmailAddress();

        breakDownHelper();//used to close window
    }
    @Test(priority = 1)
    public void testAsAU() throws InterruptedException {
        testConfig().getTestRail().setCaseID(82810);
        testConfig().getTestRail().setTester("Jing");
        setUpUser(User.UserType.AU); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        setUpScript();
        adminCanOnlyInviteUserWithValidEmailAddress();

    }

    public void adminCanOnlyInviteUserWithValidEmailAddress() throws InterruptedException {
        Faker faker = new Faker();
        String email = faker.name().firstName().toLowerCase() + "." + faker.name().lastName().toLowerCase() + "@mailinator.com";
        String[] Invalidemail = {"Abc.example.com", "A@b@c@example.com", "a\"b(c)d,e:f;g<h>i[j\\k]l@example.com",
                                "just\"not\"right@example.com", "this is\"not\\allowed@example.com",
                                "this\\ still\\\"not\\\\allowed@example.com",
                                "1234567890123456789012345678901234567890123456789012345678901234+x@example.com",
                                "john..doe@example.com", "john.doe@example..com"};

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().usersButton().click();
        Thread.sleep(sleepTime/2);

        // verify the invalid email address is detected
        for (int i = 0; i < Invalidemail.length; i++){
            try{
                getUsers().inviteUserButton().click();
                Thread.sleep(sleepTime/2);

                getUsers().inviteUserEmailField().sendKeys(Invalidemail[i]);
                Thread.sleep(sleepTime/2);

                Assert.assertEquals(true, getUsers().invalidEmailMessage().isDisplayed());
                Thread.sleep(sleepTime/3);

                getUsers().cancelButton().click();
                Thread.sleep(sleepTime/2);
            }
            catch (AssertionError e){
                testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "It fails to detect invalid email address: " + e.getLocalizedMessage() );
                throw e;
            }
        }

        // verify the valid email address is accepted and send an invitation with that address
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
