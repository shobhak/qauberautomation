package com.qauber.pagesresource.preconditions;

import com.github.javafaker.Faker;
import com.qauber.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    private AddReportsOrganization addReportsOrganization;
    private AddReportNavigation addReportNavigation;
    private AddReportSubjectInformationPage addReportSubjectInformationPage;
    private AddReportEnvironment addReportEnvironment;
    private AddReportPreview addReportPreview;

    public ReportPreconditions(WebDriver driver)
    {
        sleepTime = 1000;
        this.driver = driver;
        faker = new Faker();
        navBar = new NavBar(driver);
        reports = new Reports(driver);
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
        try {
            reports.pagination("1").click();
        }
        catch (Exception e)
        {}
        ((JavascriptExecutor)driver).executeScript("scroll(0,-100)");
    }

    /** verifyReportsAtLeast(int num)
     * count reports, decrementing numberRemaining
     * if numberRemaining <= 0, return 0
     * if out of reports to count, return numberRemaining
     */
    public int verifyReportsAtLeast(int num) throws InterruptedException
    {
        try
        {
            reports.pagination("1").isDisplayed();
            Thread.sleep(sleepTime);
            int numberRemaining = 0;
            int i = 1;
            while(true)
            {
                Thread.sleep(sleepTime);
                ArrayList<WebElement> list1 = new ArrayList<WebElement>(reports.reportsRows());
                numberRemaining = numberRemaining + list1.size();
                ArrayList<WebElement> list2 = new ArrayList<WebElement>(reports.paginationSum());

                if (numberRemaining>=num)
                    break;

                if(i<Integer.parseInt(list2.get(list2.size()-1).getText()))
                {
                    reports.pagination(i+1+"").click();
                    i++;
                }
                else
                {
                    break;
                }
            }
            numberRemaining = num - numberRemaining;
            return numberRemaining <=0 ? 0 : numberRemaining;
        }
        catch (NoSuchElementException e){
            ArrayList<WebElement> list = new ArrayList<WebElement>(reports.reportsRows());

            int numberRemaining = num - list.size();
            return numberRemaining <=0 ? 0 : numberRemaining;
        }

    }

    /**
     *
     * Create reports fill out only required fields,
     * based on numberOfReportsNeeded.
     */

    public void createReport(int numberOfReportsNeeded) throws InterruptedException {

        for (int i = 0; i<numberOfReportsNeeded; i++) {
            navBar.addReportButton().click();
            Thread.sleep(sleepTime);

            addReportsOrganization.clickOrganization1();
            Thread.sleep(sleepTime);

            addReportNavigation.subjectInformationTab().click();
            Thread.sleep(sleepTime);

            addReportSubjectInformationPage.firstName().sendKeys(faker.name().firstName());
            addReportSubjectInformationPage.lastName().sendKeys(faker.name().lastName());
            addReportSubjectInformationPage.caseIdField().sendKeys(faker.idNumber().valid());
            new Select(addReportSubjectInformationPage.subjectType()).selectByIndex(faker.number().numberBetween(1,5));
            Thread.sleep(sleepTime);

            addReportNavigation.environmentTab().click();
            Thread.sleep(sleepTime);
            addReportEnvironment.stopLocationField().sendKeys(faker.address().cityName());
            Thread.sleep(sleepTime);

            //scroll to top before clicking, for low resolution computers
            ((JavascriptExecutor)driver).executeScript("scroll(0,-100)");
            Thread.sleep(sleepTime/5);
            addReportNavigation.previewTab().click();
            Thread.sleep(sleepTime);

            addReportPreview.publishReportButton().click();
            Thread.sleep(sleepTime);
        }
    }
}

