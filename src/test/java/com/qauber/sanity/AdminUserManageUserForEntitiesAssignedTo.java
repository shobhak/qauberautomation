package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingx on 1/18/2017.
 */
public class AdminUserManageUserForEntitiesAssignedTo extends PageObjectModelResources {
    private int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
//        testConfig().getTestRail().setCaseID(79853); //TestRail case ID
//        testConfig().getTestRail().setTester("Erik's Script"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void adminUserManageUserForEntitiesAssignTo() throws InterruptedException {
        List<String> notassginedorglist = new ArrayList<String>();
        List<String> assginedorglist = new ArrayList<String>();
        List<String> orglistAU = new ArrayList<String>();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        setUpUser(User.UserType.AU); //change testUser to AU

        getNavBar().usersButton().click();
        Thread.sleep(sleepTime);

        getUsers().assignPermissionsButtonByEmail(testUser().getUsername()).click();
        Thread.sleep(sleepTime);

        outerloop:
        for (int row = 1; row <= getUsersPermissionsDialog().userRowList().size(); row++){          //start the loop with all row in user permission dialog;
            for (int i = 0; i <= 3; i++){                                                           // go 4 level depth of organization;
                try{
                    getUsersPermissionsDialog().verifyOrgDepthLevle(row, i);                        // find out the org exist or not at depth level i;
                    try{
                        getUsersPermissionsDialog().verifyUserAsAdminUser(row);                     // find out the user has been assigned as Admin User or not;
                        for (int j = row; j >= 1; j-- ){                                            // find out which org the Admin user is belonged to;
                            try{
                                Assert.assertEquals(true, getUsersPermissionsDialog().verifyOrgDepthLevle(j, 0).isDisplayed());
                                assginedorglist.add(getUsersPermissionsDialog().verifyOrgDepthLevle(j, 0).getText());
                                break;
                            }
                            catch(NoSuchElementException g){
                            }
                        }
                    }
                    catch(NoSuchElementException f){
                        break;      //break if depth level i is determined and not an amdin user;
                    }
//                    break;  // break if depth level i is determined
                }
                catch(NoSuchElementException e){
                }
            }
        }
        Thread.sleep(sleepTime);

        for (int j = 0; j < assginedorglist.size(); j++){
            System.out.println(assginedorglist.get(j));
        }

        for (int i = 0; i < getUsersPermissionsDialog().userEntitiesList().size(); i++){
            if (assginedorglist.contains(getUsersPermissionsDialog().userEntitiesList().get(i))){
                continue;
            } else {
                notassginedorglist.add(getUsersPermissionsDialog().userEntitiesList().get(i).getText());
            }
        }

        getEntitiesPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime);

        getProfilePanel().logOutButton().click();
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().usersButton().click();
        Thread.sleep(sleepTime);

        getUsers().assignPermissionsButtonByIndex(1).click();
        Thread.sleep(sleepTime);

        for (int i = 0; i < getUsersPermissionsDialog().userEntitiesList().size(); i++){
            orglistAU.add(getUsersPermissionsDialog().userEntitiesList().get(i).getText());
        }
        Thread.sleep(sleepTime);

        Assert.assertEquals(assginedorglist.size(), orglistAU.size());

        for (int i = 0; i < orglistAU.size(); i++){
            Assert.assertEquals(true, assginedorglist.contains(orglistAU.get(i)));
        }

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
