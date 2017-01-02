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
 * Created by erikfriedlander on 12/19/16.
 */
public class CreateSubscriptionPayPalTestcase extends PageObjectModelResources {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
    }

    @Test
    public void simpleSampleTestCase() throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(10000);

        getNavBar().entitiesButton().click();
        Thread.sleep(8000);

        getEntities().finishCreateOrganizationButton(6).click();
        Thread.sleep(5000);

        getCreateSubsciption().finishButton().click();
        Thread.sleep(10000);

        String currentURL = driver.getCurrentUrl();

        System.out.println(currentURL);
        Thread.sleep(10000);

        getCreateSubsciption().payWithMyPayPal().click();
        Thread.sleep(3000);

        getCreateSubsciption().loginField().sendKeys("lalalala1@gmail.com");
        Thread.sleep(3000);

        getCreateSubsciption().passwordField().sendKeys("lalalala");
        Thread.sleep(3000);

        getCreateSubsciption().logInButton().click();
        Thread.sleep(6000);

        getCreateSubsciption().agreeAndContinueButton().click();
        Thread.sleep(6000);
    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
