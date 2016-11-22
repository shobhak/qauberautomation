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
 * Continue registration with 'Email' and 'Password' fields filled out and all other fields empty.
 */

public class EmailAndPasswordFilledAllOtherBlank {

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
        Thread.sleep(20000);

        //close browser
        driver.quit();

    }

    @Test(priority = 1)

    public void EmailAndPasswordFilledAllOtherBlank1() throws InterruptedException {

        //set up faker for data input (email & password) randomization

        Faker faker = new Faker();

        // Find 'email' text field and type in random name of valid format

        Thread.sleep(10000);

        driver.findElement(By.xpath("//input[@name='account_email']")).sendKeys(faker.internet().emailAddress());

        // Find 'password' text field and type in random email of valid format

        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(faker.internet().password(6, 10));


        // Click on 'Continue registration' btn

        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();

        //Make sure we were not redirected to the next registration step by assertion that button is present

        if (driver.findElements(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).size() != 0) {

            System.out.println("Test passed!");
        } else {

            System.out.println("Something's wrong!");
        }
    }

}
