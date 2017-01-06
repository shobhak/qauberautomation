package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Jing Xu on 12/29/2016.
 */
public class CancelSubscriptionTestCase extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
    }

    @Test
    public void cancelSubscription() throws InterruptedException {
        int entities;
        int cancelentityindex;
        String str;
        Random randomInt = new Random();

        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);

        getHeader().userName().click();
        Thread.sleep(2000);

        getProfilePanel().settinsButton().click();
        Thread.sleep(2000);

        try{
            Assert.assertEquals(getProfilePanel().subscriptionsText().getText(), "SUBSCRIPTIONS");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(2000);
        }

        entities = getProfilePanel().entitiesList().size();
        System.out.println(entities);
        cancelentityindex = randomInt.nextInt(entities) + 1;
        System.out.println(cancelentityindex);
        getProfilePanel().organizationLink(cancelentityindex).click();
        Thread.sleep(3000);

        getSubscriptionSettings().cancelSubscriptionButton().click();
        Thread.sleep(10000);

        try{
            Assert.assertEquals(true, getNavBar().reportsButton().isDisplayed());
        }
        catch (NoSuchElementException e) {
            getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
            Thread.sleep(5000);
        }

        getNavBar().entitiesButton().click();
        Thread.sleep(2000);

        str = getEntities().organizationSubscriptionUsers(cancelentityindex).getText();
        Assert.assertEquals(str.substring(str.indexOf(" ") + 1), "of 0 Users used");
        Thread.sleep(2000);

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
