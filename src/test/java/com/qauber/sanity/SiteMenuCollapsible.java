package com.qauber.sanity;

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
public class SiteMenuCollapsible extends PageObjectModelResources {
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
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);

        //collapse
        getHeader().hamburgerMenu().click();
        Thread.sleep(1000);
        Assert.assertFalse(getNavBar().mainNavigationText().isDisplayed());

        //uncollapse
        getHeader().hamburgerMenu().click();
        Thread.sleep(1000);
        Assert.assertTrue(getNavBar().mainNavigationText().isDisplayed());
    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
