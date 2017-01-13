package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

/**
 * Created by TODO: Whose test is this? on 12/19/16. I think it's Jing's?
 * TODO: add to TestRail
 * TODO: add asserts!
 */
public class EditOrganizationTest extends PageObjectModelResources {
    
    int sleepTime;
    String paypalEmailAccount = "jing_qauber_test01@test.com";
    String paypalPassword = "portnovschool";
    
    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
//        testConfig().getTestRail().setCaseID(79853); //sample TestRail case ID, 
//        testConfig().getTestRail().setTester("Erik's Script"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void editOrganizationTest() throws InterruptedException, AWTException {
     //   Entities entities = new Entities(driver);
     //   EditOrganizationPage org = new EditOrganizationPage(driver);



        Faker faker = new Faker();
        Random randomInt = new Random();

        int newOrgIndex = 0;

        String path1 = "System.getProperty(user.home)" + File.separator + "Downloads" + File.separator + "Eddie Cantor with Bert Gordon, aka \"the Mad Russian\".JPG";
        String path2 = "System.getProperty(user.home)" + File.separator + "Downloads" + File.separator + "Il_Tempo_Gigante.jpg";

        int countryindex = randomInt.nextInt(243);

        getDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime);

        // create a new organization so edit won't effect existing entities
        getEntities().addOrganizationButton().click();
        Thread.sleep(sleepTime);

        getCreateOrganization().entityNameField().sendKeys(faker.name().username());
        Thread.sleep(sleepTime/3);


        getCreateOrganization().entityPhoneField().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(sleepTime/3);

        getCreateOrganization().entityEmailField().sendKeys(faker.internet().emailAddress());
        Thread.sleep(sleepTime/3);

        //getCreateOrganization().entityCountryDropDown().sendKeys("Austria");
        Thread.sleep(sleepTime/2);

        getCreateOrganization().entityCountryDropDown("Austria").click();
        Thread.sleep(sleepTime/2);

        getCreateOrganization().entityAddress1().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime/3);

        getCreateOrganization().entityAddress2().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime/3);

        getCreateOrganization().entityCity().sendKeys(faker.address().city());
        Thread.sleep(sleepTime/3);

        getCreateOrganization().entityState().sendKeys(faker.address().state());
        Thread.sleep(sleepTime/2);

        getCreateOrganization().entityPostalCode().sendKeys(faker.address().zipCode());
        Thread.sleep(sleepTime/2);

        getCreateOrganization().entityNextButtone().click();
        Thread.sleep(sleepTime);

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

        // edit the organization that just been created

        newOrgIndex = getEntities().organizationList().size();
        Thread.sleep(sleepTime/2);
        System.out.println(newOrgIndex);

        getEntities().editOrganizationButton(newOrgIndex).click();
        Thread.sleep(sleepTime/2);

        //edit organization name
        getOrganization().organizatonName().clear();
        Thread.sleep(sleepTime/4);
        String orgName = "Kodman";
        getOrganization().organizatonName().sendKeys(orgName);
        Thread.sleep(sleepTime/2);

        //edit phone number
        getOrganization().phoneNumber().clear();
        Thread.sleep(sleepTime/4);
        getOrganization().phoneNumber().sendKeys(faker.phoneNumber().phoneNumber());
        Thread.sleep(sleepTime/2);

        //edit email
        getOrganization().eMail().clear();
        Thread.sleep(sleepTime/4);
        getOrganization().eMail().sendKeys(faker.internet().emailAddress());
        Thread.sleep(sleepTime/2);

        //edit organization logo
//        getOrganization().organizationPhotoDeleteButton().click();
//        Thread.sleep(sleepTime/4);
//        getOrganization().organizationPhotoAddButton().click();
//        Thread.sleep(sleepTime/2);

        // create a file path with StringSelection and copy it to clipboard
//        StringSelection filepath1 = new StringSelection(path1);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
//
//        // create a robot object and simulate the pasted action on prompt window
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//        Thread.sleep(sleepTime);
//        getOrganization().organizationPhotoChangeButton().click();
//        Thread.sleep(sleepTime/2);
//        // create a file path with StringSelection and copy it to clipboard
//        StringSelection filepath2 = new StringSelection(path2);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath2, null);
//
////        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//
//        Thread.sleep(sleepTime);

        //edit country and state
        if (countryindex == 229){
            Select countryselect = new Select(getOrganization().countryList());
            countryselect.selectByIndex(countryindex);
            Thread.sleep(sleepTime/4);
            Select stateselect = new Select(getOrganization().stateList());
            stateselect.selectByIndex(randomInt.nextInt(58));
            Thread.sleep(sleepTime/4);
        } else {
            Select countryselect = new Select(getOrganization().countryList());
            countryselect.selectByIndex(countryindex);
            Thread.sleep(sleepTime/4);
            getOrganization().state().clear();
            Thread.sleep(sleepTime/4);
            getOrganization().state().sendKeys(faker.address().state());
            Thread.sleep(sleepTime/4);
        }

        // edit address 1
        getOrganization().address1().clear();
        Thread.sleep(sleepTime/4);
        getOrganization().address1().sendKeys(faker.address().streetAddress());
        Thread.sleep(sleepTime/4);

        // edit city
        getOrganization().city().clear();
        Thread.sleep(sleepTime/4);
        getOrganization().city().sendKeys(faker.address().city());
        Thread.sleep(sleepTime/4);

        // edit postal code
        getOrganization().postalCode().clear();
        Thread.sleep(sleepTime/4);
        getOrganization().postalCode().sendKeys(faker.address().zipCode());
        Thread.sleep(sleepTime/4);

        // edit note
        getOrganization().note().clear();
        Thread.sleep(sleepTime/4);
        getOrganization().note().sendKeys(faker.lorem().paragraph(2));
        Thread.sleep(sleepTime/2);

        // Press update button to confirm change
        getOrganization().updateButton().click();

        Thread.sleep(sleepTime/5);

        // Verify the update message been displayed
        try {
            Assert.assertEquals(true, getEntities().entityUpdatedMessage().isDisplayed());
        }
        catch (AssertionError e){
            System.out.println("update organization failed");
        }

        Assert.assertEquals(getEntities().organizationInfo(newOrgIndex).getText(), orgName);
    }
    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
