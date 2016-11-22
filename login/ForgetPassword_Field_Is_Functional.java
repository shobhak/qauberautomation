package com.qauber.login;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.By;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.Test;
        import org.testng.Assert;

public class ForgetPassword_Field_Is_Functional {
    @Test
    public void StartWebDriver() throws InterruptedException {

        String ntitle;

        System.setProperty("webdriver.chrome.driver", "/home/automation/Desktop/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Open Home page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);

        //Click on "Forget password" button
        driver.findElement(By.xpath("//a[@class='text-muted']")).click();
        Thread.sleep(5000);

        String email = "1234567sdfgggg@mailinator.com";
        //Enter exist email in email field
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        Thread.sleep(5000);
        //Click Reset password
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block mb-lg']")).click();
        Thread.sleep(5000);

        //check for the "Sent letter" message is displaying
        String SentMessage = "";
        SentMessage = driver.findElement(By.xpath("//div[@class='alert alert-success text-center ng-binding']")).getText();

        //check the "Sent letter" message is there
        Assert.assertEquals(SentMessage, "Reset password email sent.");
        Thread.sleep(10000);

        // Go on Mailinator.com to activate account
        driver.get("https://www.mailinator.com/");
        Thread.sleep(5000);
        // enter name of registered email
        driver.findElement(By.xpath("//input[@id='inboxfield']")).sendKeys(email);
        Thread.sleep(3000);
        //Click Go button
        driver.findElement(By.xpath("//button[@class='btn btn-dark']")).click();
        Thread.sleep(8000);
        //Open the the letter
        driver.findElement(By.xpath("//div[contains(@style,'width:100')][./div/div[contains(text(),'Reset Password')]]")).click();
        Thread.sleep(6000);
        //Switch frame
        driver.switchTo().frame("publicshowmaildivcontent");
        //Click on the link
        driver.findElement(By.xpath("//a[@rel='nofollow']")).click();
        Thread.sleep(15000);
        String parentHandle = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String pw = "mbtest27";
        //Enter password
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(pw);
        Thread.sleep(3000);
        //Retype password
        driver.findElement(By.xpath("//input[@name='password_confirm']")).sendKeys(pw);
        Thread.sleep(6000);

        //click on Change password button
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(6000);
        ntitle = driver.getTitle();
        Assert.assertEquals(ntitle, "FITS - FITS Web Application");
        Thread.sleep(6000);

        driver.close();
        driver.switchTo().window(parentHandle);

        driver.manage().deleteAllCookies();


        driver.quit();
    }
}
