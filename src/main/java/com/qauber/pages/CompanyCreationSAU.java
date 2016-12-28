package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenochka on 23.12.2016.
 */
public class CompanyCreationSAU {
    WebDriver driver;

public CompanyCreationSAU(WebDriver driver) {

    this.driver = driver;
}
    WebElement element;


    public WebElement registerNow(){

        return driver.findElement(By.cssSelector("a.btn.btn-block.btn-default"));
        //return driver.findElement(By.xpath(".//a[@class = 'btn btn-block btn-default']"));
        //return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/a"));
       // return driver.findElement(By.xpath(".//a[text() = 'Register Now']"));
}

     public WebElement regName(){

       return driver.findElement(By.xpath(".//input[@placeholder = 'Enter your name']"));
     }

     public WebElement regEmail(){
        return driver.findElement(By.xpath(".//input[@placeholder = 'Enter email']"));

     }

    public WebElement regPassword(){
       return driver.findElement(By.xpath("//*[@id='id-password']"));
    }

    public WebElement regConfirmPassword(){
        return driver.findElement(By.xpath("//*[@name='account_password_confirm']"));
    }

    public WebElement regContinueRegistration(){
        return driver.findElement(By.cssSelector("button.btn.btn-block.btn-primary.mt-lg"));
    }

    public WebElement companyName(){
        return driver.findElement(By.xpath(".//input[@name = 'name']"));
    }

    public WebElement companyPhone(){
        return driver.findElement(By.xpath(".//input[@name = 'phone']"));
    }

    public WebElement companyEmail(){
       return driver.findElement(By.xpath(".//input[@name = 'email']"));
    }

    public WebElement companyCountry(){
        return driver.findElement(By.xpath(".//select[@name = 'country']"));
    }

    public WebElement companyAddress1(){
        return driver.findElement(By.xpath(".//*[@ng-model = 'reg.company.address1']"));
    }
    public WebElement companyAddress2(){
        return driver.findElement(By.xpath(".//*[@ng-model = 'reg.company.address2']"));
    }

    public WebElement companyCity(){
        return driver.findElement(By.xpath(".//*[@ng-model = 'reg.company.city']"));
    }

    public WebElement companyStateField(){
        return driver.findElement(By.xpath(".//input[@name = 'state']"));
    }

    public WebElement companyStateDropDown(){
        return driver.findElement(By.xpath(".//select[@name = 'state']"));
    }

    public WebElement companyZip(){
        return driver.findElement(By.xpath(".//*[@ng-model = 'reg.company.zip']"));
    }

    public WebElement companyFinishRegButton(){
        return driver.findElement(By.xpath("//*[@class='mb-sm btn btn-primary btn-labeled pull-right']"));
    }
}
