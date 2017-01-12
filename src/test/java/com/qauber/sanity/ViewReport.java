package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/20/2016.
 * TODO: add preconditions, fix assert to handle middle name/suspect type/gang name
 */
public class ViewReport extends PageObjectModelResources {

    private int sleepTime;
    
    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        testConfig().getTestRail().setCaseID(79855);
        testConfig().getTestRail().setTester("Alya");
        sleepTime = testConfig().getSleepTime();
        setUpScript();
    }

    @Test
    public void reportsViewReport() throws InterruptedException {
        int rowindex = 1;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime/2);
        getReports().publishedOnCheckBox().click();
        Thread.sleep(sleepTime/2);

        String searchReportResultID = getReports().searchReportResultID(rowindex).getText();

        getReports().selectReport(rowindex).click();
        Thread.sleep(sleepTime);

        String reportID = getReportsViewReport().reportID().getText();
        String suspectName = getReportsViewReport().suspectName().getText();


        try {
            Assert.assertEquals(searchReportResultID,reportID + ". " + suspectName);
            } catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Report ID and suspect name do not match "+e.getLocalizedMessage());
            throw e;
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
