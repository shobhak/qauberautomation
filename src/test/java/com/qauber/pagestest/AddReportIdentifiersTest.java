package com.qauber.pagestest;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pages.*;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by jingx on 12/16/2016.
 */
public class AddReportIdentifiersTest extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver);
    }

    @Test
    public void addIdentifiersData() throws InterruptedException {
        driver.get(Config.getBaseURL());

        Faker faker = new Faker();

        Thread.sleep(5000);
        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);

        //Go to 'Reports'
        getNavBar().addReportButton().click();


        //Select first organization
        Thread.sleep(1000);
        getAddReportOrganization().clickOrganization1();
        Thread.sleep(1000);


        // select Identifiers tab
        getAddReportNavigation().identifiersTab().click();
        Thread.sleep(2000);

        // click previous button
        getAddReportIdentifiersPage().previousButton().click();
        Thread.sleep(2000);
        getAddReportNavigation().identifiersTab().click();
        Thread.sleep(2000);

        // click next button
        getAddReportIdentifiersPage().nextButton().click();
        Thread.sleep(2000);
        getAddReportNavigation().identifiersTab().click();
        Thread.sleep(2000);

        // enter data for tattoos
        getAddReportIdentifiersPage().tattoosCheckbox().click();
        Thread.sleep(1000);
        getAddReportIdentifiersPage().tattoosTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for scars
        getAddReportIdentifiersPage().scarsCheckbox().click();
        Thread.sleep(1000);
        getAddReportIdentifiersPage().scarsTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for needle marks
        getAddReportIdentifiersPage().needleMarksCheckbox().click();
        Thread.sleep(1000);
        getAddReportIdentifiersPage().needleMarksTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for tracks
        getAddReportIdentifiersPage().tracksCheckbox().click();
        Thread.sleep(1000);
        getAddReportIdentifiersPage().tracksTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for glasses
        getAddReportIdentifiersPage().glassesCheckbox().click();
        Thread.sleep(1000);
        getAddReportIdentifiersPage().glassesTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for mustache
        getAddReportIdentifiersPage().mustacheCheckbox().click();
        Thread.sleep(1000);
        getAddReportIdentifiersPage().mustacheTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for beard
        getAddReportIdentifiersPage().beardCheckbox().click();
        Thread.sleep(1000);
        getAddReportIdentifiersPage().beardTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);




    }


    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }


}
