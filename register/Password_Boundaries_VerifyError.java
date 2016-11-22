package com.qauber.register;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by arsenal on 11/15/16.
 */
public class Password_Boundaries_VerifyError {

    private WebDriver driver;


    @BeforeClass
    public void setUp() throws InterruptedException {
        //set up Chrome environment
        System.setProperty("webdriver.chrome.driver", "/home/automation/Desktop/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //go to registration page
        driver.get("http://testwave.qabidder.net/#/page/register-sa");
        Thread.sleep(4000);
    }

    @Test(priority = 1)

    public void regPasswordLessThan6Chars() throws InterruptedException {
        //data
        String error = "";
        String password;

        //test less than 6 chars (5) "Password"
        //type in password (upper, lower, numbers) 5 chars
        password = randLUN(5);
        driver.findElement(By.xpath("//input[@id='id-password']")).clear();
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(password);
        //waiting
        Thread.sleep(1000);
        //check for the error message(the name is too short)
        error = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[3]/span[3]")).getText();

        //check the error message is displayed
        Assert.assertEquals(error, "Input should match 'a-zA-Z0-9' and 6-10 length");


    }

    @Test(priority = 2)

    public void regPasswordExactly6Chars() throws InterruptedException {
        //data
        boolean error;
        String password;

        //test password contains 6 chars (6) "Password"
        //type in password (upper, lower, numbers) 6 chars
        password = randLUN(6);
        driver.findElement(By.xpath("//input[@id='id-password']")).clear();
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(password);
        //waiting
        Thread.sleep(1000);
        //check for the error message(the name is too short)
        error = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[3]/span[3]")).isDisplayed();

        //check the error message is not displayed
        Assert.assertEquals(error, false);

    }

    @Test(priority = 3)

    public void regPasswordExactly10Chars() throws InterruptedException {
        //data
        boolean error;
        String password;

        //test password contains 10 chars (10) "Password"
        //type in password (upper, lower, numbers) 6 chars
        password = randLUN(10);
        driver.findElement(By.xpath("//input[@id='id-password']")).clear();
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(password);
        //waiting
        Thread.sleep(1000);
        //check for the error message(the name is too short)
        error = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[3]/span[3]")).isDisplayed();

        //check the error message is not displayed
        Assert.assertEquals(error, false);

    }

    @Test(priority = 4)

    public void regPasswordMoreThan10Chars() throws InterruptedException {
        //data
        String error = "";
        String password;

        //test more than 10 chars (11) "Password"
        //type in password (upper, lower, numbers) 11 chars
        password = randLUN(11);
        driver.findElement(By.xpath("//input[@id='id-password']")).clear();
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(password);
        //waiting
        Thread.sleep(1000);
        //check for the error message(the name is too short)
        error = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[3]/span[3]")).getText();

        //check the error message is  displayed
        Assert.assertEquals(error, "Input should match 'a-zA-Z0-9' and 6-10 length");

    }

    @Test(priority = 5)
    public void PWretypeIsReq() throws InterruptedException {
        String name = randLUN(4) + " " + randLUN(6);
        String email = generateEmail(20, "com");
        String pw = randLUN(10);
        String wrongPW = randLUN(10);
        String error = "";
        String url = "http://testwave.qabidder.net/#/page/register-sa";
        String cururl;

        while(pw == wrongPW)
            wrongPW = randLUN(10);

        driver.findElement(By.name("account_name")).clear();
        driver.findElement(By.name("account_name")).sendKeys(name);
        driver.findElement(By.name("account_email")).clear();
        driver.findElement(By.name("account_email")).sendKeys(email);
        driver.findElement(By.id("id-password")).clear();
        driver.findElement(By.id("id-password")).sendKeys(pw);
        driver.findElement(By.name("account_password_confirm")).clear();
        driver.findElement(By.name("account_password_confirm")).sendKeys(wrongPW);
        Thread.sleep(1000);
        if(isHere(By.xpath("//span[@class = 'text-danger']"))) {
            error = driver.findElements(By.xpath("//span[@class = 'text-danger']")).get(0).getText();
        }
        driver.findElement(By.xpath("//button[text()='Continue registration']")).click();
        Thread.sleep(4000);
        cururl = driver.getCurrentUrl();

        Assert.assertEquals(error, "Password does Not match");
        Assert.assertEquals(cururl, url);
    }



    //Library
    private String randLUN(int size) {
        String rand = "";
        if (size > 0) {
            String allowedChars = "abcdefghijklmnopqrstuvwxyz" +   //lower alphabets
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +    //upper alphabets
                    "1234567890";   //numbers

            rand = RandomStringUtils.random(size, allowedChars);
        }
        return rand;

    }
    @AfterClass
    public void closeEverything() throws InterruptedException {
        driver.close();
    }


    //length has to be at least domain.length() + 2
    public String generateEmail(int length, String extension) {
        String email = "";

        if(length > extension.length() + 3) {
            String allowedChars = "abcdefghijklmnopqrstuvwxyz" +   //alphabets
                    "1234567890";   //numbers
            Random r = new Random();

            int addresssize = 1 + r.nextInt(length - (extension.length() + 3));
            String temp = RandomStringUtils.random(addresssize, allowedChars);

            temp = temp + "@";
            temp = temp + RandomStringUtils.random(length - (addresssize + 2 + extension.length()), allowedChars);

            email = temp + "." + extension;
        }
        return email;
    }

    //isHere - find elements on a page
    private boolean isHere(By _by){
        boolean ret;
        int size;

        size = driver.findElements(_by).size();
        if(size > 0) {
            ret = true;
        }
        else {
            ret = false;
        }

        return ret;
    }
}