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
 */
public class SimpleSampleTestCase extends PageObjectModelResources {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
    }

    @Test
    public void simpleSampleTestCase() throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(3000);

        getLogin().loginToWave("erikfqauber@gmail.com", "testwave");
        getNavBar().clickAddReport();

        Thread.sleep(15000);

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
