package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/21/2016.
 */
public class SiteLogoLeadsToReports extends PageObjectModelResources {

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        testConfig().getTestRail().setCaseID(82776);
        testConfig().getTestRail().setTester("Alya");
        setUpScript();
    }

    @Test
    public void siteMenuCollapsible() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);
        getNavBar().addReportButton().click();
        Thread.sleep(1000);
        getHeader().logo().click();

        String url = getDriver().getCurrentUrl();

        try {
            Assert.assertEquals(url, "http://testwave.qabidder.net/#/app/reports");
        } catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Logo does not lead to reports "+e.getLocalizedMessage());
            throw e;
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");

    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
