package com.qauber.pagestest;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by jingx on 12/22/2016.
 */
public class SuperAdminDeleteEntityTestCase extends PageObjectModelResources {
    int sleepTime;
    private String paypalEmailAccount = "jing_qauber_test01@test.com";
    private String paypalPassword = "portnovschool";

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
//        testConfig().getTestRail().setCaseID(79853); //sample TestRail case ID,
//        testConfig().getTestRail().setTester("Erik's Computer"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void superAdminDeleteEntity() throws InterruptedException {
        int rowindex;
        Random randomInt = new Random();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().clickEntities();
        Thread.sleep(sleepTime);

        Faker faker = new Faker();

        getNavBar().clickEntities();
        Thread.sleep(sleepTime);

        getEntities().addOrganizationButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().entityNameField().sendKeys(faker.name().username());
        Thread.sleep(sleepTime/2);

        getCreateOrganization().entityAddress1().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime/2);

        getCreateOrganization().entityCity().sendKeys(faker.address().city());
        Thread.sleep(sleepTime/2);

        Select stateselect = new Select(getOrganization().stateList());
        stateselect.selectByIndex(randomInt.nextInt(58));
        Thread.sleep(sleepTime/4);

        getCreateOrganization().entityPostalCode().sendKeys(faker.address().zipCode());
        Thread.sleep(sleepTime/2);

        getCreateOrganization().entityNextButtone().click();
        Thread.sleep(sleepTime/2);

        getCreateOrganization().inviteRegularUserNextButton().click();
        Thread.sleep(sleepTime/2);

        getCreateOrganization().inviteAdminUserNextButton().click();
        Thread.sleep(sleepTime/2);

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

        getNavBar().clickEntities();
        Thread.sleep(sleepTime/2);


        // find the organization row index
        rowindex = getEntities().organizationList().size();
        Thread.sleep(sleepTime/3);


        // click the organization delete button;
        getEntities().deleteOrganizationButton(rowindex).click();
        Thread.sleep(sleepTime/2);

        // click the cancel button
        getEntitiesPermissionsDialog().deleteOrgCancel().click();
        Thread.sleep(sleepTime/2);

        // click the organization delete button;
        getEntities().deleteOrganizationButton(rowindex).click();
        Thread.sleep(sleepTime/2);

        // click the delete button
        getEntitiesPermissionsDialog().deleteOrgDelete().click();
        Thread.sleep(sleepTime/2);

        try{
            getEntities().organizationInfo(rowindex).isDisplayed();
            System.out.println("Failed to delete the entity");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("The newly created entity has been deleted");
        }

    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
