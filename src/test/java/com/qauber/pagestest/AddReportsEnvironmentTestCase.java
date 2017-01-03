package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.ReportValueObject;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/15/2016.
 */
public class AddReportsEnvironmentTestCase extends PageObjectModelResources {

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

        ReportValueObject reportVO = new ReportValueObject();

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);

        getNavBar().addReportButton().click();

        Thread.sleep(1000);
        getAddReportOrganization().clickOrganization1();
        Thread.sleep(1000);

        getAddReportNavigation().environmentTab().click();
        Thread.sleep(1000);

        getAddReportEnvironment().gangNameCheckBox().click();
        Thread.sleep(1000);

        getAddReportEnvironment().gangNameField().sendKeys(reportVO.getGangName());
        getAddReportEnvironment().howLongField().sendKeys(reportVO.getHowLong());
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
        getAddReportEnvironment().onProbationCheckbox().click();
        Thread.sleep(1000);
        getAddReportEnvironment().probationOfficerField().sendKeys(reportVO.getProbationOfficer());
        getAddReportEnvironment().probationOfficerPhoneField().sendKeys(reportVO.getProbationOfficerPhone());
        getAddReportEnvironment().onParoleCheckbox().click();
        Thread.sleep(1000);
        getAddReportEnvironment().paroleOfficerField().sendKeys(reportVO.getParoleOfficer());
        getAddReportEnvironment().paroleOfficerPhoneField().sendKeys(reportVO.getParoleOfficerPhone());
        getAddReportEnvironment().beatField().sendKeys(reportVO.getBeat());
        getAddReportEnvironment().officerNameField().sendKeys(reportVO.getOfficerName());
        getAddReportEnvironment().officerIdField().sendKeys(reportVO.getOfficerId());
        getAddReportEnvironment().reasonForStopField().sendKeys(reportVO.getReasonForStop());
        getAddReportEnvironment().stopLocationField().sendKeys(reportVO.getStopLocation());
        getAddReportEnvironment().dispositionField().sendKeys(reportVO.getDisposition());
        getAddReportEnvironment().otherInformationCommentsFieldArea().sendKeys(reportVO.getOtherInformationComments());
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



