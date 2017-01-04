package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Maksim on 12/26/2016.
 */
public class SearchReportsByCreatedDate extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;
    String startMonth = "December";
    String startDay = "26";
    String startYear = "2016";
    String keyWord = "Today";

    @BeforeClass
    public void setUp() throws InterruptedException {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);

        testConfig().getTestRail().setCaseID(0000);
        testConfig().getTestRail().setTester("Max's Computer");

        sleepTime = testConfig().getSleepTime();
        setUpScript();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
    }

    @Test
    public void searchReportsByCreatedDate() throws InterruptedException
    {
        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime*2);

        getReports().publishedOnCheckBox().click();
        getReports().createdDateFromIcon(startMonth, startDay, startYear);
        getReports().createdDateToIcon(keyWord);
        Thread.sleep(sleepTime*2);
    }

    @AfterClass
    public void breakDown()
    {
        breakDownHelper();
    }
}

