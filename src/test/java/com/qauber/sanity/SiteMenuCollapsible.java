package com.qauber.sanity;

import com.qauber.assertutil.AssertUber;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/21/2016.
 */
public class SiteMenuCollapsible extends PageObjectModelResources {

    private int sleepTime;

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        sleepTime = testConfig().getSleepTime();
        testConfig().getTestRail().setCaseID(82778);
        testConfig().getTestRail().setTester("Alya");
        setUpScript();
    }

    @Test
    public void siteMenuCollapsible() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        //collapse
        getHeader().hamburgerMenu().click();
        Thread.sleep(sleepTime/2);

        AssertUber.assertFalse(getNavBar().mainNavigationText().isDisplayed(), "MainNavigationText displayed");

        //uncollapse
        getHeader().hamburgerMenu().click();
        Thread.sleep(sleepTime/2);

        AssertUber.assertTrue(getNavBar().mainNavigationText().isDisplayed(), "MainNavigationText not displayed");

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
