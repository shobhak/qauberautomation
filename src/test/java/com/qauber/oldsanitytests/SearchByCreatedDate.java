package com.qauber.oldsanitytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchByCreatedDate {

    WebDriver driver = new ChromeDriver();
    public String Url = "http://testwave.qabidder.net/#/page/login";
    public String login = "raizzz.test@gmail.com"; // Login
    public String password = "013666";             // Password

    public String startMonth = "December";
    public String startDay = "10";
    public String startYear = "2016";

    public String endMonth = "December";
    public String endDay = "12";
    public String endYear = "2016";


    @Test
    public void verifyHomepageTitle() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Reports")).click();

        if(driver.findElement(By.xpath("//input[@ng-model='enablePublishedOn']")).isSelected())
            driver.findElement(By.xpath("//input[@ng-model='enablePublishedOn']")).click();

        driver.findElement(By.xpath("//button[@ng-click='openedCreatedFrom=true']")).click();
        driver.findElement(By.xpath("//th[@colspan='6']/button")).click();
        driver.findElement(By.xpath("//th[@colspan='1']/button")).click();
        driver.findElement(By.xpath("//span[text()='"+startYear.substring(2,4)+"']")).click();
        driver.findElement(By.xpath("//span[text()='"+startMonth+"']")).click();
        driver.findElement(By.xpath("//span[text()='"+startDay+"']")).click();
        driver.findElement(By.xpath("//button[@ng-click='openedCreatedTo=true']")).click();
        driver.findElement(By.xpath("//th[@colspan='6']/button")).click();
        driver.findElement(By.xpath("//th[@colspan='1']/button")).click();
        driver.findElement(By.xpath("//span[text()='"+endYear.substring(2,4)+"']")).click();
        driver.findElement(By.xpath("//span[text()='"+endMonth+"']")).click();
        driver.findElement(By.xpath("//span[text()='"+endDay+"']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+startMonth.substring(0,3)+" "+startDay+", "+startYear+"']")).isDisplayed());
    }

    @BeforeTest
    public void loginPage () throws InterruptedException
    {
        //Open URL, login on site
        driver.get(Url);
        driver.manage().window().maximize();
        Thread.sleep(1500);
        WebElement element = driver.findElement(By.id("exampleInputEmail1"));
        element.clear();
        element.sendKeys(login);
        element = driver.findElement(By.name("account_password"));
        element.clear();
        element.sendKeys(password);
        driver.findElement(By.tagName("button")).submit();
    }
    @AfterTest
    public void closeBrowser () throws InterruptedException {
        //Sign Out and close browser
        driver.findElement(By.cssSelector(".nav.navbar-nav.navbar-right>li>a")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".btn.btn-labeled.btn-primary.btn-sm")).click();
        driver.quit();
    }
}


