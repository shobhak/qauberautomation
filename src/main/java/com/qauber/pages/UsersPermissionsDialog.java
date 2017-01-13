package com.qauber.pages;

//Created by Denys_G 12/20/2016.

import com.qauber.pagesresource.ConfigHelper;
import com.qauber.pagesresource.ConfigOOP;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public WebElement organizationByRow(int index){
        return driver.findElement(By.xpath("//tr[" + index + "]//div[@class='depth-level']"));
    }
//    public WebElement organizationByRow(int index){
//        return (WebElement) driver.findElements(By.xpath("//tr[" + index + "]//div[@class='depth-level']"));
//    }
    public List<WebElement> userRowList() {
        return driver.findElements(By.xpath("//tr[@ng-repeat='entity in entities']"));
    }
    public List<WebElement> entitiesDepSubdepsAllList() {
        return driver.findElements(By.xpath("//td[@style='border-left: none']/div"));
    }
    public WebElement detachButtonByEntity(int index){
        return driver.findElement(By.xpath(
                "//tr[td/div[@class='depth-level']]["+index+"]/td/button[@ng-click='detachEntity(entity)']"));
    }
    public WebElement saveButtonByEntity(int index){
        return driver.findElement(By.xpath(
                "//tr[td/div[@class='depth-level']]["+index+"]/td/button[@ng-click='assignEntity(entity)']/i"));
    }
    public Select dropDownListByEntity(int index){
        return new Select(driver.findElement(By.xpath("//tr[td/div[@class='depth-level']]["+index+"]/td/select")));
    }
    public WebElement rightsSavedByEntity(int index){
        return driver.findElement(By.xpath("//tr[td/div[@class='depth-level']]["+index+"]/td/div/div"));
    }
    public WebElement rightsSavedTR(int index){
        return driver.findElement(By.xpath(
                "//tr[@ng-repeat='entity in entities']["+index+"]/td/div/div"));
    }

    public Select dropdownMenuTR(int index){
        return new Select(driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']["+index+"]/td/select[@ng-model='entity.status']")));
    }
    public WebElement saveButtonByTR(int index){
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']["+index+"]/td/button[@ng-click='assignEntity(entity)']"));
    }
    public WebElement detachButtonByTR(int index){
        return driver.findElement
                (By.xpath("//tr[@ng-repeat='entity in entities']["+index+"]/td/button[@ng-click='detachEntity(entity)']"));
    }
    public void closeDialogByPressESC() throws AWTException {
        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('ngdialog-close')[0].click();");
    }
    public void detachUserPermissionsTR(int index) throws InterruptedException {
        detachButtonByTR(index).click();
        Thread.sleep(sleepTime/8);
        Assert.assertEquals(dropdownMenuTR(index).getFirstSelectedOption().getText(),"Select Role");
    }
    public void setUserAsAdminTR(int index) throws InterruptedException {
        dropdownMenuTR(index).selectByVisibleText("Admin");
        Assert.assertEquals(dropdownMenuTR(index).getFirstSelectedOption().getText(),"Admin");
        saveButtonByTR(index).click();
        Thread.sleep(sleepTime/8);
//        Assert.assertTrue(driver.findElement
//                (By.xpath("//tr[@ng-repeat='entity in entities']["+index+"]/td/div/div[text()='Admin']")).isDisplayed());
    }
    public void setUserAsRegularUserTR(int index) throws InterruptedException {
        dropdownMenuTR(index).selectByVisibleText("Regular user");
        Assert.assertEquals(dropdownMenuTR(index).getFirstSelectedOption().getText(),"Regular user");
        saveButtonByTR(index).click();
        Thread.sleep(sleepTime/8);
//        Assert.assertTrue(driver.findElement
//                (By.xpath("//tr[@ng-repeat='entity in entities']["+index+"]/td/div/div[text()='Regular user']")).isDisplayed());
    }


}
