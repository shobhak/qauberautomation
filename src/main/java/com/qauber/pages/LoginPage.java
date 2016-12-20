package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by erikfriedlander on 12/13/16.
 * From https://github.com/SeleniumHQ/selenium/wiki/PageObjects
 * and http://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html
 */
public class LoginPage {

    WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver){

        this.driver = driver;

    }


    public WebElement userNameField() {
        return driver.findElement(By.id("exampleInputEmail1"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.id("exampleInputPassword1"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button[@class='btn btn-block btn-primary mt-lg']"));
    }

    public WebElement footerText() {
        return driver.findElement(By.xpath("/html/body/div/div/div/div[@class='p-lg text-center']"));
    }

    public WebElement registerButton() {
        return driver.findElement(By.xpath("//div[2]/a"));
    }

    public void loginToWave(String strUserName,String strPassword){

        userNameField().sendKeys(strUserName);
        passwordField().sendKeys(strPassword);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginButton().click();
        //TODO: add exception code... maybe check for successful/unsuccessful login and throw LoginFailure / UserNotFound / etc?

    }

    //By request, may delete.
    public boolean verifyLoginPage() {
        String footerContent = "© 2016 - FITS\n" + "FITS Web Application";
        return getLoginFooterText().equals(footerContent);
    }

    /////////////Old code, refactor and delete

    By userName = By.id("exampleInputEmail1");
    By password = By.id("exampleInputPassword1");
    By footerText = By.xpath("/html/body/div/div/div/div[@class='p-lg text-center']");

    By loginButton = By.xpath("/html/body/div/div/div/div/div/form/button[@class='btn btn-block btn-primary mt-lg']");
    By registerButton = By.cssSelector("a.btn.btn-block.btn-default");



    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(userName).sendKeys(strUserName);

    }



    //Set password in password textbox
    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }


    //Click on loginButton button

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void clickRegister(){
        driver.findElement(registerButton).click();
    }

    //Get the title of Login Page

    public String getLoginFooterText(){
        return driver.findElement(footerText).getText();
    }

}