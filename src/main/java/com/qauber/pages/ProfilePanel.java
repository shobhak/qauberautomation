package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// Created by Denys_G on 12/16/2016.

public class ProfilePanel {
    WebDriver driver;

    public ProfilePanel(WebDriver driver){this.driver = driver;}

    public WebElement userButton() {
        return driver.findElement(By.cssSelector(".icon-user.fa-lg"));
    }
    public WebElement settinsButton() {
        return driver.findElement(By.cssSelector(".icon-equalizer.fa-lg"));
    }
    public WebElement editProfileButton() {
        return driver.findElement(By.cssSelector(".btn.btn-purple.btn-sm"));
    }
    public WebElement mailtoEmail() {
        return driver.findElement(By.xpath("//a[contains(@ng-href,'mailto:')]"));
    }
    public WebElement callPhone() {
        return driver.findElement(By.xpath("//a[contains(@ng-href,'tell:')]"));
    }
    public WebElement editCompanyButton() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.editCompany()']"));
    }
    public WebElement logOutButton() {
        return driver.findElement(By.xpath("//button[@ng-click='app.logout()']"));
    }

}
