package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by Denys_G on 12/21/16.
 * TODO: Add Assertions
 * TODO: TestRail Integration
 * TODO: preconditions?
 */

public class EntitiesAssignPermissions extends PageObjectModelResources {

    int sleepTime;

    @BeforeTest
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

    }

    @Test
    public void testAsSAU() throws AWTException, InterruptedException {
        setUpUser(User.UserType.SAU); //pass userType and browser. see ~/QAUberTestConfig

        setUpScript();


        //flowing method sets precondition for AU in next test(while already logged in as SAU)
        assignPermissionsEntities();
        getPreconditions().getPermissionsPreconditions().setAUasAdminToAllEntities(testDriver());
        breakDownHelper();
    }
    @Test(priority = 1)
    public void testAsAU() throws AWTException, InterruptedException {
//        getPreconditions().getPermissionsPreconditions().ensureAUIsAdminAllEntities();

        setUpUser(User.UserType.AU); //pass userType and browser. see ~/QAUberTestConfig

        setUpScript();
        assignPermissionsEntities();
    }

    public void assignPermissionsEntities() throws InterruptedException, AWTException {

        /** NOTE: index in the list is different while logged in as different user(different permissions)*/
        int EntityDepSubdepIndex = 1;
        int userIndex = 2;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime/2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime/2);
        getEntities().assignPermissionButton(EntityDepSubdepIndex).click();
        Thread.sleep(sleepTime/8);
        getEntitiesPermissionsDialog().detachUserPermissionsTR(userIndex);
        Thread.sleep(sleepTime/10);
        getEntitiesPermissionsDialog().setUserAsRegularUser(userIndex);
        Thread.sleep(sleepTime/10);
        getEntitiesPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime/10);
    }

    @AfterTest
    public void breakDown(){
        breakDownHelper();
    }
}
