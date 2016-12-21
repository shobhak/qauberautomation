package com.qauber.pages;

//Created by Denys_Gon 12/20/2016.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UsersPermissionsDialog {
    WebDriver driver;

    public UsersPermissionsDialog(WebDriver driver) {this.driver = driver;}

    public WebElement deleteButtonByIndex(int index){
        index = index - 1;
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='detachEntity(entity)']['"+index+"']"));
    }
    public WebElement saveButtonByIndex(int index){
        index = index - 1;
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='assignEntity(entity)']['"+index+"']"));
    }
    public WebElement rightsDropdownByIndex(int index){
        index = index - 1;
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='assignEntity(entity)']['"+index+"']"));
    }
    public void closeDialogByPressESC() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
}
