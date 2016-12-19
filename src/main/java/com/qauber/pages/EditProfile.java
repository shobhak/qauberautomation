package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Created by Denys_G on 12/16/2016.

public class EditProfile {

    WebDriver driver;
    WebElement element;

    public EditProfile(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement changePhotoButton() {
        return driver.findElement(By.xpath("//button[@ngf-select='$ctrl.selectProfilePicture($file)']"));
    }
    public WebElement deletePhotoButton() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.deleteProfilePicture()']"));
    }
    public WebElement deletePhotoButtonDisabled() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.deleteProfilePicture()' and @disabled='disabled']"));
    }
    public WebElement nameField() {
        return driver.findElement(By.xpath("//input[@name='name']"));
    }
    public WebElement UpdateButton() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.submitGeneralForm()']"));
    }
    public WebElement currentPasswordField() {
        return driver.findElement(By.xpath("//input[@ng-model='$ctrl.password.current']"));
    }
    public WebElement newPasswordField() {
        return driver.findElement(By.xpath("//input[@ng-model='$ctrl.password.newone']"));
    }
    public WebElement repeatNewPasswordField() {
        return driver.findElement(By.xpath("//input[@ng-model='$ctrl.password.confirm']"));
    }
    public WebElement changePasswordButton() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.submitPasswordForm()']"));
    }


}
