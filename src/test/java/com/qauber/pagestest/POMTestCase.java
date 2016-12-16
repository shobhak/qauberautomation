package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.Header;
import com.qauber.pages.LoginPage;
import com.qauber.pages.NavBar;
import com.qauber.pages.Reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by erikfriedlander on 12/14/16.
 * This 'test' does the following:
 * 1. Log in
 * 2. Cycle through Nav bar
 * 3. Find reports containing text 'Bar'
 * 4. Open first report
 */
public class POMTestCase {

    WebDriver driver;

    LoginPage login;
    Header header;
    NavBar navBar;
    Reports reports;


    String actualUserName = "Erik F";

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //maximize window for our viewing pleasure
        driver.manage().window().maximize();
    }

    @Test
    public void testHomePageUsernameCorrect () throws InterruptedException {

        //Create POM objects
        login = new LoginPage(driver);
        header = new Header(driver);
        navBar = new NavBar(driver);

        //Go to website
        driver.get(Config.getBaseURL());
        Thread.sleep(3000);

        //Log in to application
        login.loginToWave("erikfqauber@gmail.com", "testwave");
        Thread.sleep(3000);

        //Open 'home page' in Selenium...
        header = new Header(driver);

        //Verify user name on home page
        Assert.assertEquals(header.userName().getText(), actualUserName);

        //Cycle through buttons with pause
        navBar.entitiesButton().click();
        Thread.sleep(2500);
        navBar.usersButton().click();
        Thread.sleep(2500);
        navBar.addReportButton().click();
        Thread.sleep(2500);
        navBar.reportsButton().click();
        Thread.sleep(2500);

        //Open 'Reports' in Selenium
        reports = new Reports(driver);

        //Click 'Published on' Checkbox
        reports.clickPublishedOnCheckbox();
        Thread.sleep(2000);

        //Find report which contains...
        reports.setContainsText("Bar");
        Thread.sleep(2000);

        //Select first report
        reports.selectReport(1).click();
        Thread.sleep(10000);

        //Open image
        reports.clickPicture1();

    }

    @AfterClass
    public void breakDown () throws InterruptedException {

        Thread.sleep(10000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
