package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lenochka on 27.12.2016.
 */
public class UserDeletionTestCase extends PageObjectModelResources {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
    }


    @Test
    public void userDeletion() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(Config.getBaseURL());
        Thread.sleep(3000);

        String emailName = "kennith.willms@hotmail.com";


        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(3000);

        getNavBar().clickUsers();
        Thread.sleep(3000);

        getUserDeletion().deleteUserByEmail(emailName).click();
        Thread.sleep(3000);

        getUserDeletion().deleteConfirmationButton().click();
        Thread.sleep(3000);

            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }