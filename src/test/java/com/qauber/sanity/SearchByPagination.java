package com.qauber.sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchByPagination {
    WebDriver driver = new ChromeDriver();
    public String Url = "http://testwave.qabidder.net/#/page/login";
    public String login = "raizzz.test@gmail.com"; // Login
    public String password = "013666";             // Password
    public String list = "3";                      // Number of page to select in pagination

    @Test
    public void verifyHomepageTitle() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Reports")).click();

        driver.findElement(By.xpath("//button[@ng-click='openedSearchFrom=true']")).click();
        driver.findElement(By.xpath("//button[@ng-click='select(null, $event)']")).click();
        WebElement element = driver.findElement(By.linkText(list));
        element.click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='ng-scope active']/a")).getText(), list);
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

