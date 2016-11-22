package com.qauber.register;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by arsenal on 11/16/16.
 */
public class RetypePassword_Filled_AllOtherBlank {

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

    @AfterClass
    public void closeEverything() throws InterruptedException {

        //wait
        Thread.sleep(2000);

        //close browser
        driver.quit();

    }

    @Test(priority = 1)

    public void  Vlad_RegPasswordFilledAllOtherBlank() {

        //set up faker for data input (password) randomization

        Faker faker = new Faker();

        // Find 'retype password' text field and type in random password of valid format

        driver.findElement(By.xpath("//input[@name='account_password_confirm']")).sendKeys(faker.internet().password(6 , 10));

        // Click on 'Continue registration' btn

        driver.findElement(By.xpath("//input[@id='id-password']")).click();

        //Make sure we were not redirected to the next registration step by assertion that button is present

        if(driver.findElements(By.xpath("//input[@id='id-password']")).size() != 0) {

            System.out.println("Test passed!");
        }

        else {

            System.out.println("Something's wrong!");
        }

    }

}