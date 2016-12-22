
package com.qauber.pagestest;

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
    public void addSubjectInformationData() throws InterruptedException {
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

        getAddReportIdentificationInformation().streetAddressField().sendKeys("1233 Any lane");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().cityField().sendKeys("London");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().countryDropDown().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().stateField().sendKeys("hjghf");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().zipField().sendKeys("12345");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().phoneField().sendKeys("1234567890");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().emailField().sendKeys("anemail@mail.de");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().ssnField().sendKeys("123456789");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().occupationField().sendKeys("plumber");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().driverLicenseField().sendKeys("AGHH866");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().driverlicenseDropList("Connecticut").click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().otherIDField().sendKeys("67GHnsmh");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().otherIDCountryDropDown().click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().otherIDState().sendKeys("any");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().otherIDType().sendKeys("761yh");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolNameField().sendKeys("Cool School");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolAddress().sendKeys("73677 Address Avenue");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolCity().sendKeys("Gangnam");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolStateDropList("Taxas").click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolZip().sendKeys("12345");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().schoolTelephone().sendKeys("1239997755");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentNameField().sendKeys("The Glossners");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentAddressField().sendKeys("67 wggg");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentCityField().sendKeys("Freiburg");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentDropList("Utah").click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentZipField().sendKeys("56784");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().parentTelephoneField().sendKeys("9163305512");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerNameField().sendKeys("QAUBER");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerAddressField().sendKeys("2905 Stender Way");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerCityField().sendKeys("Santa Clara");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerStateDropList("Guam").click();
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerZipField().sendKeys("567890");
        Thread.sleep(2000);

        getAddReportIdentificationInformation().employerTelephoneField().sendKeys("0987654422");

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