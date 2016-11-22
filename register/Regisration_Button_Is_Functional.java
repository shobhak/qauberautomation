package com.qauber.register;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Regisration_Button_Is_Functional {


    @Test
    public void StartWebDriver() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/home/automation/Desktop/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String newtitle;

        //Open Home page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(10000);
        // Click on "Register now"
        driver.findElement(By.xpath("//a[@ui-sref='page.register-sa']")).click();
        Thread.sleep(6000);


        //Should be redirect on Registration page
        newtitle = driver.getTitle();

        driver.quit();

        Assert.assertEquals(newtitle, "FITS - FITS Web Application");
    }


}