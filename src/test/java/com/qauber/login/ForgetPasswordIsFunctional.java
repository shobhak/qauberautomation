package com.qauber.login;

import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgetPasswordIsFunctional {
    int caseid = 74289;
    String ActualResult = "";
    APIClientExtension client;
    int runid = Config.getRunID(); //Test Run ID (TestRail - Test Runs & Results - Automation)

    @BeforeClass
    public void setUp() {

        client = Config.testRailLogin();
    }

    @Test
    public void StartWebDriver() throws InterruptedException {

       WebDriver driver = new ChromeDriver();
        //Sring for page Title
        String ntitle;

        // Maximize the browser window
        driver.manage().window().maximize();
        //Open Home page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);

        //Click on "Forget password" button
        driver.findElement(By.xpath("//a[@class='text-muted']")).click();
        Thread.sleep(5000);

        String email = "935bckxjfja@mailinator.com";
        //Enter exist email in email field
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        Thread.sleep(5000);
        //Click Reset password
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block mb-lg']")).click();
        Thread.sleep(5000);

        //check for the "Sent letter" message is displaying
        String SentMessage = "";
        SentMessage = driver.findElement(By.xpath("//div[@class='alert alert-success text-center ng-binding']")).getText();

        //check the "Sent letter" message is there
        Assert.assertEquals(SentMessage, "Reset password email sent.");
        Thread.sleep(10000);

        // Go on Mailinator.com to activate account
        driver.get("https://www.mailinator.com/");
        Thread.sleep(5000);
        // enter name of registered email
        driver.findElement(By.xpath("//input[@id='inboxfield']")).sendKeys(email);
        Thread.sleep(3000);
        //Click Go button
        driver.findElement(By.xpath("//button[@class='btn btn-dark']")).click();
        Thread.sleep(8000);
        //Open the the letter
        driver.findElement(By.xpath("//div[contains(@style,'width:100')][./div/div[contains(text(),'Reset Password')]]")).click();
        Thread.sleep(6000);
        //Switch frame
        driver.switchTo().frame("publicshowmaildivcontent");
        //Click on the link
        driver.findElement(By.xpath("//a[@rel='nofollow']")).click();
        Thread.sleep(15000);
        String parentHandle = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String pw = "mbtest2525";
        //Enter password
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(pw);
        Thread.sleep(3000);
        //Retype password
        driver.findElement(By.xpath("//input[@name='password_confirm']")).sendKeys(pw);
        Thread.sleep(6000);

        //click on Change password button
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(6000);

        /*Enter email in "Login" field
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);

        //Enter new password in "Password" field
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(pw);
        Thread.sleep(2000);
        //Click Login button
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(6000);*/

        ActualResult = driver.findElement(By.xpath("//p[contains(.,'Need to Sign Up?')]")).getText();
        System.out.println(ActualResult);

        // If need to check that user can login with new password, than use:
        //ActualResult = driver.findElement(By.xpath("//h3[@class='ng-scope']")).getText();
        //System.out.println(ActualResult);
        
        try {
            //org.testng.Assert.assertEquals(ActualResult, "Reports");
            org.testng.Assert.assertEquals(ActualResult, "Need to Sign Up?");
        } catch (AssertionError e) { //on fail, run this
            try {
                client.addResult(528, 74289, 5, e.getLocalizedMessage(), "Mariia's Computer");
                throw e; //Throwing AssertionError
            } catch (IllegalStateException g) {
                g.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("General Exception in assertEquals");
            e.printStackTrace();

        }

        //If Assert passes, send this to TestRail
        client.addResult(runid, caseid, 1, "Actual value = expected value", "Mariia's Computer");


        driver.close();
        driver.switchTo().window(parentHandle);

        driver.manage().deleteAllCookies();


        driver.quit();
    }
}
