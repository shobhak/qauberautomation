package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

/**
 * Created by TODO: Whose test is this? on 12/19/16.
 * TODO: add to TestRail
 * TODO: add asserts!
 */
public class EditOrganizationTest extends PageObjectModelResources {
    
    int sleepTime;
    
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

        int rowindex = 0;

        String orgname = "org003"; //TODO: not hardcode this. For now, I'm putting this into preconditions.

        String path1 = "System.getProperty(user.home)" + File.separator + "Downloads" + File.separator + "Eddie Cantor with Bert Gordon, aka \"the Mad Russian\".JPG";
        String path2 = "System.getProperty(user.home)" + File.separator + "Downloads" + File.separator + "Il_Tempo_Gigante.jpg";

        int countryindex = randomInt.nextInt(243);
//        int countryindex = 229;

        getDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime);

        //Preconditions. TODO: not hardcode orgname. For now, I'm putting this into preconditions to run the script.
        getPreconditions().getEntitiesNamesPreconditions().ensureEntityNameExists(orgname);

//        List<WebElement> elements = getEntities().organizationList();

        rowindex = getEntities().findEditOrganizationIndex(orgname);
        Thread.sleep(sleepTime/2);
        System.out.println(rowindex);

        getEntities().editOrganizationButton(rowindex).click();
        Thread.sleep(sleepTime/2);

        //edit organization name
//        getOrganization().organizatonName().clear();
//        Thread.sleep(sleepTime/4);
//        getOrganization().organizatonName().sendKeys(faker.company().name());
//        Thread.sleep(sleepTime/2);

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
        getOrganization().organizationPhotoDeleteButton().click();
        Thread.sleep(sleepTime/4);
        getOrganization().organizationPhotoAddButton().click();
        Thread.sleep(sleepTime/2);

        // create a file path with StringSelection and copy it to clipboard
        StringSelection filepath1 = new StringSelection(path1);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);

        // create a robot object and simulate the pasted action on prompt window
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        Thread.sleep(sleepTime);
        getOrganization().organizationPhotoChangeButton().click();
        Thread.sleep(sleepTime/2);
        // create a file path with StringSelection and copy it to clipboard
        StringSelection filepath2 = new StringSelection(path2);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath2, null);

//        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(sleepTime);

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

        Thread.sleep(sleepTime/4);


    }
    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
