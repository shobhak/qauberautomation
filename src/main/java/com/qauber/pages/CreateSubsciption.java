package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenochka on 20.12.2016.
 */
public class CreateSubsciption {
    WebDriver driver;
    WebElement element;


    //Constructor
    public CreateSubsciption(WebDriver driver){
        this.driver = driver;
    }

   /* public WebElement primaryLanguageField() {
        //element = driver.findElement(By.xpath("//button[contains(@ng-show,'entity.status == 0')]");
        element = driver.findElement(By.xpath("(.//button[@title='Finish creating the organization'])[last()]"));
        return element;
    } */
    public  WebElement finishButton(){
        element = driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right"));
        return element;
    }

    public WebElement payWithMyPayPal(){
        return driver.findElement(By.xpath("//*[@id='loadLogin']"));
    }
    public WebElement loginField() {
        element = driver.findElement(By.xpath("//*[@id='login_email']"));
        return element;
    }

    public WebElement passwordField() {
        //element = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/button[2]/span[1]");
        element = driver.findElement(By.xpath("//*[@id='login_password']"));
        return element;
    }

    public WebElement logInButton(){
        element = driver.findElement(By.xpath("//*[@id='submitLogin']"));
        return element;
    }


}