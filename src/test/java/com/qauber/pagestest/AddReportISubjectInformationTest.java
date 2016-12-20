package com.qauber.pagestest;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pages.*;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
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
public class AddReportISubjectInformationTest extends PageObjectModelResources {
    WebDriver driver;
    
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver);
    }

    @Test
    public void addSubjectInformationData() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(Config.getBaseURL());

        Faker faker = new Faker();
        Random randomInt = new Random();
        Random randomDouble = new Random();

        Thread.sleep(8000);
        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(3000);

        //Go to 'Reports'
        getNavBar().addReportButton().click();


        //Select first organization
        Thread.sleep(1000);
        getAddReportOrganization().clickOrganization1();
        Thread.sleep(1000);


        // select subject information tab
        getAddReportNavigation().subjectInformationTab().click();
        Thread.sleep(2000);

        // click previous button
        getAddReportSubjectInformationPage().previouButton().click();
        Thread.sleep(2000);
        getAddReportNavigation().subjectInformationTab().click();
        Thread.sleep(2000);

        // click next button
        getAddReportSubjectInformationPage().nextButton().click();
        Thread.sleep(2000);
        getAddReportNavigation().subjectInformationTab().click();
        Thread.sleep(2000);

        // enter data for first name
        getAddReportSubjectInformationPage().firstName().sendKeys(faker.name().firstName());
        Thread.sleep(1000);

        // enter data for middle name
        getAddReportSubjectInformationPage().middleName().sendKeys(faker.name().lastName());
        Thread.sleep(1000);

        // enter data for last name
        getAddReportSubjectInformationPage().lastName().sendKeys(faker.name().lastName());
        Thread.sleep(1000);

        // enter data for suspect type
        getAddReportSubjectInformationPage().subjectType().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().subjectType()).selectByIndex(randomInt.nextInt(5));
        Thread.sleep(1000);

        // enter data for date of birth
        getAddReportSubjectInformationPage().dateOfBirth().click();
        Thread.sleep(1000);
        String dateofbirth = "" + randomInt.nextInt(12) + randomInt.nextInt(28) + (1900 + randomInt.nextInt(117));
        getAddReportSubjectInformationPage().dateOfBirth().sendKeys(dateofbirth);
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
        getAddReportSubjectInformationPage().nickName().sendKeys(faker.lorem().word());
        Thread.sleep(1000);

        // enter data for race
        getAddReportSubjectInformationPage().race().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().race()).selectByIndex(randomInt.nextInt(19));
        Thread.sleep(1000);

        // enter data for height
        double height1 = 1.00 + randomDouble.nextDouble()*7.00;
        getAddReportSubjectInformationPage().height().sendKeys(Double.toString(height1));
        Thread.sleep(1000);

        // enter data for weight
        double weight1 = 10.0 + randomDouble.nextDouble()*200.0;
        getAddReportSubjectInformationPage().weight().sendKeys(Double.toString(weight1));
        Thread.sleep(1000);

        // enter data for hair color
        getAddReportSubjectInformationPage().hairColor().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().hairColor()).selectByIndex(randomInt.nextInt(14));
        Thread.sleep(1000);

        // enter data for hair length
        getAddReportSubjectInformationPage().hairLength().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().hairLength()).selectByIndex(randomInt.nextInt(6));
        Thread.sleep(1000);

        // enter data for hair style
        getAddReportSubjectInformationPage().hairStyle().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().hairStyle()).selectByIndex(randomInt.nextInt(22));
        Thread.sleep(1000);

        // enter data for sex
        getAddReportSubjectInformationPage().sex().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().sex()).selectByIndex(randomInt.nextInt(3));
        Thread.sleep(1000);

        // enter data for build
        getAddReportSubjectInformationPage().build().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().build()).selectByIndex(randomInt.nextInt(9));
        Thread.sleep(1000);

        // enter data for eye color
        getAddReportSubjectInformationPage().eyeColor().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().eyeColor()).selectByIndex(randomInt.nextInt(8));
        Thread.sleep(1000);

        // enter data for complexion
        getAddReportSubjectInformationPage().complexion().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().complexion()).selectByIndex(randomInt.nextInt(5));
        Thread.sleep(1000);

        // enter data for teeth
        getAddReportSubjectInformationPage().teeth().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().teeth()).selectByIndex(randomInt.nextInt(4));
        Thread.sleep(1000);

        // enter data for hand preference
        getAddReportSubjectInformationPage().handPreference().click();
        Thread.sleep(1000);
        new Select(getAddReportSubjectInformationPage().handPreference()).selectByIndex(randomInt.nextInt(4));
        Thread.sleep(1000);


    }


    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }

}
