package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Created by Denys_G on 12/21/16.

public class DenysTestCase extends PageObjectModelResources {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
    }

    @Test
    public void assignPermissionsEntitiesSAU() throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(5000);

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);
        getNavBar().entitiesButton().click();
        Thread.sleep(2000);
        getEntities().assignPermissionButton(1).click();

        getAddReportOrganization().clickOrganization1();
        Thread.sleep(5000);




    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
