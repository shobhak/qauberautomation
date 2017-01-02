package com.qauber.samplecode;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by erikfriedlander on 12/19/16.
 * DEPRECATED, DO NOT USE. by SimpleSampleConfigOOPTestCase.
 */

@Deprecated
public class SimpleSampleTestCase extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        sleepTime = 5000;
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
    }

    @Test
    public void simpleSampleTestCase() throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime*2);

        getNavBar().addReportButton().click();
        Thread.sleep(sleepTime);

        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime*2);
    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
