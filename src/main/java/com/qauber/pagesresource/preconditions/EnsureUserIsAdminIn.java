package com.qauber.pagesresource.preconditions;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

/**
 * Created by jingx on 1/4/2017.
 */
public class EnsureUserIsAdminIn extends PageObjectModelResources {
    int sleepTime;
    int userIndex;
    boolean alreadySetUp;

    public EnsureUserIsAdminIn() {
        this.alreadySetUp = false;
    }

    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();

        alreadySetUp = true;
    }

    public void ensureUserIsAdminIn(String userName, int entityIndex) throws InterruptedException, AWTException {
//        userName = "Jing_qa_0111";
//        entityIndex = 1;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(2000);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);

        getNavBar().entitiesButton().click();
        Thread.sleep(5000);

        getEntities().assignPermissionButton(entityIndex).click();
        Thread.sleep(2000);

        userIndex = getEntitiesPermissionsDialog().findingUserIndex(userName);
        System.out.println(userIndex);
        Thread.sleep(2000);


        Select Right = new Select(testDriver().findElements(By.xpath("//td/select")).get(userIndex-1));
        String text1 = Right.getFirstSelectedOption().getText();
        Assert.assertEquals(text1, "Admin");

        getEntitiesPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime);
    }

    public void ensureUserIsAdminIn(String userName, int entityIndex, int departmentIndex) throws InterruptedException, AWTException {
        ensureUserIsAdminIn(userName, entityIndex);

        getEntities().departmentName(departmentIndex).click();
        Thread.sleep(sleepTime);

        Select Right = new Select(testDriver().findElements(By.xpath("//td/select")).get(userIndex-1));
        String text1 = Right.getFirstSelectedOption().getText();
        Assert.assertEquals(text1, "Admin");

        getEntitiesPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime);
    }

    public void ensureUserIsAdminIn(String userName, int entityIndex, int departmentIndex, int subDepartmentIndex) throws InterruptedException, AWTException {
        try {
            if(!alreadySetUp) { setUp(); }
            ensureUserIsAdminIn(userName, entityIndex, departmentIndex);

            getEntities().subdepartmentName(subDepartmentIndex).click();
            Thread.sleep(sleepTime);

            Select Right = new Select(testDriver().findElements(By.xpath("//td/select")).get(userIndex-1));
            String text1 = Right.getFirstSelectedOption().getText();
            Assert.assertEquals(text1, "Admin");

            getEntitiesPermissionsDialog().closeDialogByPressESC();
            Thread.sleep(sleepTime);
        } finally {
            breakDown();
        }

    }


    public void breakDown(){
        alreadySetUp = false;
        breakDownHelper();
    }
}
