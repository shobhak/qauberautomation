package com.qauber.pagestest;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by jingx on 12/16/2016.
 */
public class AddReportISubjectInformationTest {
    WebDriver driver;
    
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void addSubjectInformationData() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(Config.getBaseURL());
        LoginPage login = new LoginPage(driver);
        NavBar navBar = new NavBar(driver);
        AddReportNavigation addReportNavigation = new AddReportNavigation(driver);
        AddReportsOrganization addReportsOrganization = new AddReportsOrganization(driver);
        AddReportSubjectInformationPage addReportSubjectInformation = new AddReportSubjectInformationPage(driver);

        Faker faker = new Faker();
        Random randomInt = new Random();
        Random randomDouble = new Random();

        Thread.sleep(5000);
        login.loginToWave("jing_qauber_001@mailinator.com", "Portnov1");

        Thread.sleep(3000);

        //Go to 'Reports'
        navBar.addReportButton().click();


        //Select first organization
        Thread.sleep(1000);
        addReportsOrganization.clickOrganization1();
        Thread.sleep(1000);


        // select subject information tab
        addReportNavigation.subjectInformationTab().click();
        Thread.sleep(2000);

        // click previous button
        addReportSubjectInformation.previouButton().click();
        Thread.sleep(2000);
        addReportNavigation.subjectInformationTab().click();
        Thread.sleep(2000);

        // click next button
        addReportSubjectInformation.nextButton().click();
        Thread.sleep(2000);
        addReportNavigation.subjectInformationTab().click();
        Thread.sleep(2000);

        // enter data for first name
        addReportSubjectInformation.firstName().sendKeys(faker.name().firstName());
        Thread.sleep(1000);

        // enter data for middle name
        addReportSubjectInformation.middleName().sendKeys(faker.name().lastName());
        Thread.sleep(1000);

        // enter data for last name
        addReportSubjectInformation.lastName().sendKeys(faker.name().lastName());
        Thread.sleep(1000);

        // enter data for suspect type
        addReportSubjectInformation.subjectType().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.subjectType()).selectByIndex(randomInt.nextInt(5));
        Thread.sleep(1000);

        // enter data for date of birth
        addReportSubjectInformation.dateOfBirth().click();
        Thread.sleep(1000);
        String dateofbirth = "" + randomInt.nextInt(12) + randomInt.nextInt(28) + (1900 + randomInt.nextInt(117));
        addReportSubjectInformation.dateOfBirth().sendKeys(dateofbirth);
        Thread.sleep(1000);

//        // enter data for date of birth from calendar icon
//        addReportSubjectInformation.dateOfBirthCalendarIcon().click();
//        for (int i = 0; i <= randomInt.nextInt(4); i++){
//            driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[2]/div[1]/div/div/p/div/ul/li/div/div/div/table/thead/tr/th[1]/button")).click();
//            Thread.sleep(2000);
//        }
//        String yearXPath = "//form/div/div[3]/fieldset/div[2]/div[1]/div/div/p/div/ul/li/div/div/div/table/tbody/tr[" + (randomInt.nextInt(3) + 1) + "]/td[" + (randomInt.nextInt(4) + 1) + "]/button";
//        driver.findElement(By.xpath(yearXPath)).click();
//        Thread.sleep(2000);
//        String monthXPath = "//form/div/div[3]/fieldset/div[2]/div[1]/div/div/p/div/ul/li/div/div/div/table/tbody/tr[" + (randomInt.nextInt(3) + 1) + "]/td[" + (randomInt.nextInt(3) + 1) + "]/button";
//        driver.findElement(By.xpath(monthXPath)).click();
//        Thread.sleep(2000);
//        String dayXPath = "//form/div/div[3]/fieldset/div[2]/div[1]/div/div/p/div/ul/li/div/div/div/table/tbody/tr[" + (randomInt.nextInt(5) + 1) + "]/td[" + (randomInt.nextInt(6) + 1) + "]/button";
//        driver.findElement(By.xpath(dayXPath)).click();
//        Thread.sleep(2000);
//




        // enter data for nickname
        addReportSubjectInformation.nickName().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for race
        addReportSubjectInformation.race().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.race()).selectByIndex(randomInt.nextInt(19));
        Thread.sleep(1000);

        // enter data for height
        double height1 = 1.00 + randomDouble.nextDouble()*7.00;
        addReportSubjectInformation.height().sendKeys(Double.toString(height1));
        Thread.sleep(1000);

        // enter data for weight
        double weight1 = 10.0 + randomDouble.nextDouble()*200.0;
        addReportSubjectInformation.weight().sendKeys(Double.toString(weight1));
        Thread.sleep(1000);

        // enter data for hair color
        addReportSubjectInformation.hairColor().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.hairColor()).selectByIndex(randomInt.nextInt(14));
        Thread.sleep(1000);

        // enter data for hair length
        addReportSubjectInformation.hairLength().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.hairLength()).selectByIndex(randomInt.nextInt(6));
        Thread.sleep(1000);

        // enter data for hair style
        addReportSubjectInformation.hairStyle().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.hairStyle()).selectByIndex(randomInt.nextInt(22));
        Thread.sleep(1000);

        // enter data for sex
        addReportSubjectInformation.sex().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.sex()).selectByIndex(randomInt.nextInt(3));
        Thread.sleep(1000);

        // enter data for build
        addReportSubjectInformation.build().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.build()).selectByIndex(randomInt.nextInt(9));
        Thread.sleep(1000);

        // enter data for eye color
        addReportSubjectInformation.eyeColor().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.eyeColor()).selectByIndex(randomInt.nextInt(8));
        Thread.sleep(1000);

        // enter data for complexion
        addReportSubjectInformation.complexion().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.complexion()).selectByIndex(randomInt.nextInt(5));
        Thread.sleep(1000);

        // enter data for teeth
        addReportSubjectInformation.teeth().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.teeth()).selectByIndex(randomInt.nextInt(4));
        Thread.sleep(1000);

        // enter data for hand preference
        addReportSubjectInformation.handPreference().click();
        Thread.sleep(1000);
        new Select(addReportSubjectInformation.handPreference()).selectByIndex(randomInt.nextInt(4));
        Thread.sleep(1000);


























    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(20000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }




}
