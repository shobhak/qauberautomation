package com.qauber.oldsanitytests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by lenochka on 07.12.2016.
 */


public class SACompanyCreation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        Faker faker = new Faker();
        String newUser = faker.name().username();
        String userEmail = faker.internet().emailAddress();
        String userPassword = faker.internet().password();
        String companyName = faker.company().name();
        String phoneNum = faker.phoneNumber().phoneNumber();
        String emailAddress = faker.internet().emailAddress();
        String address = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String postalcode = faker.address().zipCode();

//        String name = faker.name().



        driver.get("http://testwave.qabidder.net");

        String title = driver.getTitle();
        System.out.println(title);

        Thread.sleep(5000);// automatically added throws InterruptedException
        driver.findElement(By.cssSelector("a.btn.btn-block.btn-default")).click();

        Thread.sleep(6000);// similar to click and wait
        driver.findElement(By.name("account_name")).sendKeys(newUser);

        driver.findElement(By.name("account_email")).sendKeys(userEmail);

        driver.findElement(By.name("account_password")).sendKeys(userPassword);

        driver.findElement(By.name("account_password_confirm")).sendKeys(userPassword);

        driver.findElement(By.cssSelector("button.btn.btn-block.btn-primary.mt-lg")).click();

        Thread.sleep(4000);

        // Click on Company name
        //driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/div[1]/div[1]/div/input")).click();
        //driver.findElement(By.cssSelector("input.form-control.ng-pristine.ng")).click();

        driver.findElement(By.name("name")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("name")).sendKeys(companyName);
        Thread.sleep(1000);

        //click on Phone
        driver.findElement(By.name("phone")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("phone")).sendKeys(phoneNum);
        Thread.sleep(1000);

        //click on contact email
        driver.findElement(By.name("email")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys(emailAddress);
        Thread.sleep(1000);


        /* Country field, select one */
        driver.findElement(By.name("country")).sendKeys("Togo" + Keys.ENTER);
        driver.findElement(By.name("country")).click();
        Thread.sleep(3000);

        //Address field, select one
        driver.findElement(By.name("address1")).click();
        driver.findElement(By.name("address1")).sendKeys(address);
        Thread.sleep(2000);

        //City field, select one
        driver.findElement(By.name("city")).click();
        Thread.sleep(1000);

        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("city")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);

        //State field, select one
        driver.findElement(By.cssSelector("input.form-control.state-control-animated.ng-pristine.ng-untouched.ng-empty.ng-invalid.ng-invalid-required")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.form-control.state-control-animated.ng-pristine.ng-untouched.ng-empty.ng-invalid.ng-invalid-required")).sendKeys(state);;
        Thread.sleep(1000);

        // Postal Code field, select one
        driver.findElement(By.name("zip")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("zip")).sendKeys(postalcode);
        Thread.sleep(1000);

        //Finish Registration
        //driver.findElement(By.cssSelector("button.mb-sm.btn.btn-primary.btn-labeled.pull-righnt")).click();
        driver.findElement(By.xpath("//*[@class='mb-sm btn btn-primary btn-labeled pull-right']")).click();
        Thread.sleep(2000);

        driver.close();
        driver.quit();

    }


}
