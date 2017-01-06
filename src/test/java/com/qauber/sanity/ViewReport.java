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
 */
public class ViewReport extends PageObjectModelResources {

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.RU);
        testConfig().getTestRail().setCaseID(79855);
        testConfig().getTestRail().setTester("Alya");
        setUpScript();
    }

    @Test
    public void reportsViewReport() throws InterruptedException {
        int rowindex = 1;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);
        getNavBar().reportsButton().click();
        Thread.sleep(2000);
        getReports().clickPublishedOnCheckbox();
        Thread.sleep(2000);

        String searchReportResultID = getReports().searchReportResultID(rowindex).getText();

        getReports().selectReport(rowindex).click();
        Thread.sleep(5000);

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
