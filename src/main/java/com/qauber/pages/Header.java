package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by erikfriedlander on 12/13/16.
 */
public class Header {

    WebDriver driver;

    //constructor
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement userName() {
        return driver.findElement(By.cssSelector("span.mr-sm.ng-binding"));
    }

    public WebElement logo() {
        return driver.findElement(By.xpath("//a[@class=\"navbar-brand\"]"));
    }
    public WebElement hamburgerMenu() {
        return driver.findElement(By.xpath("//a[@class=\"hidden-xs\"]"));
    }
}
