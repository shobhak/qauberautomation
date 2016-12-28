package com.qauber.pagestest;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lenochka on 27.12.2016.
 */
public class CompanyCreationSAUTestCase extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
    }

    @Test
    public void companyCreationSAUTestCase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(Config.getBaseURL());
        Thread.sleep(5000);



        Faker faker = new Faker();
        String pswd = faker.internet().password();
        System.out.println(pswd);

        String country = "Switzerland";

        getCompanyCreationSAU().registerNow().click();
        Thread.sleep(4000);

        getCompanyCreationSAU().regName().sendKeys(faker.name().username());
        Thread.sleep(3000);

        getCompanyCreationSAU().regEmail().sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);

        getCompanyCreationSAU().regPassword().sendKeys(pswd);
        Thread.sleep(3000);

        getCompanyCreationSAU().regConfirmPassword().sendKeys(pswd);
        Thread.sleep(3000);

        getCompanyCreationSAU().regContinueRegistration().click();
        Thread.sleep(3000);

        getCompanyCreationSAU().companyName().sendKeys(faker.name().username());
        Thread.sleep(3000);

        getCompanyCreationSAU().companyPhone().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(3000);

        getCompanyCreationSAU().companyEmail().sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);

        getCompanyCreationSAU().companyCountry().sendKeys(country);
        Thread.sleep(3000);

        getCompanyCreationSAU().companyAddress1().sendKeys(faker.address().streetAddress());
        Thread.sleep(3000);

        getCompanyCreationSAU().companyAddress2().sendKeys(faker.address().streetAddress());
        Thread.sleep(3000);

        getCompanyCreationSAU().companyCity().sendKeys(faker.address().city());
        Thread.sleep(3000);

        if (country == "United States") {
            getCompanyCreationSAU().companyStateDropDown().sendKeys("Texas");

        } else {
            getCompanyCreationSAU().companyStateField().sendKeys("Canton");

        }

        getCompanyCreationSAU().companyZip().sendKeys(faker.address().zipCode());
        Thread.sleep(3000);

        getCompanyCreationSAU().companyFinishRegButton().click();
    }
    @AfterClass
    public void breakDown () throws InterruptedException{

        Thread.sleep(10000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }
}