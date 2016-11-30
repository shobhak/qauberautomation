package com.qauber.register;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Continue registration with 'Name', 'Password' and 'Retype Password' fields filled out and all other fields empty.
 */


public class NamePasswordRetypePasswordFilledAllOtherBlank {

    public WebDriver driver;

    APIClientExtension client = Config.testRailLogin();
    int runid = Config.getRunID();
    int testid;
    String tester;

    @BeforeClass

    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();

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

    public void NameAndPasswordFilledAllOtherBlank() {

        testid = 74287;

        tester = "Vlad's computer";

        //set up faker for data input (email & password) randomization
        Faker faker = new Faker();

        // Find 'name' text field and type in random name of valid format
        driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(randLU(7));

        //declare a 'password' string for use in 'password' and 'retype password' fields - random each time but the same for both fields.
        String password = faker.internet().password(6, 10);

        // Find 'Password' text field and type in random name of valid format
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(password);

        // Find 'Retype password' text field and type in random email of valid format
        driver.findElement(By.xpath("//input[contains(@name,'account_password_confirm')]")).sendKeys(password);

        // Click on 'Continue registration' btn
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();


        try {
            //Make sure we were not redirected to the next registration step by assertion that button is present
            if (driver.findElements(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).size() != 0) {

                System.out.println("Test passed!");
                client.addResult(runid, testid, 1, "Actual value = expected value", tester);

            }
            else {

                System.out.println("Button is not displayed!");
                AssertionError e = new AssertionError();
                throw e;

            }

        } catch (AssertionError e) { //on fail, run this
            try {
                client.addResult(runid, testid, 5, e.getLocalizedMessage(), "Tester's Computer");
                throw e; //Throwing AssertionError
            } catch (IllegalStateException g) {
                g.printStackTrace();
                System.out.println("Illegal State Exception");
            }

        } catch (Exception e) {
            System.out.println("General Exception in assertEquals");
            e.printStackTrace();

        }


    }

    //randomizer (used for 'Name' text field) string with Lower, Upper
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

}
