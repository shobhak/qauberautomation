package com.qauber.pagestest;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by MadMax on 1/7/2017.
 */
public class SearchHelperTest extends PageObjectModelResources {

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
    public void ensureReportsAtLeastPreconditionTest() throws InterruptedException
    {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        //Log in...
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime);

        getReports().publishedOnCheckBox().click();
        Thread.sleep(sleepTime);

        System.out.println("Random case ID: "+getPreconditions().getSearchHelper().randomCaseID());
        System.out.println("Random first name: "+getPreconditions().getSearchHelper().randomFirstName());
        System.out.println("Random last name: "+getPreconditions().getSearchHelper().randomLastName());
        System.out.println("Random contain text: "+getPreconditions().getSearchHelper().randomContainText());
        System.out.println("Random date: "+getPreconditions().getSearchHelper().randomDate());
        System.out.println("Random month: "+getPreconditions().getSearchHelper().randomMonth());
        System.out.println("Random day: "+getPreconditions().getSearchHelper().randomDay());
        System.out.println("Random year: "+getPreconditions().getSearchHelper().randomYear());
        System.out.println("Random pagination: "+getPreconditions().getSearchHelper().randomPagination());
        System.out.println("Random suspect type: "+getPreconditions().getSearchHelper().randomSuspectType());
        System.out.println("Random report result: "+getPreconditions().getSearchHelper().randomReportResult());
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}