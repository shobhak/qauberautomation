package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.Header;
import com.qauber.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by erikfriedlander on 12/13/16.
 * Add a test description...
 * Login to application as (any user)
 * Verify user name on homepage
 */
public class HomePageUsernameCorrect {

    WebDriver driver;
    LoginPage login;
    Header header;


    String actualUserName = "Erik F";


    @Test
    public void testHomePageUsernameCorrect () throws InterruptedException {

        //Create POM objects
        login = new LoginPage(driver);
        header = new Header(driver);

        //go to website
        driver.get(Config.getBaseURL());

        //Verify Login Footer Text (so we're on right page)
        Assert.assertEquals(login.footerText().getText(), "© 2016 - FITS\n" + "FITS Web Application");
        Thread.sleep(3000);

        //Log in to application
        login.loginToWave("erikfqauber@gmail.com", "testwave");
        Thread.sleep(3000);

        //Verify user name on home page
        Assert.assertEquals(header.userName().getText(), actualUserName);
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //maximize window for our viewing pleasure
        driver.manage().window().maximize();
    }

    @AfterClass
    public void breakDown () throws InterruptedException {

        Thread.sleep(60000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
