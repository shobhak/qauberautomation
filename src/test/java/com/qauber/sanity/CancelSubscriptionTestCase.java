package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Jing Xu on 12/29/2016.
 * TODO: add conditions
 */
public class CancelSubscriptionTestCase extends PageObjectModelResources {
    private int sleepTime;
    private String paypalEmailAccount = "jing_qauber_test01@test.com";
    private String paypalPassword = "portnovschool";

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
        testConfig().getTestRail().setCaseID(82802); //TestRail case ID
        testConfig().getTestRail().setTester("Jing"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void cancelSubscription() throws InterruptedException {
        int entities;
        int lastSubscriptionindex;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        Faker faker = new Faker();

        getNavBar().clickEntities();
        Thread.sleep(sleepTime);

        getEntities().addOrganizationButton().click(); // create a new organization
        Thread.sleep(sleepTime);

        getCreateOrganization().entityNameField().sendKeys(faker.name().username());
        Thread.sleep(sleepTime);

        getCreateOrganization().entityPhoneField().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(sleepTime);

        getCreateOrganization().entityEmailField().sendKeys(faker.internet().emailAddress());
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

        getCreateOrganization().inviteRegularUserNextButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().inviteAdminUserNextButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().finishButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().payWithMyPayPal().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().loginField().sendKeys(paypalEmailAccount);
        Thread.sleep(sleepTime);

        getCreateOrganization().passwordField().sendKeys(paypalPassword);
        Thread.sleep(sleepTime);

        getCreateOrganization().logInButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().agreeAndContinueButton().click();
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime/2);

        try{
            Assert.assertEquals(getProfilePanel().settingsText().getText(), "Settings");
        }
        catch (NoSuchElementException f) {
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);
        }

        lastSubscriptionindex = getProfilePanel().entitiesList().size();        // find last organization then cancel subscription for it
        System.out.println(lastSubscriptionindex);
        getProfilePanel().organizationLink(lastSubscriptionindex).click();
        Thread.sleep(sleepTime);

        getSubscriptionSettings().cancelSubscriptionButton().click();
        Thread.sleep(sleepTime);

        // on some system, the site logout after cancellation, this is to determine the state of the site
        // add re-login if site is logout
        try{
            Assert.assertEquals(true, getNavBar().reportsButton().isDisplayed());
        }
        catch (NoSuchElementException e) {
            getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
            Thread.sleep(sleepTime);
        }

        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime);

        entities = getEntities().organizationList().size();

        try {
            Assert.assertEquals(true, getEntities().finishCreateOrganizationButton(entities).isDisplayed());
        } catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Subscription has not been cancelled: " + e.getLocalizedMessage() );
            throw e;
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test Passed.");
        Thread.sleep(sleepTime*2);

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
