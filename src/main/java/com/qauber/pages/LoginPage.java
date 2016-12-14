package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 12/13/16.
 * From https://github.com/SeleniumHQ/selenium/wiki/PageObjects
 * and http://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html
 */
public class LoginPage {

    WebDriver driver;

    By userName = By.id("exampleInputEmail1");
    By password = By.id("exampleInputPassword1");
    By footerText = By.xpath("/html/body/div/div/div/div[@class='p-lg text-center']");

    By loginButton = By.xpath("/html/body/div/div/div/div/div/form/button[@class='btn btn-block btn-primary mt-lg']");
    By registerButton = By.cssSelector("a.btn.btn-block.btn-default");

    //Constructor
    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

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


//     This POM method will be exposed in test case to loginButton in the application
//     @param strUserName
//     @param strPasword
//     @return

    public void loginToWave(String strUserName,String strPassword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPassword);

        //Click Login button

        this.clickLogin();

    }

}