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
        element = driver.findElement(By.xpath("//*[@placeholder='First name']"));
        return element;
    }

    public WebElement middleName(){
        element = driver.findElement(By.xpath("//*[@placeholder='Middle name']"));
        return element;
    }

    public WebElement lastName(){
        element = driver.findElement(By.xpath("//*[@placeholder='Last name']"));
        return element;
    }

    public WebElement subjectType(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.suspectType']"));
        return element;
    }

    public WebElement dateOfBirth(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.dob']"));
        return element;
    }

    public WebElement dateOfBirthCalendarIcon(){
        element = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        return element;
    }


    // add more web element for calendar table

    public WebElement nickName(){
        element = driver.findElement(By.xpath("//*[@placeholder='Nickname']"));
        return element;
    }

    public WebElement race(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.race']"));
        return element;
    }

    public WebElement height(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.height']"));
        return element;
    }

    public WebElement weight(){
        element = driver.findElement(By.xpath("//*[@name='Weight']"));
        return element;
    }

    public WebElement hairColor(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.hairColor']"));
        return element;
    }

    public WebElement hairLength(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.hairLength']"));
        return element;
    }

    public WebElement hairStyle(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.hairStyle']"));
        return element;
    }

    public WebElement sex(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.sex']"));
        return element;
    }

    public WebElement build(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.build']"));
        return element;
    }


    public WebElement eyeColor(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.eyeColor']"));
        return element;
    }

    public WebElement complexion(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.complexion']"));
        return element;
    }

    public WebElement teeth(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.teeth']"));
        return element;
    }

    public WebElement handPreference(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.handPreference']"));
        return element;
    }

    public WebElement previouButton(){
        element = driver.findElement(By.xpath("//a[@ng-click='wizard.go(1)']"));
        return element;
    }

    public WebElement nextButton(){
        element = driver.findElement(By.xpath("//a[@ng-click='wizard.go(3)' and text()='Next']"));
        return element;
    }

    // Added by MadMax on 01/07/2017
    public WebElement caseIdField()
    {
        return driver.findElement(By.name("caseNumber"));
    }

}
