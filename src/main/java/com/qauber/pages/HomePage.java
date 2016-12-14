package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 12/13/16.
 */
public class HomePage {

    WebDriver driver;

    By homePageUserName = By.cssSelector("span.mr-sm.ng-binding");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Get the Username from Home Page

    public String getHomePageUserName() {
        return driver.findElement(homePageUserName).getText();
    }

}
