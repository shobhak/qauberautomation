package com.qauber.pages;

//Created by Denys_Gon 12/20/2016.

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

    public UsersPermissionsDialog(WebDriver driver) {this.driver = driver;}

    public List<WebElement> userEntitiesList() {
             return driver.findElements(By.xpath("//tr//div[@class='depth-level']"));
    }

    public WebElement deleteButtonByIndex(int index){
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='detachEntity(entity)']['"+index+"']"));
    }
    public WebElement saveButtonByIndex(int index){
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='assignEntity(entity)']['"+index+"']"));
    }
    public WebElement rightsDropdownByIndex(int index){
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']['"+index+"']/td/select[@ng-model='entity.status']"));
    }
    public void closeDialogByPressESC() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
    public void detachUserPermissions(int index) throws InterruptedException {
        driver.findElement
                (By.xpath("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='detachEntity(entity)']['"+index+"']")).click();
        Select dropdown = new Select(driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']['"+index+"']/td/select[@ng-model='entity.status']")));
        Thread.sleep(500);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Select Role");
    }
    public void setUserAsAdmin(int index) throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']['"+index+"']/td/select[@ng-model='entity.status']")));
        dropdown.selectByVisibleText("Admin");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Admin");
        driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='assignEntity(entity)']['"+index+"']")).click();
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement
                (By.xpath("//tr[@ng-repeat='entity in entities']['"+index+"']/td/div/div[text()='Regular User']")).isDisplayed());
    }
    public void setUserAsRegularUser(int index) throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']['"+index+"']/td/select[@ng-model='entity.status']")));
        dropdown.selectByVisibleText("Regular user");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Regular user");
        driver.findElement(By.xpath
                ("//tr[@ng-repeat='entity in entities']/td/button[@ng-click='assignEntity(entity)']['"+index+"']")).click();
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement
                (By.xpath("//tr[@ng-repeat='entity in entities']['"+index+"']/td/div/div[text()='Admin']")).isDisplayed());
    }

}
