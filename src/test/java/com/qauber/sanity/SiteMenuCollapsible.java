package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/21/2016.
 */
public class SiteMenuCollapsible extends PageObjectModelResources {

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        setUpScript();
    }

    @Test
    public void siteMenuCollapsible() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
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
    public void breakDown() {
        breakDownHelper();
    }
}
