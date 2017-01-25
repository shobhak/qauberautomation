package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime.typeof;

/**
 * Created by lenochka on 23.01.2017.
 */
public class ProfilePanelSettingsTabClickable extends PageObjectModelResources {
    private int sleepTime;

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        sleepTime = testConfig().getSleepTime();
        testConfig().getTestRail().setCaseID(85191);
        testConfig().getTestRail().setTester("ElenaB");
        setUpScript();
    }

    @Test
    public void ProfilePanelSettingsTabClickable() throws InterruptedException {

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime * 2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime);

        getProfilePanel().settingsText().getText();
        Thread.sleep(sleepTime);

        String setting = getProfilePanel().settingsText().getText();

        getProfilePanel().userButton().click();
        Thread.sleep(sleepTime);

        getProfilePanel().logOutButton().click();
        Thread.sleep(sleepTime);


       try{
            Assert.assertTrue(setting.equals("Settings"));

        }
        catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Settings tab is not clickable " + e.getLocalizedMessage() );
            throw e;
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");

    }


    @AfterClass
        public void breakDown () {
            breakDownHelper();
        }


}
