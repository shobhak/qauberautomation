package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by San Jose on 12/22/16.
 * TODO: add assert (how to check when edit is successful?)
 * TODO: multiple words (Reduce chance of changing to 'same' name)
 * ---> faker.lorem().words(3)
 * TODO: don't edit first department (pick a later number)
 * TODO: add preconditions (when available)
 */
public class Edit_Department_AU extends PageObjectModelResources {

    int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.AU); //Pass in user

        //TestRail Configuration
//        testConfig().getTestRail().setCaseID(82798); //TestRail case ID
//        testConfig().getTestRail().setTester("ElenaB"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();

    }

    @Test
    public void editDepartmentAU() throws InterruptedException{
        testDriver().get(testConfig().getBaseURL());
        Faker faker = new Faker();

        String expectedResult = faker.lorem().word(); //department name
        String actualResult;

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime);

        getEntities().organizationList().get(0).click();
        Thread.sleep(sleepTime);

        getEntities().editOrganizationButton(1).click();
        Thread.sleep(sleepTime);

        getEntitiesDepartmentSettings().departmentname(1).clear();
        getEntitiesDepartmentSettings().departmentname(1).sendKeys(expectedResult);

        getEntitiesDepartmentSettings().departmentUpdatebutton(1).click();
        Thread.sleep(sleepTime);

        getEntities().editOrganizationButton(1).click();
        Thread.sleep(sleepTime);
        getEntitiesDepartmentSettings().departmentCancelbutton(1).click();
        Thread.sleep(sleepTime);
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}