package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jing Xu on 12/30/2016.
 * TODO: convert to ConfigOOP
 * TODO: add preconditions (subscribed entities?) - try/catch at deleteSubscriptionIndex, or just throw them in the beginning :-)
 * TODO: add to TestRail
 */
public class RegularUserCannotSeeDeleteSubscriptionOrganization extends PageObjectModelResources {
    int sleepTime;
    private String paypalEmailAccount = "jing_qauber_test01@test.com";
    private String paypalPassword = "portnovschool";

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
    public void regularUserCannotSeeDeleteSubscriptionOrganization() throws InterruptedException {
        int deleteSubscriptionIndex;
        int entitiesListNumberRU;
        List<String> hideEntitiesNameListRU = new ArrayList<String>();
        Random randomInt = new Random();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime/2);

        try{
            Assert.assertEquals(getProfilePanel().settingsText().getText(), "Settings");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);
        }

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

        deleteSubscriptionIndex = randomInt.nextInt(getProfilePanel().entitiesList().size()) + 1;
        System.out.println("Let's delete " + getProfilePanel().entitiesList().get(deleteSubscriptionIndex - 1).getText());
        getProfilePanel().organizationLink(deleteSubscriptionIndex).click();
        Thread.sleep(sleepTime/2);

        getSubscriptionSettings().cancelSubscriptionButton().click();
        Thread.sleep(sleepTime*2);

        try{
            Assert.assertNotEquals(true, getNavBar().reportsButton().isDisplayed());
        }
        catch (AssertionError e){
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);

            getProfilePanel().logOutButton().click();
            Thread.sleep(sleepTime/2);
        }

        // re-login as regular user
        setUpUser(User.UserType.RU);
        Thread.sleep(sleepTime/2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime/2);

        try{
            Assert.assertEquals(getProfilePanel().settingsText().getText(), "Settings");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);
        }

        // Verify that there is no entity displayed for Regular users or Admin users
        try {
            entitiesListNumberRU = getProfilePanel().entitiesList().size();
            Assert.assertEquals(entitiesListNumberRU, 0);
        } catch (AssertionError e) {
            System.out.println("The Regular User can access the subscription, it is a bug!!!");
        }

        // finding out the hidden entities
        System.out.println("There are " + getProfilePanel().hideEntitiesForNonSAU().size() + " entities hiden from Regular Users.");
        for (int j = 0; j < getProfilePanel().hideEntitiesForNonSAU().size(); j++){
            hideEntitiesNameListRU.add((String) ((JavascriptExecutor) testDriver()).executeScript("return arguments[0].innerHTML", getProfilePanel().hideEntitiesForNonSAU().get(j)));
            System.out.println(hideEntitiesNameListRU.get(j));
        }

        Thread.sleep(sleepTime/2);
    }

    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
