package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;


//Created by Denys_G on 12/22/2016.

public class UsersAssignPermissions extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testAsSAU() throws AWTException, InterruptedException {
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        assignPermissionsUsers();
    }
    @Test(priority = 1)
    public void testAsAU() throws AWTException, InterruptedException {
        setUpWithUser(User.UserType.AU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
        assignPermissionsUsers();
    }

    public void assignPermissionsUsers() throws InterruptedException, AWTException {
        int index = 2;
        /** NOTE: index in the list is different while logged in as different users*/
        driver.get(Config.getBaseURL());
        Thread.sleep(sleepTime/2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime/2);
        getNavBar().usersButton().click();
        Thread.sleep(sleepTime/2);
        getUsers().assignPermissionsButtonByIndex(index).click();
        Thread.sleep(sleepTime/8);
        getUsersPermissionsDialog().detachUserPermissions(index);
        Thread.sleep(sleepTime/8);
        getUsersPermissionsDialog().setUserAsAdmin(index);
        Thread.sleep(sleepTime/8);
        getUsersPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime/8);
    }

    @AfterTest
    public void breakDown(){
        breakDownHelper(driver);
    }
}
