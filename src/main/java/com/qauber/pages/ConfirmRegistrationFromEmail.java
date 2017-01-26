package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by erikfriedlander on 1/7/17.
 * Only for activating a AU/RU. This is the page you reach after clicking the 'activation' email
 */
public class ConfirmRegistrationFromEmail {
    WebDriver driver;

    public ConfirmRegistrationFromEmail(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement ConfirmRegistrationButton() {
        return driver.findElement(By.xpath("//button"));
    }
}
