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

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testAsSAU() throws AWTException, InterruptedException {
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
        assignPermissionsUsers();
    }
    @Test(priority = 1)
    public void testAsAU() throws AWTException, InterruptedException {
        setUpWithUser(User.UserType.AU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
        assignPermissionsUsers();
    }

    public void assignPermissionsUsers() throws InterruptedException, AWTException {
        driver.get(Config.getBaseURL());
        Thread.sleep(2000);
        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(2000);
        getNavBar().usersButton().click();
        Thread.sleep(2000);
        getUsers().assignPermissionsButtonByIndex(1).click();
        Thread.sleep(500);
        getUsersPermissionsDialog().detachUserPermissions(1);
        Thread.sleep(300);
        getUsersPermissionsDialog().setUserAsAdmin(1);
        Thread.sleep(300);
        getUsersPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(500);
    }

    @AfterTest
    public void breakDown(){
        breakDownHelper(driver);
    }
}
