package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jing Xu on 12/27/2016.
 * TODO: add to TestRail
 * TODO: add some precondition / helper methods? believe this will fail if RU is assigned to all entities (as expected).
 */
public class RegularUserCannotReportNotAssignedEntitiesTestCase extends PageObjectModelResources {
    private int sleepTime;

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
    public void regularUserCannotReportNotAssginedEntities() throws InterruptedException, AWTException {
        int totalrows;
        int orgRow = 0;
        List<String> notassginedlist = new ArrayList<String>();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        setUpUser(User.UserType.RU); //change testUser to RU

        getNavBar().usersButton().click();
        Thread.sleep(sleepTime);

        getUsers().assignPermissionsButtonByEmail(testUser().getUsername()).click();
        Thread.sleep(sleepTime);

        List<WebElement> userentitieslist = getUsersPermissionsDialog().userEntitiesList();
        totalrows = getUsersPermissionsDialog().userRowList().size();

        for (int i = 1; i <= totalrows; i++){
            try{
                Assert.assertNotEquals(true, getUsersPermissionsDialog().organizationByRow(i).isDisplayed());
            }
            catch (AssertionError d){
                try{
                    orgRow++;
                    testDriver().findElement(By.xpath("//tr[" + i + "][@ng-repeat='entity in entities']/td[@class='text-center'][1]//div[text()='Admin']"));
                }
                catch (NoSuchElementException e) {
                    try{
                        testDriver().findElement(By.xpath("//tr[" + i + "][@ng-repeat='entity in entities']/td[@class='text-center'][1]//div[text()='Regular User']"));
                    }
                    catch (NoSuchElementException f) {
                        notassginedlist.add(userentitieslist.get(orgRow - 1).getText());;
                    }
                }
            }
            catch (NoSuchElementException e){
                System.out.println("This row is not an organization!");
            }
        }
        Thread.sleep(sleepTime);

        for (int j = 0; j < notassginedlist.size(); j++){
            System.out.println(notassginedlist.get(j));
        }
        Thread.sleep(sleepTime);

        getUsersPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime);

        getProfilePanel().logOutButton().click();
        Thread.sleep(sleepTime);

//        setUpUser(User.UserType.RU);
//        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().addReportButton().click();
        Thread.sleep(sleepTime);

        List<WebElement> reportentitieslist = getAddReportOrganization().entitiesList();
        Thread.sleep(sleepTime);

        for (int x = 0; x < reportentitieslist.size(); x++){
            for (int y = 0; y < notassginedlist.size(); y++) {
                System.out.println(reportentitieslist.get(x).getText());
                System.out.println(notassginedlist.get(y));
                Assert.assertNotEquals(reportentitieslist.get(x).getText(), notassginedlist.get(y));
            }
        }

    }
    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
