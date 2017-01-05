package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.ReportValueObject;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/19/2016.
 */

//creating report using required fields

public class AddReport extends PageObjectModelResources {

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        testConfig().getTestRail().setCaseID(80127);
        testConfig().getTestRail().setTester("Alya");
        setUpScript();
    }

    @Test
    public void addReportPreviewPublish () throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(10000);

        ReportValueObject reportVO = new ReportValueObject();
        String firstLastName = reportVO.getFirstName()+" "+reportVO.getLastName();

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
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

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,-1000)", "");

        getAddReportNavigation().previewTab().click();
        Thread.sleep(1000);

        //verify info entered matches info on preview
        Assert.assertEquals(getAddReportPreview().suspectName().getText(),firstLastName);
        Assert.assertEquals(getAddReportPreview().stopLocation().getText(), reportVO.getStopLocation());

        //verify report published
        String reportIdValue = getAddReportPreview().reportIdElement().getText();

        getAddReportPreview().publishReportButton().click();
        Thread.sleep(1000);

        try {
        Assert.assertTrue(verifyReportPublished(reportIdValue));
        } catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Report ID do not match Report ID searched "+e.getLocalizedMessage());
            throw e;
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    public boolean verifyReportPublished(String reportNumber) throws InterruptedException {
        //search for reports which contain text (reportNumber)
        getReports().containsTextField().sendKeys(reportNumber);
        Thread.sleep(3000);
        System.out.println(getReports().searchReportResultID(1).getText());
        return getReports().searchReportResultID(1).getText().contains(reportNumber);
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
