package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jing Xu on 12/27/2016.
 */
public class RegularUserCannotReportNotAssignedEntitiesTestCase extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()

//        setUpWithUser(User.UserType.AU, driver);
    }

    @Test
    public void regularUserCannotReportNotAssginedEntities() throws InterruptedException, AWTException {
        String RUemail = "jing_qa_011010@mailinator.com";
        int totalrows;
        List<String> notassginedlist = new ArrayList<String>();


        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);

        getNavBar().usersButton().click();
        Thread.sleep(2000);

        getUsers().assignPermissionsButtonByEmail(RUemail).click();
        Thread.sleep(2000);

        List<WebElement> userentitieslist = getUsersPermissionsDialog().userEntitiesList();
        totalrows = userentitieslist.size();

        for (int i = 1; i <= totalrows; i++){
            try{
                driver.findElement(By.xpath("//tr[" + i + "][@ng-repeat='entity in entities']/td[@class='text-center'][1]//div[text()='Regular User']"));
            }
            catch (NoSuchElementException e) {
                notassginedlist.add(userentitieslist.get(i-1).getText());
            }
        }

        for (int j = 0; j < notassginedlist.size(); j++){
            System.out.println(notassginedlist.get(j));
        }

        getUsersPermissionsDialog().closeDialogByPressESC();
        Thread.sleep(2000);

        getHeader().userName().click();
        Thread.sleep(2000);

        getProfilePanel().logOutButton().click();
        Thread.sleep(2000);

        setUpWithUser(User.UserType.RU, driver);
        Thread.sleep(2000);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);

        getNavBar().addReportButton().click();
        Thread.sleep(2000);

        List<WebElement> reportentitieslist = getAddReportOrganization().entitiesList();
        Thread.sleep(2000);

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
        breakDownHelper(driver);
    }
}
