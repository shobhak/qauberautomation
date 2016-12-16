package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.LoginPage;
import com.qauber.pages.NavBar;
import com.qauber.pages.Reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Max on 12/16/2016.
 * Test verify all functionalities of Reports page.
 */
public class ReportsSearchFunctionalityTest {

    WebDriver driver;

    LoginPage login;
    NavBar navBar;
    Reports reports;


    @BeforeTest
    public void SetUp() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(Config.getBaseURL());

        driver.manage().window().maximize();

        login = new LoginPage(driver);

        Thread.sleep(1000);
        login.loginToWave("raizzz.test@gmail.com", "013666");

    }

    @Test
    public void Search() throws InterruptedException {
        navBar = new NavBar(driver);

        navBar.reportsButton().click();

        reports = new Reports(driver);

        // Search by Last Name
        Thread.sleep(2000);
        reports.lastNameField().clear();
        reports.lastNameField().sendKeys("Pupkin");

        // Search by First Name
        Thread.sleep(2000);
        reports.firstNameField().clear();
        reports.firstNameField().sendKeys("Vasia");

        // Search by Case ID
        Thread.sleep(2000);
        reports.caseIdField().clear();
        reports.caseIdField().sendKeys("707");

        // Search by Suspect Type
        Thread.sleep(2000);
        reports.suspectType("Victim");
        reports.suspectType("");

        // Example
        Thread.sleep(2000);
        reports.publishedDateFromIcon("January", "01", "2013");
        reports.publishedDateToIcon("Today");

        Thread.sleep(3000);
        reports.createdDateFromIcon("January", "01", "2013");
        Thread.sleep(1000);
        reports.createdDateFromIcon("Clear");

        Thread.sleep(3000);
        reports.createdDateToIcon("January", "01", "2013");
        Thread.sleep(1000);
        reports.createdDateToIcon("Clear");

        Thread.sleep(3000);
        reports.publishedOnCheckBox().click();

        Thread.sleep(3000);
        reports.containsTextField().clear();
        reports.containsTextField().sendKeys("Vas");

        Thread.sleep(5000);
        reports.selectReport(1).click();

    }

    @AfterTest

    public void CloseBrowser() throws InterruptedException
    {
        Thread.sleep(10000);
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
