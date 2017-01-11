package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lenochka on 27.12.2016.
 * TODO: Add preconditions
 * TODO: add to TestRail
 */
public class CompanyCreationSAUTestCase extends PageObjectModelResources {
    private int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
//        testConfig().getTestRail().setCaseID(79853); //TestRail case ID
//        testConfig().getTestRail().setTester("Erik's Script"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void companyCreationSAUTestCase() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        Faker faker = new Faker();
        String pswd = faker.internet().password();
        System.out.println(pswd);

        String country = "Switzerland";

        getCompanyCreationSAU().registerNow().click();
        Thread.sleep(sleepTime);

        getCompanyCreationSAU().regName().sendKeys(faker.name().username());
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().regEmail().sendKeys(faker.internet().emailAddress());
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().regPassword().sendKeys(pswd);
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().regConfirmPassword().sendKeys(pswd);
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().regContinueRegistration().click();
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().companyName().sendKeys(faker.name().username());
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().companyPhone().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().companyEmail().sendKeys(faker.internet().emailAddress());
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().companyCountry().sendKeys(country);
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().companyAddress1().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().companyAddress2().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().companyCity().sendKeys(faker.address().city());
        Thread.sleep(sleepTime*2/3);

        if (country == "United States") {
            getCompanyCreationSAU().companyStateDropDown().sendKeys("Texas");

        } else {
            getCompanyCreationSAU().companyStateField().sendKeys("Canton");

        }

        getCompanyCreationSAU().companyZip().sendKeys(faker.address().zipCode());
        Thread.sleep(sleepTime*2/3);

        getCompanyCreationSAU().companyFinishRegButton().click();
    }

    @AfterClass
    public void breakDown() throws InterruptedException {
        breakDownHelper();
    }
}