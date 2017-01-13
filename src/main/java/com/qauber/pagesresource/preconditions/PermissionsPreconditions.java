package com.qauber.pagesresource.preconditions;

import com.qauber.pagesresource.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Denys_G on 1/9/2017.
 */
public class PermissionsPreconditions extends PageObjectModelResources {

    int sleepTime;

    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user
        testConfig().setBrowserType(ConfigOOP.BrowserType.CHROME);
        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    public void ensureAUIsAdminAllEntities() {
        setUp();
        try { //TRY WITH RESOURCES - when try completes, 'finally' will run: even if 'try'  throws an exception
            testDriver().get(testConfig().getBaseURL());
            Thread.sleep(sleepTime/2);

            getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
            Thread.sleep(sleepTime/2);
            System.out.println("To meet preconditions Logged in as "+testUser().getUserType()+"  "+testUser().getUsername());

            setAUasAdminToAllEntities(testDriver());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally { breakDown(); } //breakdown
    }
    public void setAUasAdminToAllEntities(WebDriver driver) throws InterruptedException {
        PageResources page = PageResourcesFactory.getPageResources(driver);
        page.getNavBar().usersButton().click();
        Thread.sleep(sleepTime/8);

        UserFactory userFactory = new UserFactory();
        User au = userFactory.getUser(User.UserType.AU);
        String  AUemail =   au.getUsername().toLowerCase();
        page.getUsers().assignPermissionsButtonByEmail(AUemail).click();
        Thread.sleep(sleepTime/6);

        for (int i = 1; i <= page.getUsersPermissionsDialog().userEntitiesList().size(); i++){
            WebElement detachButt = page.getUsersPermissionsDialog().detachButtonByEntity(i);
            if (detachButt.isDisplayed()){
                detachButt.click();
            }
            else{
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", detachButt);
                detachButt.click();}
            page.getUsersPermissionsDialog().dropDownListByEntity(i).selectByVisibleText("Admin");
            Thread.sleep(sleepTime/12);
            page.getUsersPermissionsDialog().saveButtonByEntity(i).click();
            Thread.sleep(sleepTime/8);
            Assert.assertEquals(page.getUsersPermissionsDialog().rightsSavedByEntity(i).getText(), "Admin");
        }

    }
    public void ensureRUisRegUserToAll() {
        setUp();
        try { //TRY WITH RESOURCES - when try completes, 'finally' will run: even if 'try'  throws an exception
            testDriver().get(testConfig().getBaseURL());
            Thread.sleep(sleepTime/2);

            getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
            Thread.sleep(sleepTime/2);
            System.out.println("To meet preconditions Logged in as "+testUser().getUserType()+"  "+testUser().getUsername());

            setRUasRegUserToAll(testDriver());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally { breakDown(); } //breakdown
    }
    public void setRUasRegUserToAll(WebDriver driver) throws InterruptedException {
        PageResources page = PageResourcesFactory.getPageResources(driver);
        Thread.sleep(sleepTime/4);
        page.getNavBar().usersButton().click();
        Thread.sleep(sleepTime/8);

        UserFactory userFactory = new UserFactory();
        User au = userFactory.getUser(User.UserType.RU);
        String  RUemail =   au.getUsername().toLowerCase();
        page.getUsers().assignPermissionsButtonByEmail(RUemail).click();
        Thread.sleep(sleepTime/6);

        for (int i = 1; i <= page.getUsersPermissionsDialog().entitiesDepSubdepsAllList().size(); i++){
            WebElement detachButt = page.getUsersPermissionsDialog().detachButtonByTR(i);
            if (detachButt.isDisplayed()){
                detachButt.click();
            }
            else{
                ((JavascriptExecutor)testDriver()).executeScript("arguments[0].scrollIntoView(true);", detachButt);
                detachButt.click();}
            Thread.sleep(sleepTime/12);
            page.getUsersPermissionsDialog().dropdownMenuTR(i).selectByVisibleText("Regular User");
            Thread.sleep(sleepTime/12);
            page.getUsersPermissionsDialog().saveButtonByTR(i).click();
            Thread.sleep(sleepTime/10);
            Assert.assertEquals(page.getUsersPermissionsDialog().rightsSavedTR(i).getText(), "Regular User");
        }

    }

    public void breakDown() {
        breakDownHelper();
    }

}
