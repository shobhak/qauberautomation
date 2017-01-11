package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//Created by lenochka on 19.12.2016.
//Created/Merged/Edited by Denys_G on 12/19/2016.
public class Users {
    WebDriver driver;

    public Users(WebDriver driver) {this.driver = driver;}

    public List<WebElement> userNameRows() { return driver.findElements(By.xpath("//table/tbody/tr/td[1]/div//a")); }
    public WebElement nextPageButton() {return driver.findElement(By.xpath("//a[@ng-click=\"setCurrent(pagination.current + 1)\"]")); } //next page, if Users paginated. SHOWS WHETHER ENABLED OR DISABLED

    //    public WebElement nextPageButtonDisabled() {return driver.findElement(By.xpath("//li[@class=\"ng-scope disabled\"]"));}; //only exists when next page is disabled
    public boolean nextPageButtonEnabled() {return driver.findElements(By.xpath("//li[@class=\"ng-scope\" and @class !=\"disabled\"]/a[@ng-click=\"setCurrent(pagination.current + 1)\"]")).size() > 0;}
    public WebElement inviteUserButton() {return driver.findElement(By.xpath(".//*[@ng-click='openInviteForm()']"));}
    public WebElement inviteUserEmailField(){return driver.findElement(By.xpath(".//*[@placeholder = 'email@example.com']"));}
    public WebElement sendInviteButton() {return driver.findElement(By.cssSelector("button.btn.btn-primary.mr"));}
    public WebElement cancelButton() {return  driver.findElement(By.xpath("//button[text()='Cancel']"));}

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
        for (int i = 0; i <= list.size(); i++) {
            if (list.get(i).getText().toLowerCase().equals(email)) {
                listNo = i;
                break;
            }
            else{
                System.out.println("Next user check...");
                //or make it go search onto next page of users
            }
        }
        System.out.println("User found");
        list = driver.findElements(By.xpath("//button[@title='Assign permissions']"));
        return list.get(listNo);
    }
    public WebElement assignPermissionsButtonByIndex(int index) {
        List<WebElement> list = driver.findElements(By.xpath("//button[@title='Assign permissions']"));
        int listNo = index - 1;
        return list.get(listNo);
    }

    public WebElement deactivateButtonByIndex(int index){
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
        return driver.findElement(By.xpath(".//tr[@class='ng-scope'][" + index + "]//button[@title='Delete']"));
    }

    public WebElement deleteConfirmationButton (){
        return driver.findElement(By.xpath(".//*[@class='btn btn-danger mr'][text()='Delete']"));
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

    public WebElement areYouSure(){
        return driver.findElement(By.xpath("//*[@id='ngdialog1-aria-describedby']"));

    }

    public void inviteUserWithoutActivation(String emailAddress) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("javascript:window.scrollBy(0,-400)"); //scroll to top of page, thank you Denis
        inviteUserButton().click();
        inviteUserEmailField().sendKeys(emailAddress);
        Thread.sleep(200);
        sendInviteButton().click();
    }

}











