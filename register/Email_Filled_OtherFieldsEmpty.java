package com.qauber.register;

        import com.github.javafaker.Faker;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.testng.Assert;
        import org.testng.annotations.Test;

        import java.util.concurrent.TimeUnit;

/**
 * Verify required error messages displayed when user clicks 'Continue button' with only 'Email' field filled out.
 */



public class Email_Filled_OtherFieldsEmpty {
    @Test
    public void RegistrationPage_VerifyErrorMessagesForReqdFields3() throws InterruptedException {

        //set up chrome driver

        System.setProperty("webdriver.chrome.driver", "/home/automation/Desktop/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        Faker faker = new Faker();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to website

        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@ui-sref='page.register-sa']")).click();
        Thread.sleep(3000);

        // Randomise Email field input

        driver.findElement(By.xpath("//input[@name='account_email']")).sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);

        //Click 'Continue registration'

        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();

        //Verify error messages for the rest 3 text fields displayed
        //verify error messages for every req-d field
        // This will capture error message

        String name_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_name.$dirty && reg.registerForm.account_name.$error.required']")).getText();

        //Store message in variable

        String name_expect_msg="This field is required";
        Assert.assertEquals(name_actual_msg, name_expect_msg);

        //Verify password field error msg displayed
        String password_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_password.$dirty && reg.registerForm.account_password.$error.required']")).getText();
        String password_expect_msg = "This field is required";
        Assert.assertEquals(password_actual_msg,password_expect_msg);

        //Verify sure retype_password field error msg displayed
        String retypepass_actual_msg = driver.findElement(By.xpath("//span[@ng-show='reg.registerForm.account_password.$dirty && reg.registerForm.account_password.$error.required']")).getText();
        String retypepass_expect_msg = "This field is required";
        Assert.assertEquals(retypepass_actual_msg,retypepass_expect_msg);

        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();


    }
}