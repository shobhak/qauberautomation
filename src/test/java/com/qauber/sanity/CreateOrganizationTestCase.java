package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lenochka on 22.12.2016.
 * TODO: add to TestRail
 * TODO: add assert statements
 */
public class CreateOrganizationTestCase extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;
    String paypalEmailAccount = "jing_qauber_test01@test.com";
    String paypalPassword = "portnovschool";
    

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
    public void createOrganizationTestCase() throws InterruptedException {
        getDriver().get(testConfig().getBaseURL());

        Faker faker = new Faker();

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().clickEntities();
        Thread.sleep(sleepTime);

        getEntities().addOrganizationButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().entityNameField().sendKeys(faker.name().username());
        Thread.sleep(sleepTime);


        getCreateOrganization().entityPhoneField().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(sleepTime);

        getCreateOrganization().entityEmailField().sendKeys(faker.internet().emailAddress());
        Thread.sleep(sleepTime);

        //getCreateOrganization().entityCountryDropDown().sendKeys("Austria");
        Thread.sleep(sleepTime);

        getCreateOrganization().entityCountryDropDown("Austria").click();
        Thread.sleep(sleepTime);

        getCreateOrganization().entityAddress1().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime);

        getCreateOrganization().entityAddress2().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime);

        getCreateOrganization().entityCity().sendKeys(faker.address().city());
        Thread.sleep(sleepTime);

        getCreateOrganization().entityState().sendKeys(faker.address().state());
        Thread.sleep(sleepTime);

        getCreateOrganization().entityPostalCode().sendKeys(faker.address().zipCode());
        Thread.sleep(sleepTime);

        getCreateOrganization().entityNextButtone().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().inviteRegularUserEmailField().sendKeys(faker.internet().emailAddress());
        Thread.sleep(sleepTime);

        getCreateOrganization().inviteRegularUserNextButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().inviteRegularUserDoneButton().click();
        Thread.sleep(sleepTime*2);

        getCreateOrganization().inviteAdminUserEmailField().sendKeys(faker.internet().emailAddress());
        Thread.sleep(sleepTime);

        getCreateOrganization().inviteAdminUserNextButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().inviteAdminUserDoneButton().click();
        Thread.sleep(sleepTime*2);

        getCreateOrganization().finishButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().payWithMyPayPal().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().loginField().sendKeys(paypalEmailAccount);
        Thread.sleep(sleepTime*2);

        getCreateOrganization().passwordField().sendKeys(paypalPassword);
        Thread.sleep(sleepTime*2);

        getCreateOrganization().logInButton().click();
        Thread.sleep(sleepTime*2);

        getCreateOrganization().agreeAndContinueButton().click();
        Thread.sleep(sleepTime);
    }


    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}