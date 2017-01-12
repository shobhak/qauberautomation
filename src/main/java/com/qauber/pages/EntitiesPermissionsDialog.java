package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


//Created by Denys_G on 12/21/2016.

public class EntitiesPermissionsDialog {
    WebDriver driver;

    public EntitiesPermissionsDialog(WebDriver driver) {this.driver = driver;}

    public WebElement deleteButtonByIndex(int index){
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='user in $assignCtrl.users']["+index+"]/td/button[@title='Detach']"));
    }
    public void detachUserPermissionsTR(int index) throws InterruptedException {
        driver.findElement
                (By.xpath("//tr[@ng-repeat='user in $assignCtrl.users']["+index+"]/td/button[@title='Detach']")).click();
        Select dropdown = new Select(driver.findElement(By.xpath
                ("//tr[@ng-repeat='user in $assignCtrl.users']["+index+"]/td/select[@ng-model='user.assignedRole']")));
        Thread.sleep(500);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Select Role");
    }
    public void setUserAsAdmin(int index) throws InterruptedException {
        driver.findElement
                (By.xpath("//tr[@ng-repeat='user in $assignCtrl.users']" +
                        "["+index+"]/td/select[@ng-model='user.assignedRole']")).sendKeys("Admin");
        driver.findElement(By.xpath
                ("//tr[@ng-repeat='user in $assignCtrl.users']["+index+"]/td/button[@title='Save changes']")).click();
        Select dropdown = new Select(driver.findElement(By.xpath
                ("//tr[@ng-repeat='user in $assignCtrl.users']["+index+"]/td/select[@ng-model='user.assignedRole']")));
        Thread.sleep(500);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Admin");
    }
    public void setUserAsRegularUser(int index) throws InterruptedException {
        driver.findElement
                (By.xpath("//tr[@ng-repeat='user in $assignCtrl.users']" +
                        "["+index+"]/td/select[@ng-model='user.assignedRole']")).sendKeys("Regular user");
        driver.findElement(By.xpath
                ("//tr[@ng-repeat='user in $assignCtrl.users']["+index+"]/td/button[@title='Save changes']")).click();
        Select dropdown = new Select(driver.findElement(By.xpath
                ("//tr[@ng-repeat='user in $assignCtrl.users']["+index+"]/td/select[@ng-model='user.assignedRole']")));
        Thread.sleep(500);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Regular user");
    }

    public WebElement saveButtonByIndex(int index){
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='user in $assignCtrl.users']["+index+"]/td/button[@title='Save changes']"));
    }
    public WebElement rightsDropdownByIndex(int index){
        return driver.findElement(By.xpath
                ("//tr[@ng-repeat='user in $assignCtrl.users']["+index+"]/td/select[@ng-model='user.assignedRole']"));
    }
    public void closeDialogByPressESC() {
        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('ngdialog-close')[0].click();");
    }

    public List<WebElement> userNameList(){
        return driver.findElements(By.xpath("//div[@class='ng-binding']"));
    }

    public int findingUserIndex(String userName){
        int rowindex = 1;
        for (int i = 0; i < userNameList().size(); i++){
            if (userNameList().get(i).getText().equals(userName)){
                break;
            } else {
                rowindex++;
            }
        }
        if (rowindex == userNameList().size()+1){
            System.out.println("The user is not in the list");
        }
        return rowindex;
    }

    public List<WebElement> rightDropdownList() {return driver.findElements(By.xpath("//td/select"));}
}
