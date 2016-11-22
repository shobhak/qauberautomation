package com.qauber.register;
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
 * Created by andre on 11/3/2016.
 */
public class Name_Boundaries_VerifyError {

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

        //go to registration page
        try {
            regPage(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    @Test(priority = 1)
    public void regNameLessThan6Chars() throws InterruptedException {
        //data
        String error = "";
        String name;

        //test less than 6 chars (5) "Name"
        //type in name (upper, lower, numbers, spec chars) 5 chars
        name = randLUNS(5);
        driver.findElement(By.xpath("//input[@name='account_name']")).clear();
        driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(name);
        //waiting
        Thread.sleep(1000);
        //check for the error message(the name is too short)
        error = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/form/div[1]/span[3]")).getText();

        //check the error message is there
        Assert.assertEquals(error, "Input should be 6-50 length");
    }

    @Test(priority = 2)
    public void regNameExactly6Chars() throws InterruptedException {
        //data
        String name;
        boolean error;

        //test exactly 6 chars "Name"
        //type in name (upper, lower, numbers, spec chars) 6 chars
        name = randLUNS(6);
        driver.findElement(By.xpath("//input[@name='account_name']")).clear();
        driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(name);
        //waiting
        Thread.sleep(1000);
        //check for the error message(the name is too short)
        error = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/form/div[1]/span[3]")).isDisplayed();
        Assert.assertEquals(error, false);
    }

    @Test(priority = 3)
    public void regNameExactly50Chars() throws InterruptedException {
        //data
        String name;
        boolean error;

        //test exactly 50 chars "Name"
        //type in name (upper, lower, numbers, spec chars) 50 chars
        name = randLUNS(50);
        driver.findElement(By.xpath("//input[@name=\"account_name\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"account_name\"]")).sendKeys(name);
        //waiting
        Thread.sleep(1000);
        //check for the error message(the name is too short)
        error = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/form/div[1]/span[3]")).isDisplayed();
        Assert.assertEquals(error, false);
    }

    @Test(priority = 4)
    public void regNameMoreThan50Chars() throws InterruptedException {
        //data
        String name;
        String  error;

        //test more than 50 chars (51) "Name"
        //type in name (upper, lower, numbers, spec chars) 50 chars
        name = randLUNS(51);
        driver.findElement(By.xpath("//input[@name=\"account_name\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"account_name\"]")).sendKeys(name);
        //waiting
        Thread.sleep(1000);
        //check for the error message(the name is too short)
        error = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/form/div[1]/span[3]")).getText();
        Assert.assertEquals(error, "Input should be 6-50 length");
    }

    //simple string no @ symbol or .
/*    @Test(priority = 5)
    public void regEmailSimpleString() throws InterruptedException {
        //data
        String email;
        Random rand = new Random();

        //set "Name" to simpel "John Doe"
        driver.findElement(By.xpath("//input[@name=\"account_name\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"account_name\"]")).sendKeys("John Doe");
        //set up email string length from 1 to 40
        email = randLUNS(1 + rand.nextInt(40));
        //enter a string into "Email address" input field
        driver.findElement(By.xpath("//input[@name='account_email']")).sendKeys(email);
        //waiting
        Thread.sleep(1000);



    }
*/
    @AfterClass
    public void closeEverything() throws InterruptedException {
        driver.close();
    }

    //library

    //function that sends you to the registration page
    private void regPage(WebDriver wd) throws InterruptedException {
        if(!wd.getCurrentUrl().contains("http://testwave.qabidder.net/#/page/register-sa")){
            wd.get("http://testwave.qabidder.net/#/page/register-sa");
            Thread.sleep(4000);
        }
    }
    //random string with Lower, Upper, Numbers, Special characters
    private String randLUNS(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();

        for(int i = 0; i < size; i++) {
            ret.append((char) (33 + r.nextInt(94)));
        }
        return ret.toString();
    }
    //random string with Lower, Upper
    private String randLU(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();
        int rand;

        for(int i = 0; i < size; i++) {
            rand = 97 + r.nextInt(26);
            if(r.nextBoolean()) {
                rand -= 32;
            }
            ret.append((char) rand);
        }
        return ret.toString();
    }
    //random string with Lower
    private String randL(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();
        int rand;

        for(int i = 0; i < size; i++) {
            rand = 97 + r.nextInt(26);
            ret.append((char) rand);
        }
        return ret.toString();
    }
    //random string with Numbers
    private String randN(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();

        for(int i = 0; i < size; i++) {
            ret.append(r.nextInt(10));
        }
        return ret.toString();
    }


}