package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
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
 * TODO: add case to TestRail
 * TODO: is the first assert part of the test case? if not, replace assertEquals with .equals()
 */
public class RegularUserNotDeleteOrChangeSubscription extends PageObjectModelResources {
    private int sleepTime;

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();

        testConfig().getTestRail().setCaseID(82809);    //add TC number from the TestRail
        testConfig().getTestRail().setTester("Jing");       //add user name

        sleepTime = testConfig().getSleepTime();
        setUpUser(User.UserType.SAU);
        setUpScript();
    }

    @Test
    public void regularUserNotDeleteOrChangeSubscription() throws InterruptedException {
        List<String> entitiesNameListSAU = new ArrayList<String>();
        int entitiesListNumberRU;
        List<String> hideEntitiesNameListRU = new ArrayList<String>();

        getDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime/2);

        try{
            Assert.assertEquals(getProfilePanel().settingsText().getText(), "Settings");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);
        }

        // List out the entities for Super Admin users
        System.out.println("There are " + getProfilePanel().entitiesList().size() + " entities for Super Admin Users.");
        for (int i = 0; i < getProfilePanel().entitiesList().size(); i++){
            entitiesNameListSAU.add(getProfilePanel().entitiesList().get(i).getText());
            System.out.println(entitiesNameListSAU.get(i));
        }

        getProfilePanel().userButton().click();
        Thread.sleep(sleepTime/2);

        getNavBar().addReportButton().click();
        Thread.sleep(sleepTime/2);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().logOutButton().click();
        Thread.sleep(sleepTime);

        setUpUser(User.UserType.RU);
        Thread.sleep(sleepTime/2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime/2);

        try{
            Assert.assertEquals(getProfilePanel().settingsText().getText(), "Settings");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);
        }

        // Verify that there is no entity displayed for Regular users or Admin users
        try {
            Assert.assertEquals(getProfilePanel().entitiesList().size(), 0);
        }
        catch(AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "There are some organization in profile panel: " + e.getLocalizedMessage() );
            throw e;
        }
        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test Passed.");
        Thread.sleep(sleepTime*2);

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
