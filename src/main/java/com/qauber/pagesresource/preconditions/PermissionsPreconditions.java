package com.qauber.pagesresource.preconditions;

import com.qauber.pagesresource.*;
import org.openqa.selenium.JavascriptExecutor;
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

            getNavBar().usersButton().click();
            Thread.sleep(sleepTime/8);

            UserFactory userFactory = new UserFactory();
            User au = userFactory.getUser(User.UserType.AU);
            String  AUemail =   au.getUsername().toLowerCase();
            getUsers().assignPermissionsButtonByEmail(AUemail).click();
            Thread.sleep(sleepTime/6);

            for (int i = 1; i <= getUsersPermissionsDialog().userEntitiesList().size(); i++){
                WebElement detachButt = getUsersPermissionsDialog().detachButtonByEntity(i);
                if (detachButt.isDisplayed()){
                    detachButt.click();
                }
                else{
                    ((JavascriptExecutor)testDriver()).executeScript("arguments[0].scrollIntoView(true);", detachButt);
                    detachButt.click();}
                getUsersPermissionsDialog().dropDownListByEntity(i).selectByVisibleText("Admin");
                Thread.sleep(sleepTime/12);
                getUsersPermissionsDialog().saveButtonByEntity(i).click();
                Thread.sleep(sleepTime/8);
                Assert.assertEquals(getUsersPermissionsDialog().rightsSavedByEntity(i).getText(), "Admin");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally { breakDown(); } //breakdown
    }

    public void breakDown() {
        breakDownHelper();
    }

}
