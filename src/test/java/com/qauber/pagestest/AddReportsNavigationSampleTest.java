package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by erikfriedlander on 12/14/16.
 * This 'test' does the following:
 * 1. Log in
 * 2. Go to 'Add Report'
 * 3. Select first organization
 * 4. Cycle through all 'Add Report' navigational tabs
 */
public class AddReportsNavigationSampleTest {

    WebDriver driver;

    LoginPage login;
    HomePage homePage;
    NavBar navBar;
    AddReportNavigation addReportNavigation;
    AddReportsOrganization addReportsOrganization;

    @Test
    public void cycleAddReportsTabs () throws InterruptedException {

        //Create all Page Objects
        login = new LoginPage(driver);
        homePage = new HomePage(driver);
        navBar = new NavBar(driver);
        addReportsOrganization = new AddReportsOrganization(driver);
        addReportNavigation = new AddReportNavigation(driver);

        //Log in to application
        Thread.sleep(5000);
        login.loginToWave("erikfqauber@gmail.com", "testwave");

        Thread.sleep(3000);

        //Go to 'Reports'
        navBar.addReportButton().click();


        //Select first organization
        Thread.sleep(1000);
        addReportsOrganization.clickOrganization1();
        Thread.sleep(1000);

        //Cycle through tabs with 1 second wait
        addReportNavigation.subjectInformationTab().click();
        Thread.sleep(1000);
        addReportNavigation.environmentTab().click();
        Thread.sleep(1000);
        addReportNavigation.identifiersTab().click();
        Thread.sleep(1000);
        addReportNavigation.identificationInformationTab().click();
        Thread.sleep(1000);
        addReportNavigation.environmentTab().click();
        Thread.sleep(1000);
        addReportNavigation.vehicleTab().click();
        Thread.sleep(1000);
        addReportNavigation.photoTab().click();
        Thread.sleep(1000);
        addReportNavigation.previewTab().click();
        Thread.sleep(1000);
    }

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

    @AfterClass
    public void breakDown () throws InterruptedException {

        Thread.sleep(60000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
