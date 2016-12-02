package com.qauber.register;

import com.gurock.testrail.APIException;
import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

/**
 * Created by arsenal on 11/4/16.
 */

public class Email_Invalid_VerifyError {

    private WebDriver driver;

    APIClientExtension client = Config.testRailLogin();
    int runid = Config.getRunID();
    int testid;
    String tester;


    @BeforeClass
    public void setUp() throws InterruptedException {
        //set up Chrome environment
        driver = new ChromeDriver();
   

        //go to registration page
        driver.get("http://testwave.qabidder.net/#/page/register-sa");
        Thread.sleep(4000);
    }

    @Test(priority = 1)
    public void emailFormatLUNS_lessThan254Char() throws InterruptedException, IOException, APIException {
        //Verify correct error message for a wrong email format input
        //data

        testid = 69233;

        tester = "Vlad's computer";

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
        try {
            Assert.assertEquals(error, "Please enter a valid email address");


        } catch (AssertionError e) { //on fail, run this
            try {
                client.addResult(runid, testid, 5, e.getLocalizedMessage(), tester);
                throw e; //Throwing AssertionError
            } catch (IllegalStateException g) {
                g.printStackTrace();
                System.out.println("Illegal State Exception");
            }

        } catch (Exception e) {
            System.out.println("General Exception in assertEquals");
            e.printStackTrace();

        }

        //If Assert passes, send this to TestRail
        client.addResult(runid, testid, 1, "Actual value = expected value", tester);

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

