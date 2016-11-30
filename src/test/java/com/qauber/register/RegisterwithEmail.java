package com.qauber.register;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;


//Created by Mariia


public class RegisterwithEmail {
    String ActualResult = "";
    APIClientExtension client;
    int runid = Config.getRunID(); //Test Run ID (TestRail - Test Runs & Results - Automation)
    int caseid = 74297;

    @BeforeClass
    public void setUp() {

        client = Config.testRailLogin();
    }

        @Test
    public void StartWebDriver() throws InterruptedException {

        Random rand = new Random();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Faker faker = new Faker();
        String parentHandle = driver.getWindowHandle();
        //Open Home page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(10000);
        // Click on "Register now"
        driver.findElement(By.xpath("//a[@ui-sref='page.register-sa']")).click();
        Thread.sleep(6000);

        //Type "Name"
        driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(faker.name().fullName());
        //Add "Email"

        String email = randL(8) + "@mailinator.com";
        email = rand.nextInt(1000) + email;
        driver.findElement(By.xpath("//input[@name='account_email']")).sendKeys(email);

        //Type "Password"
        String pw  = randLU(7);
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(pw);
        //Type password in "Confirm password" field
        driver.findElement(By.xpath("//input[@name='account_password_confirm']")).sendKeys(pw);
        Thread.sleep(9000);
        // Click "Continue registration"
        driver.findElement(By.xpath("//button[contains(.,'Continue registration')]")).click();
        Thread.sleep(10000);
        // Type "Organization Name"

        driver.findElement(By.xpath("//input[@ng-model='reg.company.name']")).sendKeys(faker.company().name());
        //Type "Address"
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(faker.address().streetAddress());
        //Type "City"
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(faker.address().cityName());
        // Type "California" in "State" drop down menu

        WebElement roleDropdown = driver.findElement(By.xpath("//select[@name='state']"));
        roleDropdown.click();

        WebElement roleOptionOne = driver.findElement(By.xpath("//option[contains(.,'California')]"));
        roleOptionOne.click();

        //Add "Zip code"
        String zip = randL(5);
        driver.findElement(By.xpath("//input[contains(@name,'zip')]")).sendKeys("12345");
        //Add "Phone"
        String phone = randL(10);
        driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys("1234567891");
        //Add "email"
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        Thread.sleep(6000);
        //Click "Finish Registration"
        driver.findElement(By.xpath("//button[contains(.,'Finish registration')]")).click();
        Thread.sleep(15000);
        //Go on www.mailinator.com
        driver.get("https://www.mailinator.com");
        // Type Mailname in "Mail" field
        driver.findElement(By.xpath("//input[@id='inboxfield']")).sendKeys(email);
        //Click "Go" button
        driver.findElement(By.xpath("//button[@class='btn btn-dark']")).click();
        Thread.sleep(20000);
        //Click on activation letter

        driver.findElement(By.xpath("//div[contains(@style,'width:100')][./div/div[contains(text(),'Activate Your Account')]]")).click();
        Thread.sleep(6000);
        //Switch frame
        driver.switchTo().frame("publicshowmaildivcontent");
        //Click on the link
        driver.findElement(By.xpath("//a[@rel='nofollow']")).click();
        Thread.sleep(15000);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();
        driver.switchTo().window(parentHandle);

        //Come back on parentHandle window
        //Go on www.testwave.qabidder.net/#/page/login
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(10000);
        //Add Mailname
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);
        //Add "Password
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(pw);
        // Click "Login"
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(6000);
             ActualResult = driver.findElement(By.xpath("//td[@class='text-center text-uppercase']")).getText();
            System.out.println(ActualResult);
            try {
                org.testng.Assert.assertEquals(ActualResult, "NO ENTITIES FOUND");

            } catch (AssertionError e) { //on fail, run this
                try {
                    client.addResult(runid, caseid, 5, e.getLocalizedMessage(), "Mariia's Computer");
                    throw e; //Throwing AssertionError
                } catch (IllegalStateException g) {
                    g.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println("General Exception in assertEquals");
                e.printStackTrace();

            }

            //If Assert passes, send this to TestRail
            client.addResult(runid, caseid, 1, "Actual value = expected value", "Mariia's Computer");


            driver.manage().deleteAllCookies();

        driver.close();
        driver.quit();
    }

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
    public String randLU(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();
        int rand;

        for (int i = 0; i < size; i++) {
            rand = 97 + r.nextInt(26);
            if (r.nextBoolean()) {
                rand -= 32;
            }
            ret.append((char) rand);
        }
        return ret.toString();


          }
}