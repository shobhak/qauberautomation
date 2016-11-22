package com.qauber.login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CopyrightSymbolIsPresentOnMainP {

    @Test
    public void StartWebDriver() throws InterruptedException {

       System.setProperty("webdriver.chrome.driver", "/home/automation/Desktop/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Home page

        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(8000);

        //Check year Symbol is Present on the page.

        String year = "";
        year = driver.findElement(By.xpath("//span[@ng-bind='app.year']")).getText();
        Assert.assertEquals(year, "2016");
        Thread.sleep(6000);

        //Check App name is present on the page.
        String App = "";
        App = driver.findElement(By.xpath("//span[@ng-bind='app.name']")).getText();
        Assert.assertEquals(App, "FITS");

        //Check Copyright name is present on the paC:\\Users\\Mariia\\Downloads\\chromedriver_win32\\chromedriver.exege
        String Copyright = "";
        Copyright = driver.findElement(By.xpath("//span[@ng-bind='app.description']")).getText();
        Assert.assertEquals(Copyright, "FITS Web Application");
        Thread.sleep(6000);


        driver.quit();

    }
}

