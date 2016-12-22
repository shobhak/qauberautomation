package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.awt.*;

//Created by Denys_G on 12/21/16.

public class EntitiesAssignPermissions extends PageObjectModelResources {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testAsSAU() throws AWTException, InterruptedException {
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
        assignPermissionsEntities();
    }
    @Test(priority = 1)
    public void testAsAU() throws AWTException, InterruptedException {
        setUpWithUser(User.UserType.AU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
        assignPermissionsEntities();
    }

    public void assignPermissionsEntities() throws InterruptedException, AWTException {
        driver.get(Config.getBaseURL());
        Thread.sleep(2000);
        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(2000);
        getNavBar().entitiesButton().click();
        Thread.sleep(2000);
        getEntities().assignPermissionButton(1).click();
        Thread.sleep(500);
        getEntitiesPermissionsDialog().detachUserPermissions(1);
        Thread.sleep(300);
        getEntitiesPermissionsDialog().setUserAsRegularUser(1);
        Thread.sleep(300);
        getEntitiesPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(500);
    }

    @AfterTest
    public void breakDown(){
        breakDownHelper(driver);
    }
}
