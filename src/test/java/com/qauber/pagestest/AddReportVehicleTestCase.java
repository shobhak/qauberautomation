package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by erikfriedlander on 12/19/16.
 */
public class AddReportVehicleTestCase extends PageObjectModelResources {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
    }

    @Test
    public void simpleSampleTestCase() throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);

        getNavBar().addReportButton().click();
        Thread.sleep(5000);

        getAddReportOrganization().clickOrganization1();
        Thread.sleep(5000);

        getAddReportNavigation().vehicleTab().click();
        Thread.sleep(5000);

        getAddReportVehicle().pedestrianButton().click();
        Thread.sleep(5000);

        getAddReportVehicle().passengerButton().click();
        Thread.sleep(5000);

        getAddReportVehicle().passengerVehicleLicenseField().click();
        getAddReportVehicle().passengerVehicleLicenseField().sendKeys("ABCD");

        getAddReportVehicle().passengerVehicleMakeField().click();
        getAddReportVehicle().passengerVehicleMakeField().sendKeys("FDSA");

        getAddReportVehicle().passengerVehicleModelField().click();
        getAddReportVehicle().passengerVehicleModelField().sendKeys("Ford 000");

        getAddReportVehicle().passengerVehicleBodyStyleField().click();
        getAddReportVehicle().passengerVehicleBodyStyleField().sendKeys("CABRIO");

        getAddReportVehicle().passengerVehicleColorField().click();
        getAddReportVehicle().passengerVehicleColorField().sendKeys("YELLO");

        getAddReportVehicle().passengerVehicleYearField().click();
        getAddReportVehicle().passengerVehicleYearField().sendKeys("2005");

        getAddReportVehicle().passengerVehicleOdditiesField().click();
        getAddReportVehicle().passengerVehicleOdditiesField().sendKeys("Just do it");

        getAddReportVehicle().driverButton().click();
        Thread.sleep(5000);

        getAddReportVehicle().driverVehicleLicenseField().click();
        getAddReportVehicle().driverVehicleLicenseField().sendKeys("ABCD0123");

        getAddReportVehicle().driverVehicleMakeField().click();
        getAddReportVehicle().driverVehicleMakeField().sendKeys("QWERTY");

        getAddReportVehicle().driverVehicleModelField().click();
        getAddReportVehicle().driverVehicleModelField().sendKeys("ASDFG");

        getAddReportVehicle().driverVehicleBodyStyleField().click();
        getAddReportVehicle().driverVehicleBodyStyleField().sendKeys("SEDAN");

        getAddReportVehicle().driverVehicleColorField().click();
        getAddReportVehicle().driverVehicleColorField().sendKeys("RED");

        getAddReportVehicle().driverVehicleYearField().click();
        getAddReportVehicle().driverVehicleYearField().sendKeys("1999");

        getAddReportVehicle().driverVehicleOdditiesField().click();
        getAddReportVehicle().driverVehicleOdditiesField().sendKeys("BLA BLA BLA");



        getAddReportVehicle().pedestrianNextButton().click();
        Thread.sleep(5000);

        getAddReportPhoto().previousButton().click();
        Thread.sleep(5000);

        getAddReportVehicle().pedestrianPreviousButton().click();
        Thread.sleep(5000);


    }

    @AfterClass
    public void breakDown() throws InterruptedException {
        Thread.sleep(5000);
        breakDownHelper(driver);
    }
}
