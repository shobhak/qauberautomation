package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/21/2016.
 */
public class HeaderSiteLogoTestCase extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver);
    }

    @Test
    public void siteMenuCollapsible() throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);
        getNavBar().clickEntities();
        Thread.sleep(1000);
        getHeader().logo().click();
        Thread.sleep(1000);
        /*getNavBar().clickUsers();
        Thread.sleep(1000);
        getHeader().logo().click();
        Thread.sleep(1000);
        getNavBar().clickAddReport();
        Thread.sleep(1000);
        getHeader().logo().click();*/

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://testwave.qabidder.net/#/app/reports" );
    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
