package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by Denys_G on 12/21/16.
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
        testConfig().getTestRail().setCaseID(82782);
        testConfig().getTestRail().setTester("Denys_G");
        setUpUser(User.UserType.SAU); //pass userType and browser. see ~/QAUberTestConfig
        setUpScript();
        assignPermissionsEntities();

        //flowing method sets precondition for AU in next test(while already logged in as SAU)
        getPreconditions().getPermissionsPreconditions().setAUasAdminToAllEntities(testDriver());
        Thread.sleep(sleepTime/4);

        breakDownHelper();//force close browser for this test while @afterTest doesn't:(
    }
    @Test(priority = 1)
    public void testAsAU() throws AWTException, InterruptedException {

//  This precondition isn't used to save time of opening new browser(log in as SAU and verify preconditions)
//  set precondition(which is part of ensure precondition) is used in test above
//  getPreconditions().getPermissionsPreconditions().ensureAUIsAdminAllEntities();

        testConfig().getTestRail().setCaseID(82784);
        testConfig().getTestRail().setTester("Denys_G");
        setUpUser(User.UserType.AU); //pass userType and browser. see ~/QAUberTestConfig

        setUpScript();
        assignPermissionsEntities();
    }

    public void assignPermissionsEntities() throws InterruptedException, AWTException {

        /** NOTE: index in the list is different while logged in as different user(different permissions)*/
        int entityIndex = 1;
        int userIndex = 2;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime/2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime/2);
        getEntities().assignPermissionButton(entityIndex).click();
        Thread.sleep(sleepTime/8);
        getEntitiesPermissionsDialog().detachUserPermissionsTR(userIndex);
        Thread.sleep(sleepTime/10);
        getEntitiesPermissionsDialog().setUserAsRegularUser(userIndex);      //set as Regular user here
        Thread.sleep(sleepTime/10);
        getEntitiesPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime/8);
        getEntities().assignPermissionButton(entityIndex).click();
        Thread.sleep(sleepTime/8);
        try {
            Assert.assertEquals(getEntitiesPermissionsDialog().rightsDropdownByIndex(userIndex)
                    .getFirstSelectedOption().getText(), "Regular user"); //method setUserAsRegularUser
        } catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Other permission shown "+e.getLocalizedMessage());
            throw e;
        }
        Thread.sleep(sleepTime/10);
        getEntitiesPermissionsDialog().closeDialogByPressESC();
        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");

    }

    @AfterTest
    public void breakDown(){
        breakDownHelper();
    }
}
