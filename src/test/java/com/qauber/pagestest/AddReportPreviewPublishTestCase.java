package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.ReportValueObject;
import com.qauber.pagesresource.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/19/2016.
 */

//creating report using required fields

public class AddReportPreviewPublishTestCase extends PageObjectModelResources {

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

        ReportValueObject reportVO = new ReportValueObject();
        String firstLastName = reportVO.getFirstName()+" "+reportVO.getLastName();

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);

        getNavBar().addReportButton().click();
        Thread.sleep(1000);

        getAddReportOrganization().clickOrganization1();
        Thread.sleep(1000);

        getAddReportNavigation().subjectInformationTab().click();
        Thread.sleep(1000);
        getAddReportSubjectInformationPage().firstName().sendKeys(reportVO.getFirstName());
        getAddReportSubjectInformationPage().lastName().sendKeys(reportVO.getLastName());
        Thread.sleep(1000);

        getAddReportNavigation().environmentTab().click();
        Thread.sleep(1000);
        getAddReportEnvironment().stopLocationField().sendKeys(reportVO.getStopLocation());
        Thread.sleep(1000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-1000)", "");

        getAddReportNavigation().previewTab().click();
        Thread.sleep(1000);

        Assert.assertEquals(getAddReportPreview().suspectName().getText(),firstLastName);
        Assert.assertEquals(getAddReportPreview().stopLocation().getText(), reportVO.getStopLocation());

        String reportIdValue = getAddReportPreview().reportIdElement().getText();

        //caseID
        getAddReportPreview().editPencilIcon().click();
        Thread.sleep(1000);
        getAddReportPreview().caseIDField().sendKeys(reportVO.getCaseID());
        Thread.sleep(1000);
        getAddReportPreview().cancelCaseIDButton().click();
        Thread.sleep(1000);
        getAddReportPreview().editPencilIcon().click();
        Thread.sleep(1000);
        getAddReportPreview().caseIDField().sendKeys(reportVO.getCaseID());
        Thread.sleep(1000);
        getAddReportPreview().saveCaseIDButton().click();
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
        Thread.sleep(1000);

        Assert.assertTrue(verifyReportPublished(reportIdValue));
    }

    public boolean verifyReportPublished(String reportNumber) throws InterruptedException {
        //from Reports page...
        //search for reports which contain text (reportNumber)
        getReports().containsTextField().sendKeys(reportNumber);
        Thread.sleep(3000);
        System.out.println(getReports().searchReportResultID(1).getText());
        return getReports().searchReportResultID(1).getText().contains(reportNumber);
    }

    @AfterClass
    public void breakDown () throws InterruptedException {
        Thread.sleep(15000);
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
