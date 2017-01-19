package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Jing Xu on 12/29/2016.
 * TODO: write a PayPal helper class to replace hardcoded Paypal code... let's not have driver.findElement anywhere in test case :-)
 * TODO: TestRail integration
 * TODO: check for (pre)condition, run as needed?
 */
public class EditSubscriptionTestCase extends PageObjectModelResources {
    int sleepTime;
    private String paypalEmailAccount = "jing_qauber_test01@test.com";
    private String paypalPassword = "portnovschool";

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
        testConfig().getTestRail().setCaseID(82801); //sample TestRail case ID,
        testConfig().getTestRail().setTester("Jing"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();    }

    @Test
    public void editSubscription() throws InterruptedException {
        int entitiesnumber;
        int editentityindex;
        int newusersnumber;
        int currentusernumber;
        Random randomInt = new Random();

        getDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime/2);

        try{
            Assert.assertEquals(getProfilePanel().subscriptionsText().getText(), "SUBSCRIPTIONS");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);
        }

        // create a subscription organization if none
        try{
            Assert.assertNotEquals(getProfilePanel().entitiesList().size(), 0);
        }
        catch (AssertionError e){
            Faker faker = new Faker();

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
            Thread.sleep(sleepTime*3);

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
        }
        entitiesnumber = getProfilePanel().entitiesList().size();
        editentityindex = randomInt.nextInt(entitiesnumber) + 1;
        currentusernumber = Integer.parseInt(getProfilePanel().organizationLink(editentityindex).getText());
        System.out.println(currentusernumber);
        getProfilePanel().organizationLink(editentityindex).click();
        Thread.sleep(sleepTime/2);

        newusersnumber = 5 + randomInt.nextInt(36);
        System.out.println(newusersnumber);

        getSubscriptionSettings().slider(newusersnumber);
        Thread.sleep(sleepTime/2);

        getSubscriptionSettings().changeSubscritionButton().click();
        Thread.sleep(sleepTime*2);

        //working on paypal sandbox web pages
        try{
            Assert.assertNotEquals(true, getCreateSubsciption().payWithMyPayPal().isDisplayed());
        }
        catch(AssertionError e){
            getCreateOrganization().payWithMyPayPal().click();
            Thread.sleep(sleepTime);
        }
        catch(NoSuchElementException e){
        }
        getCreateSubsciption().loginField().clear();
        Thread.sleep(sleepTime*3/5);
        getCreateSubsciption().loginField().sendKeys(paypalEmailAccount);
        Thread.sleep(sleepTime*3/5);

        getCreateSubsciption().passwordField().clear();
        Thread.sleep(sleepTime*3/5);
        getCreateSubsciption().passwordField().sendKeys(paypalPassword);
        Thread.sleep(sleepTime*3/5);

        getCreateSubsciption().logInButton().click();
        Thread.sleep(sleepTime);

        getCreateSubsciption().agreeAndContinueButton().click();
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime/2);

        try{
            Assert.assertEquals(getProfilePanel().subscriptionsText().getText(), "SUBSCRIPTIONS");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);
        }

        try {
            Assert.assertEquals(newusersnumber, Integer.parseInt(getProfilePanel().organizationLink(editentityindex).getText()));
        } catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "The number of subscription not match: " + e.getLocalizedMessage() );
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
