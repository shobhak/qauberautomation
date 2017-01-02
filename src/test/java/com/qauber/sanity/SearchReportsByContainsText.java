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
 * Created by Maksim on 12/26/2016.
 */
public class SearchReportsByContainsText extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;
    String someText = "Pet";
    String keyWord = "Clear";

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        sleepTime = 1000;
        setUpWithUser(User.UserType.SAU, driver);

        driver.get(Config.getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime*2);
    }

    @Test
    public void searchReportsByContainsText() throws InterruptedException
    {
        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime*2);

        getReports().containsTextField().clear();
        getReports().containsTextField().sendKeys(someText);
        Thread.sleep(sleepTime*2);

        getReports().publishedDateFromIcon(keyWord);
        Thread.sleep(sleepTime*2);

        Assert.assertTrue(getReports().searchReportResultID(1).getText().contains(someText));
    }

    @AfterClass
    public void breakDown()
    {
        breakDownHelper(driver);
    }
}