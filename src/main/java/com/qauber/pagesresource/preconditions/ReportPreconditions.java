package com.qauber.pagesresource.preconditions;

import com.github.javafaker.Faker;
import com.qauber.pages.*;
import com.qauber.pagesresource.ReportValueObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by MadMax on 1/4/2017.
 */
public class ReportPreconditions {
    private int sleepTime;

    private WebDriver driver;
    private Faker faker;
    private NavBar navBar;
    private Reports reports;
    private ReportValueObject reportVO;
    private AddReportsOrganization addReportsOrganization;
    private AddReportNavigation addReportNavigation;
    private AddReportSubjectInformationPage addReportSubjectInformationPage;
    private AddReportEnvironment addReportEnvironment;
    private AddReportPreview addReportPreview;

    public ReportPreconditions(WebDriver driver)
    {
        sleepTime = 5000;
        this.driver = driver;
        faker = new Faker();
        navBar = new NavBar(driver);
        reports = new Reports(driver);
        reportVO = new ReportValueObject();
        addReportsOrganization = new AddReportsOrganization(driver);
        addReportNavigation = new AddReportNavigation(driver);
        addReportSubjectInformationPage = new AddReportSubjectInformationPage(driver);
        addReportEnvironment = new AddReportEnvironment(driver);
        addReportPreview = new AddReportPreview(driver);
    }

    /**
     * ensureReportsAtLeast(int num)
     * Get 'number of pages we need to create'
     * If numberOfReportsNeeded > 0, create those users
     */
    public void ensureReportsAtLeast(int num) throws InterruptedException
    {
        int numberOfReportsNeeded = verifyReportsAtLeast(num);
        System.out.println("Number of reports we need to create: " + numberOfReportsNeeded);
        if (numberOfReportsNeeded > 0) {
            createReport(numberOfReportsNeeded);
        }
    }

    public int verifyReportsAtLeast(int num) throws InterruptedException
    {
        if (reports.activePagination().isDisplayed())
            reports.pagination("last");
        ArrayList<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.cssSelector(".btn.btn-info.btn-sm.ng-scope")));

        return num - (Integer.parseInt(reports.activePagination().getText()) - 1)*10 + list.size();
    }
    public void createReport(int reportsNeeded) throws InterruptedException {

        for (int i = 0; i<reportsNeeded; i++) {
            navBar.addReportButton().click();
            Thread.sleep(1000);

            addReportsOrganization.clickOrganization1();
            Thread.sleep(1000);

            addReportNavigation.subjectInformationTab().click();
            Thread.sleep(1000);
            addReportSubjectInformationPage.firstName().sendKeys(reportVO.getFirstName());
            addReportSubjectInformationPage.lastName().sendKeys(reportVO.getLastName());
            Thread.sleep(1000);

            addReportNavigation.environmentTab().click();
            Thread.sleep(1000);
            addReportEnvironment.stopLocationField().sendKeys(reportVO.getStopLocation());
            Thread.sleep(1000);

            addReportNavigation.previewTab().click();
            Thread.sleep(1000);

            addReportPreview.publishReportButton().click();
            Thread.sleep(1000);
        }
    }
}

