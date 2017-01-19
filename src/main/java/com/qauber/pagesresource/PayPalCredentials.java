package com.qauber.pagesresource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenochka on 28.12.2016.
 */
    public class PayPalCredentials {

    private WebDriver driver;
    private WebElement element;
    //private static final String URL = "https://www.sandbox.paypal.com";

    public PayPalCredentials(WebDriver driver) {
        this.driver = driver;
    }

    private String login = "mypaypalsandbox@gmail.com";
    private String password = "mypaypalsandbox";

    private WebElement payWithMyPayPal(){

        return driver.findElement(By.xpath("//*[@id='loadLogin']"));
    }

    private WebElement loginField() {
        element = driver.findElement(By.xpath("//*[@id='login_email']"));
        return element;
    }

    private WebElement passField() {
        //element = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/button[2]/span[1]");
        element = driver.findElement(By.xpath("//*[@id='login_password']"));
        return element;
    }

    private WebElement logInBtn() {
        element = driver.findElement(By.xpath("//*[@id='submitLogin']"));
        return element;
    }

    private WebElement agreeAndContinueBtn() {
        element = driver.findElement(By.xpath("//*[@id='continue']"));
        return element;
    }

    public void payWithPayPal()throws InterruptedException

    {

        //driver.get(URL);
        int sleepTime = 5000;
        Thread.sleep(sleepTime);

        payWithMyPayPal().click();
        Thread.sleep(sleepTime);

        loginField().click();
        Thread.sleep(sleepTime);

        loginField().sendKeys(login);
        Thread.sleep(sleepTime);

        passField().sendKeys(password);
        Thread.sleep(sleepTime);

        logInBtn().click();
        Thread.sleep(sleepTime);

        agreeAndContinueBtn().click();
        Thread.sleep(sleepTime);
    }


}
