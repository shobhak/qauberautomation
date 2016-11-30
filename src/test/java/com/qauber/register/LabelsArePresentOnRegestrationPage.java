package com.qauber.register;


import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LabelsArePresentOnRegestrationPage {
    APIClientExtension client;
    int runid = Config.getRunID(); //Test Run ID (TestRail - Test Runs & Results - Automation)
    int caseid = 74300;

    @BeforeClass
    public void setUp() {

        client = Config.testRailLogin();

    }

    @Test
    public void StartWebDriver() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Home page

        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);

        // Click on "Register now"
        driver.findElement(By.xpath("//a[@ui-sref='page.register-sa']")).click();
        Thread.sleep(6000);

        //Check the "name" labels is present
        String Name = "";
        Name = driver.findElement(By.xpath("//label[contains(.,'Name')]")).getText();
        Assert.assertEquals(Name, "Name");
        Thread.sleep(2000);

        //Check the "email" labels is present
        String email = "";
        email = driver.findElement(By.xpath("//label[contains(.,'Email address')]")).getText();
        Assert.assertEquals(email, "Email address");
        Thread.sleep(2000);

        //Check the "password" labels is present
        String Password = "";
        Password = driver.findElements(By.xpath("//label[contains(.,'Password')]")).get(0).getText();
        Assert.assertEquals(Password, "Password");

        //Check the "Retype password" labels is present
        String RetypePassword = "";
        RetypePassword = driver.findElement(By.xpath("//label[contains(.,'Retype Password')]")).getText();
        Assert.assertEquals(RetypePassword, "Retype Password");
        Thread.sleep(2000);

        //System.out.println(ActualResult);
        try {
            org.testng.Assert.assertEquals(Name,  "Name");
            org.testng.Assert.assertEquals(email,  "Email address");
            org.testng.Assert.assertEquals(Password, "Password");
            org.testng.Assert.assertEquals(RetypePassword,  "Retype Password");

        } catch (AssertionError e) { //on fail, run this
            try {
                client.addResult(runid, caseid, 5, e.getLocalizedMessage(), "Mariia's Computer");
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

        driver.quit();
    }

}

