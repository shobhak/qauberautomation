package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by San Jose on 12/22/16.
 */
public class Create_SubDepartment_SAU extends PageObjectModelResources {

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
    public void createSubDepartmentSAU() throws InterruptedException{
        driver.get(Config.getBaseURL());
        Faker faker = new Faker();

        String expectedResult = faker.lorem().word(); //subdepartment name
        String actualResult;

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime);
        getEntities().organizationList().get(0).click();
        Thread.sleep(sleepTime);
        getEntities().departmentNameList().get(0).click();
        Thread.sleep(sleepTime);
        getEntities().addSubdepartmentButton().click();
        Thread.sleep(sleepTime);
        getEntities().addSubdepartmentField().sendKeys(expectedResult);
        getEntities().CreatDepartmentButton().click();

//        actualResult, expectedResult
        Thread.sleep(2000);
        int lastIndex = getEntities().subdepartmentNameList().size()-1;
        actualResult = getEntities().subdepartmentNameList().get(lastIndex).getText();
        Assert.assertEquals(expectedResult, actualResult);


    }

    @AfterClass
    public void breakDown(){
  //      breakDownHelper(driver);
    }
   // driver.quit();
}
