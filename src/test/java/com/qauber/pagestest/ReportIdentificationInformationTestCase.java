package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.*;
import javafx.scene.control.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenochka on 15.12.2016.
 */
public class ElenasTestCase {

    WebDriver driver;

    LoginPage login;
    NavBar navBar;
    AddReportsOrganization addReportsOrganization;
    AddReportNavigation addReportNavigation;
    AddReportIdentificationInformation addReportIdentificationInformation;

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
    public void testHomePageUsernameCorrect () throws InterruptedException {

        //Create Login Page Object
        login = new LoginPage(driver);
        navBar = new NavBar(driver);
        addReportsOrganization = new AddReportsOrganization(driver);
        addReportNavigation = new AddReportNavigation(driver);
        addReportIdentificationInformation = new AddReportIdentificationInformation(driver);

        // Verify Login Footer Text (so we're on right page)
        String loginPageFooterText = login.getLoginFooterText();
        Assert.assertEquals(loginPageFooterText, "© 2016 - FITS\n" + "FITS Web Application");
        Thread.sleep(3000);

        //Log in to application
        login.loginToWave("erikfqauber@gmail.com", "testwave");
        Thread.sleep(3000);

        // Click on add rep button
        navBar.addReportButton().click();
        Thread.sleep(3000);

        // Add Report
        addReportsOrganization.clickOrganization1();
        Thread.sleep(3000);

        // Navigate
        addReportNavigation.identificationInformationTab().click();


        //Navigate to Add ID Info
        addReportIdentificationInformation.primaryLanguageField().sendKeys("Nepalese");
        Thread.sleep(2000);
        addReportIdentificationInformation.streetAddressField().sendKeys("123 Any street");
        Thread.sleep(2000);
        addReportIdentificationInformation.cityField().sendKeys("Moscow");
        Thread.sleep(2000);
        addReportIdentificationInformation.countryField().sendKeys("Russia");
        Thread.sleep(2000);
        //addReportIdentificationInformation.stateField().sendKeys("undefined");
        Thread.sleep(2000);
        addReportIdentificationInformation.zipField().sendKeys("95608");
        Thread.sleep(2000);
        addReportIdentificationInformation.phoneField().sendKeys("1234567890");
        Thread.sleep(2000);
        addReportIdentificationInformation.emailField().sendKeys("anymail@mail.us");
        Thread.sleep(2000);
        addReportIdentificationInformation.ssnField().sendKeys("333555888");
        Thread.sleep(2000);
        addReportIdentificationInformation.occupationField().sendKeys("plumber");
        Thread.sleep(2000);
       /*addReportIdentificationInformation.driverLicenseField().sendKeys("Q09876541");
        Thread.sleep(2000);
        addReportIdentificationInformation.otherIDField().sendKeys("2376hbfjbv");
        Thread.sleep(2000);
        addReportIdentificationInformation.schoolNameField().sendKeys("The Best School on the Block");
        Thread.sleep(2000);
        addReportIdentificationInformation.parentNameField().sendKeys("The Schwarzeneggers");
        Thread.sleep(2000);*/

       //Next Button
       addReportIdentificationInformation.nextButton().click();
        Thread.sleep(2000);

        //Navigate
        addReportNavigation.identificationInformationTab().click();
        Thread.sleep(2000);

        //Previous Button
        addReportIdentificationInformation.previousButton().click();
        Thread.sleep(2000);

        // Navigate
        addReportNavigation.identificationInformationTab().click();
        Thread.sleep(2000);*/


    }



    @AfterClass
        public void breakDown () throws InterruptedException {

        Thread.sleep(10000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}


