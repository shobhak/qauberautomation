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
 * Created by Alya on 12/15/2016.
 */
public class AddReportsEnvironmentTestCase {

    private WebDriver driver;

    private LoginPage login;
    private AddReportsOrganization addReportsOrganization;
    private NavBar navBar;
    private AddReportNavigation addReportNavigation;
    private AddReportEnvironment addReportEnvironment;

    //LoginPage login;
    //AddReportsOrganization addReportsOrganization;
    //NavBar navBar;
    //AddReportNavigation addReportNavigation;
    //AddReportEnvironment addReportEnvironment;

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
    public void addReportEnvironment () throws InterruptedException {

        //Create all Page Objects
        login = new LoginPage(driver);
        navBar = new NavBar(driver);
        addReportsOrganization = new AddReportsOrganization(driver);
        addReportNavigation = new AddReportNavigation(driver);
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

        addReportNavigation.environmentTab().click();
        Thread.sleep(1000);

        addReportEnvironment.gangNameCheckBox().click();
        Thread.sleep(1000);
        addReportEnvironment.gangNameField().sendKeys("A");
        addReportEnvironment.howLongField().sendKeys("B");
        Thread.sleep(1000);
        addReportEnvironment.sexCrimesCheckBox().click();
        addReportEnvironment.robberyCheckBox().click();
        addReportEnvironment.narcoCheckbox().click();
        addReportEnvironment.viceIntelCheckbox().click();
        addReportEnvironment.selfAdmissionCheckbox().click();
        addReportEnvironment.frequentingGangAreaCheckbox().click();
        addReportEnvironment.displayingGangSignsCheckbox().click();
        addReportEnvironment.byReliableInformantCheckbox().click();
        addReportEnvironment.gangTattoosCheckbox().click();
        addReportEnvironment.gangClothingCheckbox().click();
        addReportEnvironment.affiliatingWithGangMembersCheckbox().click();
        addReportEnvironment.participatingInGangCrimeCheckbox().click();
        addReportEnvironment.gangRegistrantCheckbox().click();
        addReportEnvironment.otherInformationField().sendKeys("C");
        addReportEnvironment.onProbationCheckbox().click();
        Thread.sleep(1000);
        addReportEnvironment.probationOfficerField().sendKeys("D");
        addReportEnvironment.probationOfficerPhoneField().sendKeys("6504741283");
        addReportEnvironment.onParoleCheckbox().click();
        Thread.sleep(1000);
        addReportEnvironment.paroleOfficerField().sendKeys("E");
        addReportEnvironment.paroleOfficerPhoneField().sendKeys("6504741284");
        addReportEnvironment.beatField().sendKeys("F");
        addReportEnvironment.officerNameField().sendKeys("G");
        addReportEnvironment.officerIdField().sendKeys("4");
        addReportEnvironment.stopLocationField().sendKeys("H");
        addReportEnvironment.previousButton().click();
        Thread.sleep(1000);
        addReportNavigation.environmentTab().click();
        Thread.sleep(1000);
        addReportEnvironment.nextButton().click();
        Thread.sleep(1000);
        addReportNavigation.environmentTab().click();
    }

    @AfterClass
    public void breakDown () throws InterruptedException {

        Thread.sleep(60000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }
}



