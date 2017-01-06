package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jing Xu on 12/30/2016.
 */
public class RegularUserCannotSeeDeleteSubscriptionOrganization extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
    }

    @Test
    public void regularUserCannotSeeDeleteSubscriptionOrganization() throws InterruptedException {
        int deleteSubscriptionIndex;
        int entitiesListNumberRU;
        List<String> hideEntitiesNameListRU = new ArrayList<String>();
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
            Assert.assertEquals(getProfilePanel().settingsText().getText(), "Settings");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(2000);
        }

        deleteSubscriptionIndex = randomInt.nextInt(getProfilePanel().entitiesList().size()) + 1;
        System.out.println("Let's delete " + getProfilePanel().entitiesList().get(deleteSubscriptionIndex - 1).getText());
        getProfilePanel().organizationLink(deleteSubscriptionIndex).click();
        Thread.sleep(3000);

        getSubscriptionSettings().cancelSubscriptionButton().click();
        Thread.sleep(10000);

        // re-login as regular user
        setUpWithUser(User.UserType.RU, driver);
        Thread.sleep(2000);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);

        getHeader().userName().click();
        Thread.sleep(2000);

        getProfilePanel().settinsButton().click();
        Thread.sleep(2000);

        try{
            Assert.assertEquals(getProfilePanel().settingsText().getText(), "Settings");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(2000);
        }

        // Verify that there is no entity displayed for Regular users or Admin users
        try {
            entitiesListNumberRU = getProfilePanel().entitiesList().size();
            Assert.assertEquals(entitiesListNumberRU, 0);
        } catch (AssertionError e) {
            System.out.println("The Regular User can access the subscription, it is a bug!!!");
        }

        // finding out the hidden entities
        System.out.println("There are " + getProfilePanel().hideEntitiesForNonSAU().size() + " entities hiden from Regular Users.");
        for (int j = 0; j < getProfilePanel().hideEntitiesForNonSAU().size(); j++){
            hideEntitiesNameListRU.add((String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML", getProfilePanel().hideEntitiesForNonSAU().get(j)));
            System.out.println(hideEntitiesNameListRU.get(j));
        }

        Thread.sleep(2000);
    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
