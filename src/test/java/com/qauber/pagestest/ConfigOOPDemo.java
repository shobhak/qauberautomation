package com.qauber.pagestest;

import com.qauber.pagesresource.ConfigOOP;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by erikfriedlander on 12/16/16.
 * Working as of 1/1/17.
 */
public class ConfigOOPDemo extends PageObjectModelResources {

    private int sleepTime;

    @Test
    public void showConfigOOPDemo() throws InterruptedException {

        testDriver().get(testConfig().getBaseURL());

        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());

        getNavBar().addReportButton().click();

        getAddReportOrganization().clickOrganization1();
        getAddReportOrganization().nextButton().click();

        Thread.sleep(sleepTime/2);

        getAddReportSubjectInformationPage().firstName().sendKeys("FirstName");
        getAddReportSubjectInformationPage().lastName().sendKeys("LastName");

        Assert.assertEquals(getAddReportSubjectInformationPage().firstName().getAttribute("value"), "FirstName");

    }

    @BeforeClass
    public void setUp() {
        testConfig().setBrowserType(ConfigOOP.BrowserType.FIREFOX); //Set browser (ONLY USE FOR TESTS THAT ARE FOR A SPECIFIC BROWSER ONLY)
        setUpUser(User.UserType.SAU); //Choose user
        sleepTime = testConfig().getSleepTime();
        setUpScript(); //
    }

    @AfterClass
    public void breakDown() throws InterruptedException {
        Thread.sleep(60000);
        breakDownHelper();
        System.out.println("BREAK IT DOWN");
    }
}
