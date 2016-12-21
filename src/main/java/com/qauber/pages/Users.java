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

    public WebElement assignPermissionsButtonByName(String userName) {
        int listNo = 0;
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='text-bold ng-binding']"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(userName)) {
                listNo = i;
                break;}
            else{System.out.println("User is not present in the list");
                //or make it go search onto next page of users
                 }
        }
        list = driver.findElements(By.xpath("//button[@title='Assign permissions']"));
        return list.get(listNo);
    }

    public WebElement assignPermissionsButtonByEmail(String email) {
        int listNo = 0;
        email = email.toLowerCase();
        List<WebElement> list = driver.findElements(By.xpath("//div/a[contains(@ng-href, 'mailto:')]"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().toLowerCase().equals(email)) {
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
    public WebElement assignPermissionsButtonByIndex(int index) {
        List<WebElement> list = driver.findElements(By.xpath("//button[@title='Assign permissions']"));
        int listNo = index - 1;
        return list.get(listNo);
    }

    public WebElement deactivateButtonByIndex(int index){
        index = index - 1;
        return driver.findElement(By.xpath("//tr[@pagination-id='usersPagination']/td/button[@title='Deactivate']['"+index+"']"));
    }

    public WebElement deactivateButtonByName(String userName){
        return driver.findElement(By.xpath("//tr[td/div/div/div[text()='"+userName+"']]/td/button[@title='Deactivate']"));
    }

    public WebElement deactivateButtonByEmail(String email) {
        int listNo = 0;
        email = email.toLowerCase();
        List<WebElement> list = driver.findElements(By.xpath("//div/a[contains(@ng-href, 'mailto:')]"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().toLowerCase().equals(email)) {
                listNo = i;
                break;
            } else {
                System.out.println("User is not present in the list");
                //or make it go search onto next page of users
            }
        }
        list = driver.findElements(By.xpath("//button[@title='Deactivate']"));
        return list.get(listNo);
    }

    public WebElement deleteButtonByIndex(int index){
        index = index - 1;
        return driver.findElement(By.xpath("//tr[@pagination-id='usersPagination']/td/button[@title='Deactivate']['"+index+"']"));
    }

    public WebElement deleteButtonByName(String userName){
        return driver.findElement(By.xpath("//tr[td/div/div/div[text()='"+userName+"']]/td/button[@title='Delete']"));
    }

    public WebElement deleteButtonByEmail(String email) {
        //driver.findElement(By.xpath("//tr[td/div/div/div/a[text()='WAVE1@mailinator.com']]/td/button[@title='Deactivate']"));
        int listNo = 0;
        email = email.toLowerCase();
        List<WebElement> list = driver.findElements(By.xpath("//div/a[contains(@ng-href, 'mailto:')]"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().toLowerCase().equals(email)) {
                listNo = i;
                break;
            } else {
                System.out.println("User is not present in the list");
                //or make it go search onto next page of users
            }
        }
        list = driver.findElements(By.xpath("//button[@title='Delete']"));
        return list.get(listNo);
    }


}











