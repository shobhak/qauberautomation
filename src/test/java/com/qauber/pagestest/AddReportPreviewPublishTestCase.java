package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alya on 12/19/2016.
 */
public class AddReportPreviewPublishTestCase {

    private WebDriver driver;

    private LoginPage login;
    private AddReportsOrganization addReportsOrganization;
    private NavBar navBar;
    private AddReportNavigation addReportNavigation;
    private AddReportPreview addReportPreview;
    private AddReportSubjectInformationPage addReportSubjectInformationPage;
    private AddReportEnvironment addReportEnvironment;

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

    @Test
    public void addReportPreviewPublish () throws InterruptedException {

        //Create all Page Objects
        login = new LoginPage(driver);
        navBar = new NavBar(driver);
        addReportsOrganization = new AddReportsOrganization(driver);
        addReportNavigation = new AddReportNavigation(driver);
        addReportPreview = new AddReportPreview(driver);
        addReportSubjectInformationPage = new AddReportSubjectInformationPage(driver);
        addReportEnvironment = new AddReportEnvironment(driver);

        //Log in to application
        Thread.sleep(5000);
        login.loginToWave("erikfqauber@gmail.com", "testwave");

        Thread.sleep(3000);

        //Go to 'Add Report'
        navBar.addReportButton().click();

        //Select first organization
        Thread.sleep(1000);
        addReportsOrganization.clickOrganization1();
        Thread.sleep(1000);

        addReportNavigation.subjectInformationTab().click();
        Thread.sleep(1000);
        addReportSubjectInformationPage.firstName().sendKeys("Sam");
        addReportSubjectInformationPage.lastName().sendKeys("Edelman");

        addReportNavigation.environmentTab().click();
        Thread.sleep(1000);
        addReportEnvironment.stopLocationField().sendKeys("Belmont");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-1000)", "");

        addReportNavigation.previewTab().click();
        Thread.sleep(1000);

        //jse = (JavascriptExecutor) driver;
        //jse.executeScript("window.scrollBy(0,1000)", "");

        //addReportPreview.previousButton().click();
        //Thread.sleep(1000);
        //addReportNavigation.previewTab().click();
        //Thread.sleep(1000);

        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)", "");

        addReportPreview.publishReportButton().click();
        }

        @AfterClass
        public void breakDown () throws InterruptedException {

            Thread.sleep(60000);

            driver.manage().deleteAllCookies();
            driver.quit();
        }
}
