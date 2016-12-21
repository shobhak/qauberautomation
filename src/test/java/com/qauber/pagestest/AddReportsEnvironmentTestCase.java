package com.qauber.pagestest;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
//import com.qauber.pages.*;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import java.util.concurrent.TimeUnit;

/**
 * Created by Alya on 12/15/2016.
 */
public class AddReportsEnvironmentTestCase extends PageObjectModelResources {

    /*private WebDriver driver;

    private LoginPage login;
    private AddReportsOrganization addReportsOrganization;
    private NavBar navBar;
    private AddReportNavigation addReportNavigation;
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
    }*/

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

        Faker faker = new Faker();

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);

    /*@Test
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
        Thread.sleep(3000);*/

    //Go to 'Add Report'
        getNavBar().addReportButton().click();

        //Select first organization
        Thread.sleep(1000);
        getAddReportOrganization().clickOrganization1();
        Thread.sleep(1000);

        getAddReportNavigation().environmentTab().click();
        Thread.sleep(1000);

        getAddReportEnvironment().gangNameCheckBox().click();
        Thread.sleep(1000);
        getAddReportEnvironment().gangNameField().sendKeys(faker.lorem().word());
        getAddReportEnvironment().howLongField().sendKeys(faker.number().digit());
        Thread.sleep(1000);
        getAddReportEnvironment().sexCrimesCheckBox().click();
        getAddReportEnvironment().robberyCheckBox().click();
        getAddReportEnvironment().narcoCheckbox().click();
        getAddReportEnvironment().viceIntelCheckbox().click();
        getAddReportEnvironment().selfAdmissionCheckbox().click();
        getAddReportEnvironment().frequentingGangAreaCheckbox().click();
        getAddReportEnvironment().displayingGangSignsCheckbox().click();
        getAddReportEnvironment().byReliableInformantCheckbox().click();
        getAddReportEnvironment().gangTattoosCheckbox().click();
        getAddReportEnvironment().gangClothingCheckbox().click();
        getAddReportEnvironment().affiliatingWithGangMembersCheckbox().click();
        getAddReportEnvironment().participatingInGangCrimeCheckbox().click();
        getAddReportEnvironment().gangRegistrantCheckbox().click();
        getAddReportEnvironment().otherInformationField().sendKeys(faker.lorem().word());
        getAddReportEnvironment().onProbationCheckbox().click();
        Thread.sleep(1000);
        getAddReportEnvironment().probationOfficerField().sendKeys(faker.name().name());
        getAddReportEnvironment().probationOfficerPhoneField().sendKeys(faker.phoneNumber().cellPhone());
        getAddReportEnvironment().onParoleCheckbox().click();
        Thread.sleep(1000);
        getAddReportEnvironment().paroleOfficerField().sendKeys(faker.name().name());
        getAddReportEnvironment().paroleOfficerPhoneField().sendKeys(faker.phoneNumber().cellPhone());
        getAddReportEnvironment().beatField().sendKeys(faker.lorem().word());
        getAddReportEnvironment().officerNameField().sendKeys(faker.name().name());
        getAddReportEnvironment().officerIdField().sendKeys(faker.idNumber().valid());
        getAddReportEnvironment().stopLocationField().sendKeys(faker.address().city());
        getAddReportEnvironment().previousButton().click();
        Thread.sleep(1000);
        getAddReportNavigation().environmentTab().click();
        Thread.sleep(1000);
        getAddReportEnvironment().nextButton().click();
        Thread.sleep(1000);
        getAddReportNavigation().environmentTab().click();
    }

    @AfterClass
    public void breakDown () throws InterruptedException {
        Thread.sleep(60000);
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}



