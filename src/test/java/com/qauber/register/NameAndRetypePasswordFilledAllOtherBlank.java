package com.qauber.register;

import com.github.javafaker.Faker;
import com.gurock.testrail.APIException;
import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

/**
 * Continue registration with 'Name' and 'Retype Password' fields filled out and all other fields empty.
 */

public class NameAndRetypePasswordFilledAllOtherBlank {

    public WebDriver driver;
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

    @AfterClass
    public void closeEverything() throws InterruptedException {

        //wait
        Thread.sleep(2000);

        //close browser
        driver.quit();

    }

    @Test(priority = 1)

    public void NameAndPasswordFilledAllOtherBlank() throws IOException, APIException {

        //set up faker for data input (name & password) randomization
        Faker faker = new Faker();

        // Find 'name' text field and type in random name of valid format
        driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(randLU(7));

        // Find 'Retype password' text field and type in random email of valid format
        driver.findElement(By.xpath("//input[contains(@name,'account_password_confirm')]")).sendKeys(faker.internet().password(6, 10));

        // Click on 'Continue registration' btn
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();

        testid = 69241;
        tester = "Vlad's computer";


        //Make sure we were not redirected to the next registration step by assertion that button is present

        try {  if (driver.findElements(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).size() != 0) {

            System.out.println("Test passed!");
        }
        else {

            System.out.println("Something's wrong!");
        }

        } catch (AssertionError e) { //on fail, run this
            try {
                client.addResult(runid, testid, 5, e.getLocalizedMessage(), tester);
                throw e; //Throwing AssertionError
            } catch (IllegalStateException g) {
                g.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("General Exception in assertEquals");
            e.printStackTrace();

        }

        /* If Assert passes, send this to TestRail */
        client.addResult(runid, testid, 1, "Actual value = expected value", tester);

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
