package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;


//Created by Denys_G on 12/22/2016.
//TODO: add asserts

public class UsersAssignPermissions extends PageObjectModelResources {

    private int sleepTime;

    /** NOTE: Preconditions about existing entities and admin assigned should be added*/

    @BeforeTest
    public void setUp() {
        setUpWithConfigFile(); //Read config file from disk, create if not present

        //Misc configuration
        sleepTime = testConfig().getSleepTime();
    }

    @Test
    public void testAsSAU() throws AWTException, InterruptedException {
        setUpUser(User.UserType.SAU); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        setUpScript();
        assignPermissionsUsers();
        breakDownHelper();
    }
    @Test(priority = 1)
    public void testAsAU() throws AWTException, InterruptedException {
        setUpUser(User.UserType.AU); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        setUpScript();
        assignPermissionsUsers();
    }

    public void assignPermissionsUsers() throws InterruptedException, AWTException {

        /** NOTE: index in the list is different while logged in as different users*/
        int userIndex = 2;
        int entityIndex = 1;

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
        Thread.sleep(sleepTime/8);
    }

    @AfterTest
    public void breakDown(){
        breakDownHelper();
    }
}
