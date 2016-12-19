package com.qauber.pagestest;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by jingx on 12/16/2016.
 */
public class AddReportIdentifiersTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void addIdentifiersData() throws InterruptedException {
        driver.get(Config.getBaseURL());
        LoginPage login = new LoginPage(driver);
        NavBar navBar = new NavBar(driver);
        AddReportNavigation addReportNavigation = new AddReportNavigation(driver);
        AddReportsOrganization addReportsOrganization = new AddReportsOrganization(driver);
        AddReportIdentifiersPage addReportIdentifiersPage = new AddReportIdentifiersPage(driver);

        Faker faker = new Faker();

        Thread.sleep(5000);
        login.loginToWave("jing_qauber_001@mailinator.com", "Portnov1");

        Thread.sleep(3000);

        //Go to 'Reports'
        navBar.addReportButton().click();


        //Select first organization
        Thread.sleep(1000);
        addReportsOrganization.clickOrganization1();
        Thread.sleep(1000);


        // select Identifiers tab
        addReportNavigation.identifiersTab().click();
        Thread.sleep(2000);

        // click previous button
        addReportIdentifiersPage.previousButton().click();
        Thread.sleep(2000);
        addReportNavigation.identifiersTab().click();
        Thread.sleep(2000);

        // click next button
        addReportIdentifiersPage.nextButton().click();
        Thread.sleep(2000);
        addReportNavigation.identifiersTab().click();
        Thread.sleep(2000);

        // enter data for tattoos
        addReportIdentifiersPage.tattoosCheckbox().click();
        Thread.sleep(1000);
        addReportIdentifiersPage.tattoosTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for scars
        addReportIdentifiersPage.scarsCheckbox().click();
        Thread.sleep(1000);
        addReportIdentifiersPage.scarsTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for needle marks
        addReportIdentifiersPage.needleMarksCheckbox().click();
        Thread.sleep(1000);
        addReportIdentifiersPage.needleMarksTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for tracks
        addReportIdentifiersPage.tracksCheckbox().click();
        Thread.sleep(1000);
        addReportIdentifiersPage.tracksTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for glasses
        addReportIdentifiersPage.glassesCheckbox().click();
        Thread.sleep(1000);
        addReportIdentifiersPage.glassesTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for mustache
        addReportIdentifiersPage.mustacheCheckbox().click();
        Thread.sleep(1000);
        addReportIdentifiersPage.mustacheTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for beard
        addReportIdentifiersPage.beardCheckbox().click();
        Thread.sleep(1000);
        addReportIdentifiersPage.beardTextField().sendKeys(faker.lorem().word());
        Thread.sleep(1000);




    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(20000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }




}
