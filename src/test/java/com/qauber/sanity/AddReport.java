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
 * TODO: add conditions. Idea: what if getAddReportOrganization().clickOrganization1(); fails? try { } catch { ??? }
 */

//creating report using required fields

public class AddReport extends PageObjectModelResources {
    private int sleepTime;

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        sleepTime = testConfig().getSleepTime();
        testConfig().getTestRail().setCaseID(80127);
        testConfig().getTestRail().setTester("Alya");
        setUpScript();
    }

    @Test
    public void addReportPreviewPublish () throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        ReportValueObject reportVO = new ReportValueObject();
        String firstLastName = reportVO.getFirstName()+" "+reportVO.getLastName();

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().addReportButton().click();
        Thread.sleep(sleepTime/4);

        getAddReportOrganization().clickOrganization1();
        Thread.sleep(sleepTime/4);

        getAddReportNavigation().subjectInformationTab().click();
        Thread.sleep(sleepTime/4);
        getAddReportSubjectInformationPage().firstName().sendKeys(reportVO.getFirstName());
        getAddReportSubjectInformationPage().lastName().sendKeys(reportVO.getLastName());
        Thread.sleep(sleepTime/4);

        getAddReportNavigation().environmentTab().click();
        Thread.sleep(sleepTime/4);
        getAddReportEnvironment().stopLocationField().sendKeys(reportVO.getStopLocation());
        Thread.sleep(sleepTime/4);

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,-1000)", "");

        getAddReportNavigation().previewTab().click();
        Thread.sleep(sleepTime/4);

        //verify info entered matches info on preview
        Assert.assertEquals(getAddReportPreview().suspectName().getText(),firstLastName);
        Assert.assertEquals(getAddReportPreview().stopLocation().getText(), reportVO.getStopLocation());

        //verify report published
        String reportIdValue = getAddReportPreview().reportIdElement().getText();

        getAddReportPreview().publishReportButton().click();
        Thread.sleep(sleepTime/4);

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
        Thread.sleep(sleepTime/2);
        System.out.println(getReports().searchReportResultID(1).getText());
        return getReports().searchReportResultID(1).getText().contains(reportNumber);
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
