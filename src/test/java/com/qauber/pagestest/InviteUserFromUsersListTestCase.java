package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Jing Xu on 12/27/2016.
 */
public class InviteUserFromUsersListTestCase extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
     //   setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()

        setUpWithUser(User.UserType.AU, driver);
    }

    @Test
    public void inviteUserFromUsersList() throws InterruptedException {
        String AUemail = "jing_qa_0110@mailinator.com";         // admin user email address
        String RUemail = "jing_qa_011010@mailinator.com";       // regular user email address

        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);

        getNavBar().usersButton().click();
        Thread.sleep(5000);

        getUsers().inviteUserButton().click();
        Thread.sleep(2000);

     //   getUsers().inviteUserEmailField().sendKeys(AUemail);
        getUsers().inviteUserEmailField().sendKeys(RUemail);
        Thread.sleep(2000);

        getUsers().cancelButton().click();
        Thread.sleep(2000);

        getUsers().inviteUserButton().click();
        Thread.sleep(2000);

     //   getUsers().inviteUserEmailField().sendKeys(AUemail);
        getUsers().inviteUserEmailField().sendKeys(RUemail);
        Thread.sleep(2000);

        getUsers().sendInviteButton().click();
        Thread.sleep(5000);


    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
