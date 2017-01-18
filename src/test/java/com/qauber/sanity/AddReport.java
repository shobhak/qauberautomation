package com.qauber.sanity;

import com.qauber.assertutil.AssertUber;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.ReportValueObject;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.openqa.selenium.JavascriptExecutor;
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

        //from AddReport: Subject Information
        String lastFirstName = reportVO.getLastName()+" "+reportVO.getFirstName();

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().addReportButton().click();
        Thread.sleep(sleepTime/4);

        getAddReportOrganization().clickOrganization1();
        Thread.sleep(sleepTime/4);

        getAddReportNavigation().subjectInformationTab().click();
        Thread.sleep(sleepTime/4);
        getAddReportSubjectInformationPage().lastName().sendKeys(reportVO.getLastName());
        getAddReportSubjectInformationPage().firstName().sendKeys(reportVO.getFirstName());
        Thread.sleep(sleepTime/4);

        getAddReportNavigation().environmentTab().click();
        Thread.sleep(sleepTime/4);
        getAddReportEnvironment().stopLocationField().sendKeys(reportVO.getStopLocation());
        Thread.sleep(sleepTime/4);

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,-1000)", "");

        getAddReportNavigation().previewTab().click();
        Thread.sleep(sleepTime/4);

        //from AddReport: Preview
        String lastNameFirstName = getAddReportPreview().lastName().getText()+" "+getAddReportPreview().firstName().getText();

        //verify info entered matches info on preview
        AssertUber.assertEquals(lastNameFirstName, lastFirstName, "Last and first names are different");
        AssertUber.assertEquals(getAddReportPreview().locationOfStop().getText(), reportVO.getStopLocation(), "StopLocation is different");

        //verify report published
        String reportIdValue = getAddReportPreview().reportIdElement().getText();

        getAddReportPreview().publishReportButton().click();
        Thread.sleep(sleepTime/4);

        AssertUber.assertTrue(verifyReportPublished(reportIdValue), "ReportID doesn't match ReportID searched");

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
