package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.Header;
import com.qauber.pages.LoginPage;
import com.qauber.pages.ProfilePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


//Created by Denys_G on 12/15/2016.

public class EditProfileUserName {

    WebDriver driver = new ChromeDriver();
    LoginPage login  = new LoginPage(driver);
    Header header = new Header(driver);
    ProfilePanel profilePanel = new ProfilePanel(driver);
    com.qauber.pages.EditProfile editProfile = new com.qauber.pages.EditProfile(driver);
    String newName = "New Name";

    @Test
    public void profileEdit() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.getBaseURL());
        Thread.sleep(2500);
        login.loginToWave("wave2@mailinator.com", "111111");

        header.userName().click();
        Thread.sleep(500);
        Assert.assertTrue(profilePanel.logOutButton().isDisplayed());
        profilePanel.editProfileButton().click();


        editProfile.nameField().clear();
        editProfile.nameField().sendKeys(newName);
        editProfile.UpdateButton().click();
        Thread.sleep(500);
        Assert.assertEquals((editProfile.nameField().getAttribute("value")), newName);


        header.userName().click();
        Thread.sleep(500);
        Assert.assertTrue(profilePanel.logOutButton().isDisplayed());
        profilePanel.logOutButton().click();


    }
    @BeforeClass
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void breakDown () throws InterruptedException {
        //Thread.sleep(10000); //This is for demonstration purposes only, so the page does not close immediately
        driver.quit();
    }

}
