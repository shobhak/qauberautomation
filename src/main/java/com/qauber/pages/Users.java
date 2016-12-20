package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

//Created by lenochka on 19.12.2016.
//Created/Merged/Edited by Denys_G on 12/19/2016.
public class Users {
    WebDriver driver;

    public Users(WebDriver driver) {this.driver = driver;}

    public WebElement inviteUserButton() {return driver.findElement(By.xpath(".//*[@ng-click='openInviteForm()']"));}
    public WebElement inviteUserEmailField(){return driver.findElement(By.xpath(".//*[@placeholder = 'email@example.com']"));}
    public WebElement sendInviteButton() {return driver.findElement(By.cssSelector("button.btn.btn-primary.mr"));}

    //public WebElement mailtoEmail() {return driver.findElement(By.xpath("//a[contains(@ng-href,'mailto:')]"));}
    public WebElement assignPermissionsButtonByName(String userName) {
        int listNo = 0;
//        String userName1 = "WAVE1TESThh";
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='text-bold ng-binding']"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(userName)) {
                listNo = i;
                break;
            }
            else{
                System.out.println("User is not present in the list");
                //or make it go search onto next page of users
            }
        }
        list = driver.findElements(By.xpath("//button[@title='Assign permissions']"));
        return list.get(listNo);
    }
}











