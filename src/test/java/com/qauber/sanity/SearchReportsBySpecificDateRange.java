package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Maksim on 12/26/2016.
 */
public class SearchReportsBySpecificDateRange extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;
    String date1;
    String date2;

    @BeforeClass
    public void setUp() throws InterruptedException {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);

        testConfig().getTestRail().setCaseID(82767);
        testConfig().getTestRail().setTester("MadMax");

        sleepTime = testConfig().getSleepTime();
        setUpScript();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
    }

    @Test
    public void searchReportsBySpecificDateRange () throws InterruptedException
    {
        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime*2);

        date1 = getPreconditions().getSearchHelper().randomDate();
        getReports().publishedDateFromIcon(date1);
        getReports().publishedDateToIcon(date1);
        Thread.sleep(sleepTime*2);

        date2 = getPreconditions().getSearchHelper().randomDate();
        getReports().createdDateFromIcon(date2);
        getReports().createdDateToIcon(date2);
        Thread.sleep(sleepTime*2);

        try {
            Assert.assertTrue(getReports().searchReportResultPublishedDate(date1).isDisplayed());
        }
        catch (AssertionError e)
        {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Search failed: "+e.getLocalizedMessage());
            throw e;
        }
        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    @AfterClass
    public void breakDown()
    {
        breakDownHelper();
    }
}

