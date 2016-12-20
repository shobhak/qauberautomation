package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maksim on 12/19/2016.
 *
 */
public class SubscriptionSettingsTest {

    WebDriver driver;

    LoginPage login;
    ProfilePanel panel;
    Header header;
    SubscriptionSettings settings;


    @BeforeTest
    public void SetUp() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(Config.getBaseURL());

        driver.manage().window().maximize();

        login = new LoginPage(driver);

        Thread.sleep(1000);
        login.loginToWave("raizzz.test@gmail.com", "013666");

    }

    @Test
    public void Search() throws InterruptedException {

        header = new Header(driver);
        settings = new SubscriptionSettings(driver);
        panel = new ProfilePanel(driver);

        // open profile panel
        Thread.sleep(1000);
        header.userName().click();

        // click on second organization in list
        Thread.sleep(1000);
        panel.settinsButton().click();
        panel.organizationLink(2).click();

        // close Subscription Settings
        Thread.sleep(1000);
        settings.closeButton().click();

        Thread.sleep(1000);
        header.userName().click();

        Thread.sleep(1000);
        panel.organizationLink(2).click();

        // Move slider to chosen position
        Thread.sleep(500);
        settings.slider(22);

        Thread.sleep(5000);
    }

    @AfterTest

    public void CloseBrowser() throws InterruptedException
    {
        Thread.sleep(5000);
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}