package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Jing Xu on 12/29/2016.
 */
public class EditSubscriptionTestCase extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
    }

    @Test
    public void editSubscription() throws InterruptedException {
        int entitiesnumber;
        int editentityindex;
        int newusersnumber;
        int currentusernumber;
        Random randomInt = new Random();
        String paypalsandboxemail = "jing_qauber_test01@test.com";
        String paypalsandboxpassword = "portnovschool";

        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);

        getHeader().userName().click();
        Thread.sleep(2000);

        getProfilePanel().settinsButton().click();
        Thread.sleep(2000);

        try{
            Assert.assertEquals(getProfilePanel().subscriptionsText().getText(), "SUBSCRIPTIONS");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(2000);
        }

        entitiesnumber = getProfilePanel().entitiesList().size();
        editentityindex = randomInt.nextInt(entitiesnumber) + 1;
        currentusernumber = Integer.parseInt(getProfilePanel().organizationLink(editentityindex).getText());
        System.out.println(currentusernumber);
        getProfilePanel().organizationLink(editentityindex).click();
        Thread.sleep(2000);

        newusersnumber = 5 + randomInt.nextInt(36);
        System.out.println(newusersnumber);

        getSubscriptionSettings().sliderByPercent(newusersnumber);
        Thread.sleep(2000);

        getSubscriptionSettings().changeSubscritionButton().click();
        Thread.sleep(10000);

        //working on paypal sandbox web pages
        driver.findElement(By.xpath("//input[@id='loadLogin']")).click();
        Thread.sleep(6000);

        driver.findElement(By.xpath("//*[@id='login_email']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='login_email']")).sendKeys(paypalsandboxemail);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='login_password']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys(paypalsandboxpassword);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='submitLogin']")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@value='Agree and Continue']")).click();
        Thread.sleep(20000);

        getHeader().userName().click();
        Thread.sleep(2000);

        getProfilePanel().settinsButton().click();
        Thread.sleep(2000);

        try{
            Assert.assertEquals(getProfilePanel().subscriptionsText().getText(), "SUBSCRIPTIONS");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(2000);
        }

        Assert.assertEquals(newusersnumber, Integer.parseInt(getProfilePanel().organizationLink(editentityindex).getText()));

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
