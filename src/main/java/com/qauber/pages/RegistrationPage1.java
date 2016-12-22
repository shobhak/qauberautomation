package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by erikfriedlander on 12/18/16.
 */
public class RegistrationPage1 {

    WebDriver driver;

    public RegistrationPage1(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement nameField() {
        return driver.findElement(By.xpath("//div[1]/input"));
    }
    public WebElement emailAddressField() {
        return driver.findElement(By.xpath("//div[2]/input"));
    }
    public WebElement passwordField() {
        return driver.findElement(By.xpath("//div[3]/input"));
    }
    public WebElement retypePasswordField() {
        return driver.findElement(By.xpath("//div[4]/input"));
    }
    public WebElement continueRegistrationButton() {
        return driver.findElement(By.xpath("//form/button"));
    }

    public void registerUser1(String name, String emailAddress, String password) throws InterruptedException { //
        nameField().sendKeys(name);
        emailAddressField().sendKeys(emailAddress);
        passwordField().sendKeys(password);
        retypePasswordField().sendKeys(password);

        Thread.sleep(2000); //TODO: fix Thread.sleep and remove...

        continueRegistrationButton().click();

        Thread.sleep(5000);
    }
}
