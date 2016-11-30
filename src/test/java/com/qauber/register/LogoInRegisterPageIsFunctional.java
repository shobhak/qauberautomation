package com.qauber.register;

import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoInRegisterPageIsFunctional {
    String ActualResult = "";
    APIClientExtension client;
    int runid = Config.getRunID(); //Test Run ID (TestRail - Test Runs & Results - Automation)
    int caseid = 74291;

    @BeforeClass
    public void setUp() {

        client = Config.testRailLogin();

    }

        @Test
        public void StartWebDriver() throws InterruptedException {


            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mariia\\Downloads\\chromedriver_win32\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            //Open Home page
            driver.get("http://testwave.qabidder.net/#/page/login");
            Thread.sleep(10000);
            // Click on "Register now"
            driver.findElement(By.xpath("//a[@ui-sref='page.register-sa']")).click();
            Thread.sleep(6000);

            //Click on Logo icon
            driver.findElement(By.xpath("//img[@class='block-center img-rounded']")).click();
            Thread.sleep(6000);

            //Should be redirect on Sign In page

            ActualResult = driver.findElement(By.xpath("//p[contains(.,'Need to Sign Up?')]")).getText();
            System.out.println(ActualResult);
            try {
                org.testng.Assert.assertEquals(ActualResult, "Need to Sign Up?");
            } catch (AssertionError e) { //on fail, run this
                try {
                    client.addResult(528, 74291, 5, e.getLocalizedMessage(), "Mariia's Computer");
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

            // Assert.assertEquals(newtitle, "FITS - FITS Web Application");
        }


 }
