package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.LoginPage;
import com.qauber.pages.HomePage;
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
    HomePage homePage;


    String actualUserName = "Erik F";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //pull URL from config
        driver.get(Config.getBaseURL());

        //maximize window for our viewing pleasure
        driver.manage().window().maximize();
    }


    @Test
    public void testHomePageUsernameCorrect () throws InterruptedException {

        //Create Login Page Object
        login = new LoginPage(driver);

        //Verify Login Footer Text (so we're on right page)
        String loginPageFooterText = login.getLoginFooterText();
        Assert.assertEquals(loginPageFooterText, "© 2016 - FITS\n" + "FITS Web Application");

        Thread.sleep(3000);

        //Log in to application
        login.loginToWave("erikfqauber@gmail.com", "testwave");

        Thread.sleep(3000);

        //Open 'home page' in Selenium...
        homePage = new HomePage(driver);

        //Verify user name on home page
        Assert.assertEquals(homePage.getHomePageUserName(), actualUserName);
    }

    @AfterClass
    public void breakDown () throws InterruptedException {

        Thread.sleep(60000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
