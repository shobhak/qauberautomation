package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenochka on 27.12.2016.
 */
   public class UserDeletion {
    WebDriver driver;

    public UserDeletion(WebDriver driver) {
        this.driver = driver;
    }

    WebElement element;

    public WebElement deleteUserByEmail(String emailName) {
        return driver.findElement(By.xpath(".//*[@ng-href='mailto:"+emailName+"']/ancestor::*[5]/td[2]/button[4]"));
    }

    public WebElement deleteConfirmationButton (){
        return driver.findElement(By.xpath(".//*[@class='btn btn-danger mr'][text()='Delete']"));
    }


}