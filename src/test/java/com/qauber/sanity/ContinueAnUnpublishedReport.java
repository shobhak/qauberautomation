package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Maksim on 12/26/2016.
 * TODO: preconditions
 */
public class ContinueAnUnpublishedReport extends PageObjectModelResources {

    private int sleepTime;
    String keyWord = "last";
    String expectedPageHeader = "Field Interview Card";

    @BeforeClass
    public void setUp() throws InterruptedException {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);

        testConfig().getTestRail().setCaseID(82760);
        testConfig().getTestRail().setTester("MadMax");

        sleepTime = testConfig().getSleepTime();
        setUpScript();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
    }

    @Test
    public void continueAnUnpublishedReport() throws InterruptedException
    {
        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime*2);

        getReports().publishedOnCheckBox().click();
        Thread.sleep(sleepTime*2);

        try {
            getReports().pagination(keyWord).click();
            Thread.sleep(sleepTime * 2);
        }
        catch (Exception e)
        {}

        getReports().selectReport(keyWord).click();
        Thread.sleep(sleepTime*2);

        try
        {
            Assert.assertTrue(getAddReportOrganization().pageHeader().getText().equals(expectedPageHeader));
        }
        catch (AssertionError e)
        {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Can't continue an unpublished report: "+e.getLocalizedMessage());
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