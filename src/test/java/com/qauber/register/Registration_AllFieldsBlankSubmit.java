package com.qauber.register;

import com.gurock.testrail.APIException;
import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by arsenal on 11/4/16.
 */
public class Registration_AllFieldsBlankSubmit {

    APIClientExtension client = Config.testRailLogin();
    int runid = Config.getRunID();
    int testid;
    String tester;

//   ---    1.1 Register with all blank fields; Verify that error messages for required fields displayed.
    @Test
    public  void RegistrationPage_VerifyErrorMessagesForReqdFields() throws InterruptedException, IOException, APIException {

        testid = 74287;

        tester = "Vlad's computer";

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

        // making sure email field error msg displayed
        String email_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_email.$dirty && reg.registerForm.account_email.$error.required']")).getText();
        String email_expect_msg="This field is required";

        // making sure password field error msg displayed
        String password_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_password.$dirty && reg.registerForm.account_password.$error.required']")).getText();
        String password_expect_msg = "This field is required";

        // making sure retype_password field error msg displayed
        String retypepass_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_password.$dirty && reg.registerForm.account_password.$error.required']")).getText();
        String retypepass_expect_msg = "This field is required";
        //Assert.assertEquals(retypepass_actual_msg,retypepass_expect_msg);

        try {
            Assert.assertEquals(retypepass_actual_msg, retypepass_expect_msg);
            Assert.assertEquals(name_actual_msg, name_expect_msg);
            Assert.assertEquals(email_actual_msg,email_expect_msg);
            Assert.assertEquals(password_actual_msg,password_expect_msg);

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

        //If Assert passes, send this to TestRail
        client.addResult(runid, testid, 1, "Actual value = expected value", tester);


        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();

    }
}
