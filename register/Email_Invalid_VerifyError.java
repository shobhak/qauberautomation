package com.qauber.register;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by arsenal on 11/4/16.
 */

public class Email_Invalid_VerifyError {

    private WebDriver driver;



    @BeforeClass
    public void setUp() throws InterruptedException {
        //set up Chrome environment
        System.setProperty("webdriver.chrome.driver", "/home/automation/Desktop/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        //go to registration page
        driver.get("http://testwave.qabidder.net/#/page/register-sa");
        Thread.sleep(4000);
    }

    @Test(priority = 1)
    public void emailFormatLUNS_lessThan254Char() throws InterruptedException {
        //Verify correct error message for a wrong email format input
        //data

        String error = "";
        String email;
        //test less than 254 chars (15) ""
        //type in email (upper, lower, numbers, spec chars) 15 chars
        email = randLUNS(15);
        driver.findElement(By.xpath("//input[@name='account_email']")).clear();
        driver.findElement(By.xpath("//input[@name='account_email']")).sendKeys(email);
        //waiting
        Thread.sleep(1000);
        //check for the error message(the format is incorrect)
        error = driver.findElement(By.xpath("//span[@class='text-danger']")).getText();

        //check the error message is there
        Assert.assertEquals(error, "Please enter a valid email address");
    }



    @AfterClass
    public void closeEverything() throws InterruptedException {
        driver.close();
    }

    //library

    //random string with Lower, Upper, Numbers, Special characters
    private String randLUNS(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            ret.append((char) (33 + r.nextInt(94)));
        }
        return ret.toString();
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
}

