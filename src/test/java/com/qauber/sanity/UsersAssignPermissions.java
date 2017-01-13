package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;


//Created by Denys_G on 12/22/2016.
//TODO: add asserts

public class UsersAssignPermissions extends PageObjectModelResources {

    private int sleepTime;
    /** NOTE: index in the list is different while logged in as different users*/
    int userIndex = 2;
    int entityIndex = 1;

    /** NOTE: Preconditions about existing entities and admin assigned should be added*/

    @BeforeTest
    public void setUp() {
        setUpWithConfigFile(); //Read config file from disk, create if not present

        //Misc configuration
        sleepTime = testConfig().getSleepTime();
    }

    @Test
    public void testAsSAU() throws AWTException, InterruptedException {
        testConfig().getTestRail().setCaseID(82783);
        testConfig().getTestRail().setTester("Denys_G");
        setUpUser(User.UserType.SAU); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        setUpScript();
        assignPermissionsUsers();

        breakDownHelper();//used to close window
    }
    @Test(priority = 1)
    public void testAsAU() throws AWTException, InterruptedException {
        testConfig().getTestRail().setCaseID(82785);
        testConfig().getTestRail().setTester("Denys_G");
        setUpUser(User.UserType.AU); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        setUpScript();
        assignPermissionsUsers();

    }

    public void assignPermissionsUsers() throws InterruptedException, AWTException {

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime/3);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime/3);
        getNavBar().usersButton().click();
        Thread.sleep(sleepTime/3);
        getUsers().assignPermissionsButtonByIndex(userIndex).click();
        Thread.sleep(sleepTime/8);
        getUsersPermissionsDialog().detachUserPermissionsTR(entityIndex);
        Thread.sleep(sleepTime/8);
        getUsersPermissionsDialog().setUserAsAdminTR(entityIndex);
        Thread.sleep(sleepTime/8);
        getUsersPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime/4);
        getUsers().assignPermissionsButtonByIndex(userIndex).click();
        Thread.sleep(sleepTime/8);
        try {
            Assert.assertEquals(getUsersPermissionsDialog().rightsSavedTR(entityIndex).getText(),
                    "Admin");//method setUserAsAdmin
        } catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Other permission shown "+e.getLocalizedMessage());
            throw e;
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");

    }

    @AfterTest
    public void breakDown(){
        breakDownHelper();
    }
}
