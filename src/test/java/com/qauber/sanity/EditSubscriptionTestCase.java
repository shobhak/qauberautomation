package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Jing Xu on 12/29/2016.
 * TODO: write a PayPal helper class to replace hardcoded Paypal code... let's not have driver.findElement anywhere in test case :-)
 * TODO: TestRail integration
 * TODO: check for (pre)condition, run as needed?
 */
public class EditSubscriptionTestCase extends PageObjectModelResources {
    int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
//        testConfig().getTestRail().setCaseID(79853); //sample TestRail case ID,
//        testConfig().getTestRail().setTester("Erik's Script"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();    }

    @Test
    public void editSubscription() throws InterruptedException {
        int entitiesnumber;
        int editentityindex;
        int newusersnumber;
        int currentusernumber;
        Random randomInt = new Random();
        String paypalsandboxemail = "jing_qauber_test01@test.com";
        String paypalsandboxpassword = "portnovschool";

        getDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime/2);

        try{
            Assert.assertEquals(getProfilePanel().subscriptionsText().getText(), "SUBSCRIPTIONS");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);
        }

        entitiesnumber = getProfilePanel().entitiesList().size();
        editentityindex = randomInt.nextInt(entitiesnumber) + 1;
        currentusernumber = Integer.parseInt(getProfilePanel().organizationLink(editentityindex).getText());
        System.out.println(currentusernumber);
        getProfilePanel().organizationLink(editentityindex).click();
        Thread.sleep(sleepTime/2);

        newusersnumber = 5 + randomInt.nextInt(36);
        System.out.println(newusersnumber);

        getSubscriptionSettings().slider(newusersnumber);
        Thread.sleep(sleepTime/2);

        getSubscriptionSettings().changeSubscritionButton().click();
        Thread.sleep(sleepTime*2);

        //working on paypal sandbox web pages
        testDriver().findElement(By.xpath("//input[@id='loadLogin']")).click();
        Thread.sleep(sleepTime);

        testDriver().findElement(By.xpath("//*[@id='login_email']")).clear();
        Thread.sleep(sleepTime/10);
        testDriver().findElement(By.xpath("//*[@id='login_email']")).sendKeys(paypalsandboxemail);
        Thread.sleep(sleepTime/5);

        testDriver().findElement(By.xpath("//*[@id='login_password']")).clear();
        Thread.sleep(sleepTime/10);
        testDriver().findElement(By.xpath("//*[@id='login_password']")).sendKeys(paypalsandboxpassword);
        Thread.sleep(sleepTime/5);

        testDriver().findElement(By.xpath("//*[@id='submitLogin']")).click();
        Thread.sleep(sleepTime*2);

        testDriver().findElement(By.xpath("//*[@value='Agree and Continue']")).click();
        Thread.sleep(sleepTime/20);

        getHeader().userName().click();
        Thread.sleep(sleepTime/2);

        getProfilePanel().settinsButton().click();
        Thread.sleep(sleepTime/2);

        try{
            Assert.assertEquals(getProfilePanel().subscriptionsText().getText(), "SUBSCRIPTIONS");
        }
        catch (NoSuchElementException e) {
            getHeader().userName().click();
            Thread.sleep(sleepTime/2);
        }

        Assert.assertEquals(newusersnumber, Integer.parseInt(getProfilePanel().organizationLink(editentityindex).getText()));

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
