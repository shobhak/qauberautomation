package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jing Xu on 12/30/2016.
 */
public class RegularUserNotDeleteOrChangeSubscription extends PageObjectModelResources {

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();

        testConfig().getTestRail().setCaseID(00000);    //add TC number from the TestRail
        testConfig().getTestRail().setTester("");       //add user name

        setUpUser(User.UserType.SAU);
        setUpScript();
    }

    @Test
    public void regularUserNotDeleteOrChangeSubscription() throws InterruptedException {
        List<String> entitiesNameListSAU = new ArrayList<String>();
        int entitiesListNumberRU;
        List<String> hideEntitiesNameListRU = new ArrayList<String>();

        getDriver().get(testConfig().getBaseURL());
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

        // List out the entities for Super Admin users
        System.out.println("There are " + getProfilePanel().entitiesList().size() + " entities for Super Admin Users.");
        for (int i = 0; i < getProfilePanel().entitiesList().size(); i++){
            entitiesNameListSAU.add(getProfilePanel().entitiesList().get(i).getText());
            System.out.println(entitiesNameListSAU.get(i));
        }

        getProfilePanel().userButton().click();
        Thread.sleep(2000);

        getNavBar().addReportButton().click();
        Thread.sleep(2000);

        getHeader().userName().click();
        Thread.sleep(2000);

        getProfilePanel().logOutButton().click();
        Thread.sleep(5000);

        setUpUser(User.UserType.RU);
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
            Assert.assertEquals(getProfilePanel().entitiesList().size(), 0);
        }
        catch(AssertionError e) {
            System.out.println("The Regular User can access the subscription, it is a bug!!!");
        }

        // finding out the hidden entities
        System.out.println("There are " + getProfilePanel().hideEntitiesForNonSAU().size() + " entities hiden from Regular Users.");
        for (int j = 0; j < getProfilePanel().hideEntitiesForNonSAU().size(); j++){
            hideEntitiesNameListRU.add((String) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].innerHTML", getProfilePanel().hideEntitiesForNonSAU().get(j)));
            System.out.println(hideEntitiesNameListRU.get(j));
        }

        Thread.sleep(2000);

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
