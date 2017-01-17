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
 *
 */
public class ContinueAnUnpublishedReport extends PageObjectModelResources {

    private int sleepTime;

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
        Thread.sleep(sleepTime);

        getReports().publishedOnCheckBox().click();
        Thread.sleep(sleepTime);

        getPreconditions().getReportPreconditions().ensureUnpublishedReportsAtLeast(1);

        if(getReports().publishedOnCheckBox().isSelected())
            getReports().publishedOnCheckBox().click();
        Thread.sleep(sleepTime);

        String keyWord = "last";
        try {
            getReports().pagination(keyWord).click();
            Thread.sleep(sleepTime);
        }
        catch (Exception e)
        {
            System.out.println("Here only one page with reports.");
        }

        getReports().selectReport(keyWord).click();
        Thread.sleep(sleepTime);

        try
        {
            String expectedPageHeader = "Field Interview Card";
            Assert.assertTrue(getAddReportOrganization().pageHeader().getText().equals(expectedPageHeader));
        }
        catch (AssertionError e)
        {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Unpublished report can't be continue: "+e.getLocalizedMessage());
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