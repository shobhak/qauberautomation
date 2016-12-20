package com.qauber.oldsanitytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ContinueAnUnpublishedReport {
    WebDriver driver = new ChromeDriver();
    public String Url = "http://testwave.qabidder.net/#/page/login";
    public String login = "raizzz.test@gmail.com"; // Login
    public String password = "013666";             // Password

    @Test
    public void verifyHomepageTitle() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Reports")).click();

        if(driver.findElement(By.xpath("//input[@ng-model='enablePublishedOn']")).isSelected())
            driver.findElement(By.xpath("//input[@ng-model='enablePublishedOn']")).click();

        ArrayList<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.xpath("//a[@ng-click='setCurrent(pageNumber)']")));
        list.get(list.size()-1).click();
        list = new ArrayList<WebElement>(driver.findElements(By.xpath("//div[text()='not published']")));
        Assert.assertEquals(list.get(list.size()-1).getText(), "not published");
        list = new ArrayList<WebElement>(driver.findElements(By.cssSelector(".btn.btn-info.btn-sm.ng-scope")));
        list.get(list.size()-1).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.xpath("html/body/div[2]/section/div/h3")).getText(), "Field Interview Card");

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


