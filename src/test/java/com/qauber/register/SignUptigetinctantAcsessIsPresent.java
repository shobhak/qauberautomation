package com.qauber.register;

import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SignUptigetinctantAcsessIsPresent {
    APIClientExtension client;
    int runid = Config.getRunID(); //Test Run ID (TestRail - Test Runs & Results - Automation)
    int caseid = 74299;

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

        //Check that "SIGNUP TO GET INSTANT ACCESS." is present on the page
        String Sign = "";
        Sign = driver.findElement(By.xpath("//p[@class='text-center pv']")).getText();
        Assert.assertEquals(Sign, "SIGNUP TO GET INSTANT ACCESS.");
        //System.out.println(ActualResult);
        try {
            org.testng.Assert.assertEquals(Sign,  "SIGNUP TO GET INSTANT ACCESS.");

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
