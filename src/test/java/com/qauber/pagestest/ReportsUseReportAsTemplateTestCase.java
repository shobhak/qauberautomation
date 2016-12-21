package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/20/2016.
 */

public class ReportsUseReportAsTemplateTestCase extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver);
    }

    @Test
    public void reportsViewReport() throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);
        getNavBar().clickReports();
        Thread.sleep(2000);
        getReports().selectReport(1).click();
        Thread.sleep(2000);
        getReportsViewReport().useAsTemplateButton().click();
        Thread.sleep(1000);
    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}


