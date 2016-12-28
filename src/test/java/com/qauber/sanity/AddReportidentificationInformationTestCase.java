
package com.qauber.sanity;

        import com.github.javafaker.Faker;
        import com.qauber.config.Config;
        import com.qauber.pages.*;
        import com.qauber.pagesresource.PageObjectModelResources;
        import com.qauber.pagesresource.User;
        import javafx.scene.control.CheckBox;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

        import java.util.Random;
        import java.util.concurrent.TimeUnit;

/**
 * Created by lenochka on 15.12.2016.
 */
public class AddReportidentificationInformationTestCase extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
        public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
    }

    @Test

        public void aaReportidentificationInformation() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(Config.getBaseURL());

        Faker faker = new Faker();

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(3000);

        //Go to 'Reports'
        getNavBar().addReportButton().click();

        //Select first organization
        Thread.sleep(1000);
        getAddReportOrganization().clickOrganization1();
        Thread.sleep(1000);


        // select sidentification information tab
        getAddReportNavigation().identificationInformationTab().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().primaryLanguageField().sendKeys("Esperanto");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().streetAddressField().sendKeys(faker.address().streetAddress());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().cityField().sendKeys(faker.address().city());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().country().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().stateField().sendKeys(faker.address().state());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().zipField().sendKeys(faker.address().zipCode());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().phoneField().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().emailField().sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().ssnField().sendKeys(faker.idNumber().ssnValid());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().occupationField().sendKeys("plumber");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().driverLicenseField().sendKeys("AGHH866");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().driverlicenseDropList().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().otherIDField().sendKeys(faker.idNumber().valid());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().otherIDCountryDropDown().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().otherIDState().sendKeys(faker.address().state());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().otherIDType().sendKeys("card");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolNameField().sendKeys("Cool School");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolAddress().sendKeys(faker.address().streetAddress());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolCity().sendKeys(faker.address().city());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolStateDropList().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolZip().sendKeys(faker.address().zipCode());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolTelephone().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentNameField().sendKeys("The Glossners");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentAddressField().sendKeys(faker.address().streetAddress());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentCityField().sendKeys(faker.address().city());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentDropList().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentZipField().sendKeys(faker.address().zipCode());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentTelephoneField().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerNameField().sendKeys(faker.name().username());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerAddressField().sendKeys(faker.address().streetAddress());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerCityField().sendKeys(faker.address().city());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerStateDropList().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerZipField().sendKeys(faker.address().zipCode());
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerTelephoneField().sendKeys(faker.phoneNumber().cellPhone());

        getAddReportIdentificationInformation().nextButton().click();
        Thread.sleep(2000);

        getAddReportNavigation().identificationInformationTab().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().previousButton().click();
        Thread.sleep(2000);

        getAddReportNavigation().identificationInformationTab().click();
        Thread.sleep(2000);
    }

    @AfterClass
         public void breakDown () throws InterruptedException{

        Thread.sleep(10000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }
    }