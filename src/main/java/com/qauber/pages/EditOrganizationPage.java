package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jingx on 12/19/2016.
 */
public class EditOrganizationPage {
    WebDriver driver;
    WebElement element;

    public EditOrganizationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Organization name web element
    public WebElement organizatonName(){
        element = driver.findElement(By.xpath("//form/div[1]/div[1]/div/input"));
        return element;
    }

    // phone number web element
    public WebElement phoneNumber(){
        element = driver.findElement(By.xpath("//form/div[1]/div[2]/div/input"));
        return element;
    }

    // email web element
    public WebElement eMail(){
        element = driver.findElement(By.xpath("//form/div[1]/div[3]/div/input"));
        return element;
    }

    // organization photo add button web element
    public WebElement organizationPhotoAddButton(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[1]/div/div[2]/button[1]"));
        return element;
    }

    // organization photo change button web element
    public WebElement organizationPhotoChangeButton(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[1]/div/div[2]/button[1]"));
        return element;
    }

    // organization photo delete button web element
    public WebElement organizationPhotoDeleteButton(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[1]/div/div[2]/button[2]"));
        return element;
    }

    // country drop down list web element
    public WebElement countryList(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[2]/select"));
        return element;
    }

    // Address 1 web element
    public WebElement address1(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[3]/input"));
        return element;
    }

    // Address 2 web element
    public WebElement address2(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[4]/input"));
        return element;
    }

    // city web element
    public WebElement city(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[5]/input"));
        return element;
    }

    // state text field web element
    public WebElement state(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[6]/input"));
        return element;
    }

    // state drop down list web element
    public WebElement stateList(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[6]/select"));
        return element;
    }

    // postal code web element
    public WebElement postalCode(){
        element = driver.findElement(By.xpath("//form/div[2]/div[1]/div[7]/input"));
        return element;
    }

    // note web element
    public WebElement note(){
        element = driver.findElement(By.xpath("//form/div[2]/div[2]/div/textarea"));
        return element;
    }

    // update button web element
    public WebElement updateButton(){
        element = driver.findElement(By.xpath("//section/div/div/div[2]/button"));
        return element;
    }

}
