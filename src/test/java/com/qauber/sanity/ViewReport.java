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
 * Created by Alya on 12/20/2016.
 */
public class ViewReport extends PageObjectModelResources {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver);
    }

    @Test
    public void reportsViewReport() throws InterruptedException {
        int rowindex = 1;

        driver.get(Config.getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);
        getNavBar().clickReports();

        String searchReportResultID = getReports().searchReportResultID(rowindex).getText();

        getReports().selectReport(rowindex).click();
        Thread.sleep(5000);

        String reportID = getReportsViewReport().reportID().getText();
        String suspectName = getReportsViewReport().suspectName().getText();

        Assert.assertEquals(searchReportResultID,reportID + ". " + suspectName);
    }
    @AfterClass
    public void breakDown () throws InterruptedException {
        Thread.sleep(15000);
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}