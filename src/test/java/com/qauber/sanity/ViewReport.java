package com.qauber.sanity;

import com.qauber.assertutil.AssertUber;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.apache.commons.lang3.StringUtils;
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
        String suspectType = getReportsViewReport().suspectType().getText();
        String IdName = reportID + ". " + suspectName;
        String IdNameType = reportID + ". " + suspectName + " (" + suspectType + ")";

        if (StringUtils.isBlank(suspectType)) {
            AssertUber.assertEquals(searchReportResultID, IdName, "ReportID and suspectName don't match ");
        } else {
            AssertUber.assertEquals(searchReportResultID, IdNameType, "ReportID, suspectName, suspectType don't match ");
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
