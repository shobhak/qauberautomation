package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lenochka on 24.01.2017.
 */
public class TrialPeriodFlag extends PageObjectModelResources {
    private int sleepTime;


    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        sleepTime = testConfig().getSleepTime();
        testConfig().getTestRail().setCaseID(85192);
        testConfig().getTestRail().setTester("ElenaB");
        setUpScript();
    }

    @Test
    public void TrialPeriodFlag() throws InterruptedException{

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime * 2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime);

        getProfilePanel().trialPeriod().click();
        Thread.sleep(sleepTime);

        String trialPeriod = getProfilePanel().trialPeriod().getText();

        getProfilePanel().logOutButton().click();
        Thread.sleep(sleepTime);

        try{
            Assert.assertTrue(trialPeriod.equals("Trial Period"));

        }
        catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Trial Period flag is not visible " + e.getLocalizedMessage() );
            throw e;
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");


    }

    @AfterClass
    public void breakDown () {
        breakDownHelper();
    }
}
