package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maksim on 12/16/2016.
 */


public class AddReportsPhotoTest {

    WebDriver driver;

    LoginPage login;
    NavBar navBar;
    AddReportNavigation navigation;
    AddReportPhoto photo;
    AddReportsOrganization organization;


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
    public void Search() throws InterruptedException, AWTException {

        navBar = new NavBar(driver);

        // Click add report button
        Thread.sleep(1000);
        navBar.addReportButton().click();

        // Choose the first organization in list
        Thread.sleep(1000);
        organization = new AddReportsOrganization(driver);
        organization.clickOrganization1();

        navigation = new AddReportNavigation(driver);

        // Navigate to photo tab
        Thread.sleep(1000);
        navigation.photoTab().click();

        photo = new AddReportPhoto(driver);

        // Verify Previous button
        Thread.sleep(1000);
        photo.previousButton().click();
        Thread.sleep(1000);
        navigation.photoTab().click();

        // Verify Next button
        Thread.sleep(1000);
        photo.nextButton().click();
        Thread.sleep(1000);
        navigation.photoTab().click();

        // Upload 5 photo, one by one
        Thread.sleep(3000);
        photo.addPhotoButton("C:\\1.png");
        Thread.sleep(3000);
        photo.addPhotoButton("C:\\1.png");
        Thread.sleep(3000);
        photo.addPhotoButton("C:\\1.png");
        Thread.sleep(3000);
        photo.addPhotoButton("C:\\1.png");
        Thread.sleep(3000);
        photo.addPhotoButton("C:\\1.png");
        Thread.sleep(3000);

        // Verify that warning message is displayed.
        Assert.assertTrue(photo.warningMessage().isDisplayed());

        // Delete photo 5
        Thread.sleep(2000);
        photo.deletePhotoIcon(5).click();
        // Delete photo 1 (by default)
        Thread.sleep(2000);
        photo.deletePhotoIcon().click();
    }

    @AfterTest

    public void CloseBrowser() throws InterruptedException
    {
        Thread.sleep(10000);
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

