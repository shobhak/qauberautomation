package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by San Jose on 12/22/16.
 * TODO: add assert (how to check when delete is successful?)
 * TODO: add to TestRail
 * TODO: don't delete first department
 * TODO: add preconditions (when available)
 */
public class Delete_Department_AU extends PageObjectModelResources {

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
    public void deleteDepartmentAU() throws InterruptedException{
        testDriver().get(testConfig().getBaseURL());


        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime);

        getEntities().organizationList().get(0).click();
        Thread.sleep(sleepTime);

        getEntities().departmentDeleteButtonList().get(0).click();
        Thread.sleep(sleepTime);

        getEntitiesDepartmentSettings().departmentCancelDeliteButton(1).click();
        Thread.sleep(sleepTime);

        getEntities().departmentDeleteButtonList().get(0).click();
        Thread.sleep(sleepTime);

        getEntitiesDepartmentSettings().departmentConfirmDeliteButton(1).click();
        Thread.sleep(sleepTime);

    }

    @AfterClass public void breakDown() {
        breakDownHelper();
    }
}