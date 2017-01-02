package com.qauber.samplecode;

import com.qauber.pagesresource.ConfigOOP;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by erikfriedlander on 12/24/16.
 */
public class SimpleSampleConfigOOPTestCase extends PageObjectModelResources {

//    WebDriver driver;
//    ConfigOOP config;
    int sleepTime;


    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        testConfig().setBrowserType(ConfigOOP.BrowserType.CHROME);
        setUpUser(User.UserType.SAU);

        testConfig().setSleepTime(6000);
        sleepTime = testConfig().getSleepTime();
        setUpScript();
    }

    @Test
    public void objectOrientedConfigTestCase() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
