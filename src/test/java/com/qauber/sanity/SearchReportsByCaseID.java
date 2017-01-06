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
public class SearchReportsByCaseID extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;
    String caseID = "101";
    String keyWord = "Clear";

    @BeforeClass
    public void setUp() throws InterruptedException {

        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);

        testConfig().getTestRail().setCaseID(82761);
        testConfig().getTestRail().setTester("MadMax");

        sleepTime = testConfig().getSleepTime();
        setUpScript();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
    }

    @Test
    public void searchReportsByCaseID() throws InterruptedException
    {
        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime);

        getReports().caseIdField().clear();
        getReports().caseIdField().sendKeys(caseID);
        Thread.sleep(sleepTime);

        getReports().publishedDateFromIcon(keyWord);
        Thread.sleep(sleepTime);

        getReports().selectReport(1).click();
        Thread.sleep(sleepTime);

        try {
            Assert.assertTrue(getReportsViewReport().caseID().getText().equals(caseID));
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