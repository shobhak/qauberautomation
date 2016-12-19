package com.qauber.pagestest;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.ConfigOOP;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by erikfriedlander on 12/16/16.
 */
public class ConfigOOPDemo extends PageObjectModelResources {

    ConfigOOP config;

    @Test
    public void showConfigOOPDemo() throws InterruptedException {

        getDriver().get(config.getBaseURL());
        Thread.sleep(3000);

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());

        getNavBar().addReportButton().click();

        getAddReportOrganization().clickOrganization1();
        getAddReportOrganization().clickNextButton();

        Thread.sleep(1000);

        getAddReportSubjectInformationPage().firstName().sendKeys("Erik");
        getAddReportSubjectInformationPage().lastName().sendKeys("Friedlander");

        Assert.assertEquals(getAddReportSubjectInformationPage().firstName().getAttribute("value"), "Erik");

    }

    @BeforeClass
    public void setUp() {
        config = new ConfigOOP();
        config.setBrowserType(ConfigOOP.BrowserType.CHROME);
        setUpWithConfig(config);

//        getTestCaseUser().setUsername("firstName@mailinator.com");
//        getTestCaseUser().setPassword("12345678");

        System.out.println(getTestCaseUser().getUsername());
        System.out.println(getTestCaseUser().getPassword());
    }

    @AfterClass
    public void breakDown() throws InterruptedException {
        Thread.sleep(60000);
        breakDownHelper();
        System.out.println("BREAK IT DOWN");
    }
}
