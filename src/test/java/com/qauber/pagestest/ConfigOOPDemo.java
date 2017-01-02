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

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());

        getNavBar().addReportButton().click();

        getAddReportOrganization().clickOrganization1();
        getAddReportOrganization().nextButton().click();

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

//        testUser().setUsername("firstName@mailinator.com");
//        testUser().setPassword("12345678");

        System.out.println(testUser().getUsername());
        System.out.println(testUser().getPassword());
    }

    @AfterClass
    public void breakDown() throws InterruptedException {
        Thread.sleep(60000);
        breakDownHelper();
        System.out.println("BREAK IT DOWN");
    }
}
