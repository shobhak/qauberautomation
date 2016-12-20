package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenochka on 15.12.2016.
 */
public class UsersTestCase {

    WebDriver driver;
    LoginPage login;
    NavBar navBar;
    Users users;


    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //pull URL from config
        driver.get(Config.getBaseURL());

        //maximize window for our viewing pleasure
        driver.manage().window().maximize();
    }

    @Test
    public void UsersTestCase() throws InterruptedException {

        //Create Login Page Object
        login = new LoginPage(driver);
        navBar = new NavBar(driver);
        //usersNavBar = new UsersNavBar(driver);
        users = new Users(driver);

        /*Verify Login Footer Text (so we're on right page)
        String loginPageFooterText = login.getLoginFooterText();
        Assert.assertEquals(loginPageFooterText, "© 2016 - FITS\n" + "FITS Web Application");
        Thread.sleep(3000);*/

        //Log in to application
        Thread.sleep(5000);
        login.loginToWave("erikfqauber@gmail.com", "testwave");
        Thread.sleep(5000);

        // Click on Users button
       navBar.usersButton().click();
        Thread.sleep(3000);


        //Click on Invite user button
        users.inviteUserButton().click();
        Thread.sleep(3000);

        //Click on Enter email field
        users.inviteUserEmailField().sendKeys("mail@mail.za");
        Thread.sleep(3000);

        //Click on SendInviteButton
        users.sendInviteButton().click();
        Thread.sleep(3000);

    }


    @AfterClass
    public void breakDown () throws InterruptedException {

        Thread.sleep(10000);

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}


