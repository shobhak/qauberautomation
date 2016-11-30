package com.qauber.register;


import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Mariia on 11/29/2016.
 */
public class CopyrightIsPresentOnRegistrationPage {
    APIClientExtension client;
    int runid = Config.getRunID(); //Test Run ID (TestRail - Test Runs & Results - Automation)
    int caseid = 74298;

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

        //Check year Symbol is Present on the page.

        String year = "";
        year = driver.findElement(By.xpath("//span[@ng-bind='app.year']")).getText();
        Assert.assertEquals(year, "2016");
        Thread.sleep(6000);


        //Check Copyright symbol present
        String Copyright = "";
        Copyright = driver.findElement(By.xpath("//span[contains(.,'©')]")).getText();
        Assert.assertEquals(Copyright, "©");

        //Check App name is present on the page.
        String App = "";
        App = driver.findElement(By.xpath("//span[@ng-bind='app.name']")).getText();
        Assert.assertEquals(App, "FITS");

        //Check Copyright name is present on the page
        String WebApp = "";
        WebApp = driver.findElement(By.xpath("//span[@ng-bind='app.description']")).getText();
        Assert.assertEquals(WebApp, "FITS Web Application");
        Thread.sleep(6000);


        //System.out.println(ActualResult);
        try {
            org.testng.Assert.assertEquals(Copyright,  "©");
            org.testng.Assert.assertEquals(App,  "FITS");
            org.testng.Assert.assertEquals(year, "2016");
            org.testng.Assert.assertEquals(WebApp,  "FITS Web Application");

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
