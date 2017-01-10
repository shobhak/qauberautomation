package com.qauber.pages;

//Created by Denys_G 12/20/2016.

import com.qauber.pagesresource.ConfigHelper;
import com.qauber.pagesresource.ConfigOOP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class UsersPermissionsDialog {
    WebDriver driver;
    ConfigOOP config = ConfigHelper.getConfigFile();
    int sleepTime = config.getSleepTime();


    public UsersPermissionsDialog(WebDriver driver) {this.driver = driver;}

    public List<WebElement> userEntitiesList() {
             return driver.findElements(By.xpath("//tr//div[@class='depth-level']"));
    }
    public WebElement entityTR (int index){
        return driver.findElement(By.xpath("//tr[td/div[@class='depth-level']]["+index+"]"));
    }
    public WebElement detachButtonEntityTR (int index){
        return entityTR(index).findElement(By.xpath("/td/button[@ng-click='detachEntity(entity)']"));
    }
    public WebElement saveButtonEntityTR (int index){
        return entityTR(index).findElement(By.xpath("/td/button[@ng-click='assignEntity(entity)']"));
    }
    public Select dropDownListEntityTR (int index){
        return (Select) entityTR(index).findElement(By.xpath("/td/select"));
    }
    public WebElement rightsSavedEntityTR (int index){
        return entityTR(index).findElement(By.xpath("/td/div/div"));
    }

    public Select dropdownMenu(int index){
        return new Select(driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']['"+index+"']/td/select[@ng-model='entity.status']")));
    }
    public WebElement saveButton(int index){
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='assignEntity(entity)']['"+index+"']"));
    }
    public WebElement detachButton(int index){
        return driver.findElement
                (By.xpath("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='detachEntity(entity)']['"+index+"']"));
    }
    public void closeDialogByPressESC() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
    public void detachUserPermissions(int index) throws InterruptedException {
        detachButton(index).click();
        Thread.sleep(sleepTime/8);
        Assert.assertEquals(dropdownMenu(index).getFirstSelectedOption().getText(),"Select Role");
    }
    public void setUserAsAdmin(int index) throws InterruptedException {
        dropdownMenu(index).selectByVisibleText("Admin");
        Assert.assertEquals(dropdownMenu(index).getFirstSelectedOption().getText(),"Admin");
        saveButton(index).click();
        Thread.sleep(sleepTime/8);
        Assert.assertTrue(driver.findElement
                (By.xpath("//tr[@ng-repeat='entity in entities']['"+index+"']/td/div/div[text()='Admin']")).isDisplayed());
    }
    public void setUserAsRegularUser(int index) throws InterruptedException {
        dropdownMenu(index).selectByVisibleText("Regular user");
        Assert.assertEquals(dropdownMenu(index).getFirstSelectedOption().getText(),"Regular user");
        saveButton(index).click();
        Thread.sleep(sleepTime/8);
        Assert.assertTrue(driver.findElement
                (By.xpath("//tr[@ng-repeat='entity in entities']['"+index+"']/td/div/div[text()='Regular user']")).isDisplayed());
    }


}
