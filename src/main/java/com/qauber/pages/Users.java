package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenochka on 19.12.2016.
 */
public class Users {
    WebDriver driver;

    //Constructor
    public Users(WebDriver driver){

        this.driver = driver;
    }

    WebElement element;


   public WebElement inviteUserButton() {
       return driver.findElement(By.xpath(".//*[@ng-click='openInviteForm()']"));
   }

   public WebElement inviteUserEmailField(){
       return driver.findElement(By.xpath(".//*[@placeholder = 'email@example.com']"));
   }

    public WebElement sendInviteButton() {
        return driver.findElement(By.cssSelector("button.btn.btn-primary.mr"));
    }





}


