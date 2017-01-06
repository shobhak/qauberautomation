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

    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    private void ensureUserIsAdminInWithoutSetup(String userName, int entityIndex) throws InterruptedException, AWTException {

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


        Select Right = new Select(getEntitiesPermissionsDialog().rightDropdownList().get(userIndex-1));
        String text1 = Right.getFirstSelectedOption().getText();
        Assert.assertEquals(text1, "Admin");

        getEntitiesPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime);
        System.out.println("The user is an admin user in " + getEntities().organizationInfo(entityIndex).getText());
    }

    public void ensureUserIsAdminIn(String userName, int entityIndex) throws InterruptedException, AWTException {
        try {
            setUp();
            ensureUserIsAdminInWithoutSetup(userName, entityIndex);
        } finally {
            breakDown();
        }
    }

    private void ensureUserIsAdminInWithoutSetup(String userName, int entityIndex, int departmentIndex) throws InterruptedException, AWTException {
        ensureUserIsAdminInWithoutSetup(userName, entityIndex);

        getEntities().organizationInfo(entityIndex).click();
        Thread.sleep(sleepTime);

        getEntities().departmentAssignPermissionsButton(departmentIndex).click();
        Thread.sleep(sleepTime);

        Select RightDepartment = new Select(getEntitiesPermissionsDialog().rightDropdownList().get(userIndex-1));
        String text2 = RightDepartment.getFirstSelectedOption().getText();
        Assert.assertEquals(text2, "Admin");

        getEntitiesPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime);

        System.out.println("The user is an admin user in " + getEntities().departmentName(departmentIndex).getText());
    }

    public void ensureUserIsAdminIn(String userName, int entityIndex, int departmentIndex) throws InterruptedException, AWTException {
        try {
            setUp();
            ensureUserIsAdminInWithoutSetup(userName, entityIndex, departmentIndex);
        } finally {
            breakDown();
        }
    }
    private void ensureUserIsAdminInWithoutSetup(String userName, int entityIndex, int departmentIndex, int subDepartmentIndex) throws InterruptedException, AWTException {
            ensureUserIsAdminInWithoutSetup(userName, entityIndex, departmentIndex);

            getEntities().departmentName(departmentIndex).click();
            Thread.sleep(sleepTime);

            getEntities().subdepartmentAssignPermissionsButton(subDepartmentIndex).click();
            Thread.sleep(sleepTime);

            Select RightSubDepartment = new Select(getEntitiesPermissionsDialog().rightDropdownList().get(userIndex-1));
            String text3 = RightSubDepartment.getFirstSelectedOption().getText();
            Assert.assertEquals(text3, "Admin");

            getEntitiesPermissionsDialog().closeDialogByPressESC();
            Thread.sleep(sleepTime);

        System.out.println("The user is an admin user in " + getEntities().subdepartmentName(subDepartmentIndex).getText());
    }

    public void ensureUserIsAdminIn(String userName, int entityIndex, int departmentIndex, int subDepartmentIndex) throws InterruptedException, AWTException {
    try {
        setUp();
        ensureUserIsAdminInWithoutSetup(userName, entityIndex, departmentIndex, subDepartmentIndex);
        } finally {
        breakDown();
        }
    }

    public void breakDown(){ breakDownHelper(); }
}
