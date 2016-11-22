package com.qauber.register;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by arsenal on 11/4/16.
 */
public class SubmitAllTextFieldsBlank {

    //   ---    1.1 Register with all blank fields; Verify that error messages for required fields displayed.
    @Test
    public  void RegistrationPage_VerifyErrorMessagesForReqdFields() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/automation/Desktop/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        // maximize browser
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//a[@ui-sref='page.register-sa']")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/form/button")).click();


        //verify error messages for every req-d field
        // This will capture error message
        String name_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_name.$dirty && reg.registerForm.account_name.$error.required']")).getText();
        // Store message in variable
        String name_expect_msg="This field is required";
        Assert.assertEquals(name_actual_msg, name_expect_msg);

        // making sure email field error msg displayed
        String email_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_email.$dirty && reg.registerForm.account_email.$error.required']")).getText();
        String email_expect_msg="This field is required";
        Assert.assertEquals(email_actual_msg,email_expect_msg);

        // making sure password field error msg displayed
        String password_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_password.$dirty && reg.registerForm.account_password.$error.required']")).getText();
        String password_expect_msg = "This field is required";
        Assert.assertEquals(password_actual_msg,password_expect_msg);

        // making sure retype_password field error msg displayed
        String retypepass_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_password.$dirty && reg.registerForm.account_password.$error.required']")).getText();
        String retypepass_expect_msg = "This field is required";
        Assert.assertEquals(retypepass_actual_msg,retypepass_expect_msg);



        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();

    }
}