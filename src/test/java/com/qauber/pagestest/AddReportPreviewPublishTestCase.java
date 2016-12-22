package com.qauber.pagestest;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pages.*;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alya on 12/19/2016.
 */

//creating report using required fields

public class AddReportPreviewPublishTestCase extends PageObjectModelResources {

    /*private WebDriver driver;

    private LoginPage login;
    private AddReportsOrganization addReportsOrganization;
    private NavBar navBar;
    private AddReportNavigation addReportNavigation;
    private AddReportPreview addReportPreview;
    private AddReportSubjectInformationPage addReportSubjectInformationPage;
    private AddReportEnvironment addReportEnvironment;
    private Reports reports;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //pull URL from config
        driver.get(Config.getBaseURL());
        //maximize window for our viewing pleasure
        driver.manage().window().maximize();
    }*/

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver);
    }

    @Test
    public void addReportPreviewPublish () throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        Faker faker = new Faker();

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);

        //Create all Page Objects
        /*login = new LoginPage(driver);
        navBar = new NavBar(driver);
        addReportsOrganization = new AddReportsOrganization(driver);
        addReportNavigation = new AddReportNavigation(driver);
        addReportPreview = new AddReportPreview(driver);
        addReportSubjectInformationPage = new AddReportSubjectInformationPage(driver);
        addReportEnvironment = new AddReportEnvironment(driver);
        reports = new Reports(driver);

        //Log in to application
        Thread.sleep(5000);
        login.loginToWave("erikfqauber@gmail.com", "testwave");
        Thread.sleep(3000);*/

        //Go to 'Add Report'
        getNavBar().addReportButton().click();

        //Select first organization
        Thread.sleep(1000);
        getAddReportOrganization().clickOrganization1();
        Thread.sleep(1000);

        getAddReportNavigation().subjectInformationTab().click();
        Thread.sleep(1000);
        getAddReportSubjectInformationPage().firstName().sendKeys(faker.name().firstName());
        getAddReportSubjectInformationPage().lastName().sendKeys(faker.name().lastName());
        Thread.sleep(1000);

        getAddReportNavigation().environmentTab().click();
        Thread.sleep(1000);
        getAddReportEnvironment().stopLocationField().sendKeys(faker.address().city());
        Thread.sleep(1000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-1000)", "");

        getAddReportNavigation().previewTab().click();
        Thread.sleep(1000);

        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2000)", "");

        getAddReportPreview().previousButton().click();
        Thread.sleep(1000);
        getAddReportNavigation().previewTab().click();
        Thread.sleep(1000);

        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)", "");

        getAddReportPreview().publishReportButton().click();
    }

    @AfterClass
    public void breakDown () throws InterruptedException {
        Thread.sleep(60000);
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
