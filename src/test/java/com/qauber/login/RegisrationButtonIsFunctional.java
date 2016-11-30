package com.qauber.login;

import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisrationButtonIsFunctional {

    int caseid = 74284;
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
        driver.manage().window().maximize();
        //Open Home page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(10000);
        // Click on "Register now"
        driver.findElement(By.xpath("//a[@ui-sref='page.register-sa']")).click();
        Thread.sleep(6000);


       boolean ActualResult= driver.findElement(By.xpath("//button[@class='btn btn-defalt login-form-btn-fb']")).isDisplayed();
        System.out.println(ActualResult);
       try {
            Assert.assertEquals(ActualResult, true);
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
