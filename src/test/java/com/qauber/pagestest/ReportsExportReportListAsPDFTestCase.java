package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/20/2016.
 */
public class ReportsExportReportListAsPDFTestCase extends PageObjectModelResources{
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver);
    }

    @Test
    public void reportsExportReportListAsPDF() throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);
        getReports().exportReportsListButton().click();
    }
    /*@AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }*/
}
