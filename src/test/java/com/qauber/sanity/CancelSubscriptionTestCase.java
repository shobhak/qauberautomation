package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Jing Xu on 12/29/2016.
 * TODO: add conditions
 */
public class CancelSubscriptionTestCase extends PageObjectModelResources {
    private int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
//        testConfig().getTestRail().setCaseID(79853); //TestRail case ID
//        testConfig().getTestRail().setTester("Erik's Script"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void cancelSubscription() throws InterruptedException {
        int entities;
        int cancelentityindex;
        String str;
        Random randomInt = new Random();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime);

        try{
            Assert.assertEquals(getProfilePanel().subscriptionsText().getText(), "SUBSCRIPTIONS");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(sleepTime);
        }

        entities = getProfilePanel().entitiesList().size();
        System.out.println(entities);
        cancelentityindex = randomInt.nextInt(entities) + 1;
        System.out.println(cancelentityindex);
        getProfilePanel().organizationLink(cancelentityindex).click();
        Thread.sleep(sleepTime);

        getSubscriptionSettings().cancelSubscriptionButton().click();
        Thread.sleep(sleepTime);

        // on some system, the site logout after cancellation, this is to determine the state of the site
        // add re-login if site is logout
        try{
            Assert.assertEquals(true, getNavBar().reportsButton().isDisplayed());
        }
        catch (NoSuchElementException e) {
            getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
            Thread.sleep(sleepTime);
        }

        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime);

        str = getEntities().organizationSubscriptionUsers(cancelentityindex).getText();
        Assert.assertEquals(str.substring(str.indexOf(" ") + 1), "of 0 Users used");
        Thread.sleep(sleepTime);

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
