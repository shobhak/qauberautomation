package com.qauber.pagestest;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pages.EditOrganizationPage;
import com.qauber.pages.Entities;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

/**
 * Created by erikfriedlander on 12/19/16.
 */
public class EditOrganizationTest extends PageObjectModelResources {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
    }

    @Test
    public void editOrganizationTest() throws InterruptedException, AWTException {
     //   Entities entities = new Entities(driver);
     //   EditOrganizationPage org = new EditOrganizationPage(driver);
        Faker faker = new Faker();
        Random randomInt = new Random();

        int rowindex = 0;
        String orgname = "org003";

        String path1 = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg";
        String path2 = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg";

        int countryindex = randomInt.nextInt(243);
//        int countryindex = 229;

        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);

        getNavBar().entitiesButton().click();
        Thread.sleep(5000);


//        List<WebElement> elements = getEntities().organizationList();

        rowindex = getEntities().findEditOrganizationIndex(orgname);
        Thread.sleep(2000);

        getEntities().editOrganizationButton(rowindex).click();
        Thread.sleep(2000);

        //edit organization name
//        getOrganization().organizatonName().clear();
//        Thread.sleep(1000);
//        getOrganization().organizatonName().sendKeys(faker.company().name());
//        Thread.sleep(2000);

        //edit phone number
        getOrganization().phoneNumber().clear();
        Thread.sleep(1000);
        getOrganization().phoneNumber().sendKeys(faker.phoneNumber().phoneNumber());
        Thread.sleep(2000);

        //edit email
        getOrganization().eMail().clear();
        Thread.sleep(1000);
        getOrganization().eMail().sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);

        //edit organization logo
        getOrganization().organizationPhotoDeleteButton().click();
        Thread.sleep(1000);
        getOrganization().organizationPhotoAddButton().click();
        Thread.sleep(2000);

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


        Thread.sleep(5000);
        getOrganization().organizationPhotoChangeButton().click();
        Thread.sleep(2000);
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

        Thread.sleep(5000);

        //edit country and state
        if (countryindex == 229){
            Select countryselect = new Select(getOrganization().countryList());
            countryselect.selectByIndex(countryindex);
            Thread.sleep(1000);
            Select stateselect = new Select(getOrganization().stateList());
            stateselect.selectByIndex(randomInt.nextInt(58));
            Thread.sleep(1000);
        } else {
            Select countryselect = new Select(getOrganization().countryList());
            countryselect.selectByIndex(countryindex);
            Thread.sleep(1000);
            getOrganization().state().clear();
            Thread.sleep(1000);
            getOrganization().state().sendKeys(faker.address().state());
            Thread.sleep(1000);
        }

        // edit address 1
        getOrganization().address1().clear();
        Thread.sleep(1000);
        getOrganization().address1().sendKeys(faker.address().streetAddress());
        Thread.sleep(1000);

        // edit city
        getOrganization().city().clear();
        Thread.sleep(1000);
        getOrganization().city().sendKeys(faker.address().city());
        Thread.sleep(1000);

        // edit postal code
        getOrganization().postalCode().clear();
        Thread.sleep(1000);
        getOrganization().postalCode().sendKeys(faker.address().zipCode());
        Thread.sleep(1000);

        // edit note
        getOrganization().note().clear();
        Thread.sleep(1000);
        getOrganization().note().sendKeys(faker.lorem().paragraph(2));
        Thread.sleep(3000);

        // Press update button to confirm change
        getOrganization().updateButton().click();

        Thread.sleep(10000);


    }
    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
