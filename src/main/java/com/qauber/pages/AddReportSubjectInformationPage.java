package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jingx on 12/15/2016.
 * find all web element in Subject information page of add report.
 */
public class AddReportSubjectInformationPage {
    WebDriver driver;
    WebElement element;

    public AddReportSubjectInformationPage(WebDriver driver) {
        this.driver = driver;
    }


    // find all web elements
    public WebElement firstName(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[1]/div[1]/div/div/input"));
        return element;
    }

    public WebElement middleName(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[1]/div[2]/div/div/input"));
        return element;
    }

    public WebElement lastName(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[1]/div[3]/div/div/input"));
        return element;
    }

    public WebElement subjectType(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[1]/div[4]/div/div/select"));
        return element;
    }

    public WebElement dateOfBirth(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[2]/div[1]/div/div/p/input"));
        return element;
    }

    public WebElement dateOfBirthCalendarIcon(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[2]/div[1]/div/div/p/span/button"));
        return element;
    }


    // add more web element for calendar table

    public WebElement nickName(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[2]/div[2]/div/div/input"));
        return element;
    }

    public WebElement race(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[2]/div[3]/div/div/select"));
        return element;
    }

    public WebElement height(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[2]/div[4]/div/div[1]/div/div/input"));
        return element;
    }

    public WebElement weight(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[2]/div[4]/div/div[2]/div/div/input"));
        return element;
    }

    public WebElement hairColor(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[3]/div[1]/div/div/select"));
        return element;
    }

    public WebElement hairLength(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[3]/div[2]/div/div/select"));
        return element;
    }

    public WebElement hairStyle(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[3]/div[3]/div/div/select"));
        return element;
    }

    public WebElement sex(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[3]/div[4]/div/div/select"));
        return element;
    }

    public WebElement build(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[3]/div[5]/div/div/select"));
        return element;
    }


    public WebElement eyeColor(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[4]/div[1]/div/div/select"));
        return element;
    }

    public WebElement complexion(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[4]/div[2]/div/div/select"));
        return element;
    }

    public WebElement teeth(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[4]/div[3]/div/div/select"));
        return element;
    }

    public WebElement handPreference(){
        element = driver.findElement(By.xpath("//form/div/div[3]/fieldset/div[4]/div[4]/div/div/select"));
        return element;
    }

    public WebElement previouButton(){
        element = driver.findElement(By.xpath("//form/div/div[3]/ul/li[1]/a/span"));
        return element;
    }

    public WebElement nextButton(){
        element = driver.findElement(By.xpath("//form/div/div[3]/ul/li[2]/a"));
        return element;
    }


}
