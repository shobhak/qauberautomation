package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by San Jose on 12/22/16.
 * TODO: add to TestRail
 */
public class Create_SubDepartment_AU extends PageObjectModelResources {

    int sleepTime;

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
    public void createSubDepartmentAU() throws InterruptedException{
        getDriver().get(testConfig().getBaseURL());
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
        Thread.sleep(sleepTime);

//        actualResult, expectedResult
        Thread.sleep(sleepTime/2);
        int lastIndex = getEntities().subdepartmentNameList().size()-1;
        actualResult = getEntities().subdepartmentNameList().get(lastIndex).getText();
        Assert.assertEquals(expectedResult, actualResult);


    }

    @AfterClass
    public void breakDown(){
      breakDownHelper();
    }
}
