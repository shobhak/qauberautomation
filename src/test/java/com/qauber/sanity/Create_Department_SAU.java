package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by San Jose on 12/22/16.
 */
public class Create_Department_SAU extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        sleepTime = 5000;
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
    }

    @Test
    public void createDepartmentSAU() throws InterruptedException{
        driver.get(Config.getBaseURL());
        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(sleepTime);
        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime);
        getEntities().organizationList().get(1).click();
        Thread.sleep(sleepTime);
//        getOrganization().


    }







    @AfterClass
    public void breakDown(){
//        breakDownHelper(driver);
    }
    //        driver.quit();
}
