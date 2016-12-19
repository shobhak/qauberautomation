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
public class ReportIdentificationInformationTestCase {

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
    public void reportIdentificationInformationTestCase() throws InterruptedException {

        //Create Login Page Object
        login = new LoginPage(driver);
        navBar = new NavBar(driver);
        addReportsOrganization = new AddReportsOrganization(driver);
        addReportNavigation = new AddReportNavigation(driver);
        addReportIdentificationInformation = new AddReportIdentificationInformation(driver);

        /*Verify Login Footer Text (so we're on right page)
        String loginPageFooterText = login.getLoginFooterText();
        Assert.assertEquals(loginPageFooterText, "© 2016 - FITS\n" + "FITS Web Application");
        Thread.sleep(3000);*/

        //Log in to application
        Thread.sleep(5000);
        login.loginToWave("erikfqauber@gmail.com", "testwave");
        Thread.sleep(5000);

        // Click on add rep button
        navBar.addReportButton().click();
        Thread.sleep(3000);

        // Add Report
        addReportsOrganization.clickOrganization1();
        Thread.sleep(3000);

        // Navigate
        addReportNavigation.identificationInformationTab().click();


        //Navigate to Add ID Info
        addReportIdentificationInformation.primaryLanguageField().sendKeys("Russian");
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
        addReportIdentificationInformation.driverLicenseField().sendKeys("Q09876541");
        Thread.sleep(2000);
        addReportIdentificationInformation.driverlicenseDropList("California").click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        addReportIdentificationInformation.otherIDField().sendKeys("2376hbfjbv");
        Thread.sleep(2000);
        addReportIdentificationInformation.schoolNameField().sendKeys("The Best School on the Block");
        Thread.sleep(2000);
        addReportIdentificationInformation.schoolAddress().sendKeys("");
        Thread.sleep(2000);
        addReportIdentificationInformation.schoolCity().sendKeys("Austin");
        Thread.sleep(2000);

        addReportIdentificationInformation.schoolStateDropList("Texas").click();
        Thread.sleep(4000);

        addReportIdentificationInformation.schoolZip().sendKeys("5671897");
        Thread.sleep(2000);

        addReportIdentificationInformation.schoolTelephone().sendKeys("27856846586359q2");
        Thread.sleep(2000);

        addReportIdentificationInformation.parentNameField().sendKeys("The Schwarzeneggers");
        Thread.sleep(2000);

        addReportIdentificationInformation.parentAddressField().sendKeys("");
        Thread.sleep(2000);
        addReportIdentificationInformation.parentCityField().sendKeys("");
        Thread.sleep(2000);

        addReportIdentificationInformation.parentDropList("Utah").click();
        Thread.sleep(2000);

        addReportIdentificationInformation.parentZipField().sendKeys("12345");
        Thread.sleep(2000);

        addReportIdentificationInformation.parentTelephoneField().sendKeys("9152209900");
        Thread.sleep(2000);

        addReportIdentificationInformation.employerNameField().sendKeys("smth");
        Thread.sleep(2000);

        addReportIdentificationInformation.employerAddressField().sendKeys("");
        Thread.sleep(2000);

        addReportIdentificationInformation.employerCityField().sendKeys("");
        Thread.sleep(2000);

        addReportIdentificationInformation.employerStateDropList("Guam").click();
        Thread.sleep(2000);

        addReportIdentificationInformation.employerZipField().sendKeys("99556");
        Thread.sleep(2000);

        addReportIdentificationInformation.employerTelephoneField().sendKeys("1239995637!&*(&");

        //Next Button
        addReportIdentificationInformation.nextButton().click();
        Thread.sleep(4000);

        //Navigate
        addReportNavigation.identificationInformationTab().click();
        Thread.sleep(4000);

        //Previous Button
        addReportIdentificationInformation.previousButton().click();
        Thread.sleep(4000);

        // Navigate
        addReportNavigation.identificationInformationTab().click();
        Thread.sleep(4000);


    }



    @AfterClass
    public void breakDown () throws InterruptedException {

        Thread.sleep(10000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}


