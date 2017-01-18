package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.Mailinator;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
        testConfig().getTestRail().setCaseID(82781); //TestRail case ID
        testConfig().getTestRail().setTester("ElenaB"); //put your name :-)

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
        String companyname = faker.name().username();
        System.out.println(companyname);
        //Goal: create mailinator email address with and without domain (@mailinator.com)
        // create a user name
        String fullName = faker.name().name();
        System.out.println(fullName);

        String localPartOfEmailAddress = fullName.replace(" ", "").toLowerCase();
        System.out.println(localPartOfEmailAddress);

        String fullEmailAddress = localPartOfEmailAddress + "@mailinator.com";

        Mailinator mailinator = new Mailinator(testDriver());

        String country; //= "Switzerland";

        getCompanyCreationSAU().registerNow().click();
        Thread.sleep(sleepTime);

        getCompanyCreationSAU().regName().sendKeys(fullName);
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().regEmail().sendKeys(fullEmailAddress);
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().regPassword().sendKeys(pswd);
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().regConfirmPassword().sendKeys(pswd);
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().regContinueRegistration().click();
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().companyName().sendKeys(faker.name().username());
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().companyPhone().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().companyEmail().sendKeys(faker.internet().emailAddress());
        Thread.sleep(sleepTime * 2 / 3);

        country = "United States";
        new Select(getCompanyCreationSAU().companyCountry()).selectByVisibleText(country);

        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().companyAddress1().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().companyAddress2().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().companyCity().sendKeys(faker.address().city());
        Thread.sleep(sleepTime * 2 / 3);

        if (country.equals("United States")) {
            new Select(getCompanyCreationSAU().companyStateDropDown()).selectByVisibleText(faker.address().state());

        } else {
            getCompanyCreationSAU().companyStateField().sendKeys("Canton");

        }

        getCompanyCreationSAU().companyZip().sendKeys(faker.address().zipCode());
        Thread.sleep(sleepTime * 2 / 3);

        getCompanyCreationSAU().companyFinishRegButton().click();
        Thread.sleep(60000);

        // navigate to mailinator
        String activationLink = mailinator.getFirstLinkInFirstEmailInAccount(localPartOfEmailAddress);
        System.out.println(activationLink);

        //click on accept registration link
        testDriver().get(activationLink);
        //confirm registration

        Thread.sleep(10000);
        //try to login in with the created credentials

        getLogin().loginToWave(fullEmailAddress,pswd);
        Thread.sleep(5000);
//    assert there is User button
        try {
            Assert.assertEquals(getEntities().addOrganizationButton().getText(), "Add Entity"); //ASSERT IF TEXT IS CORRECT
            //Change assertion and see what happens.
        } catch (AssertionError e) { //IF TEXT IS WRONG, 'CATCH' ASSERTION ERROR AND REPORT RESULTS!
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "\"Add Entity\" button text is not found. Login failed. "+e.getLocalizedMessage());
            throw e; //Throw failed assertion back to TestRail.
            //Try commenting out 'throw e' with a failed assertion, and see what happens :-)
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed"); //upload

        Thread.sleep(15000); //so we can see what happened

}
    @AfterClass
    public void breakDown() throws InterruptedException {
        breakDownHelper();
    }
}