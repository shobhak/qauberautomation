package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jingx on 12/15/2016.
 * find out all web elements for Identifiers page of Add report
 */
public class AddReportIdentifiersPage {
    WebDriver driver;
    WebElement element;

    public AddReportIdentifiersPage(WebDriver driver){
        this.driver = driver;
    }


    // find all web elements
    public WebElement tattoosCheckbox(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.tattoos']"));
        return element;
    }

    public WebElement tattoosTextField(){
        element = driver.findElement(By.xpath("//*[@placeholder='Tattoos']"));
        return element;
    }

    public WebElement scarsCheckbox(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.scars']"));
        return element;
    }

    public WebElement scarsTextField(){
        element = driver.findElement(By.xpath("//*[@placeholder='Scars']"));
        return element;
    }

    public WebElement needleMarksCheckbox(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.needleMarks']"));
        return element;
    }

    public WebElement needleMarksTextField(){
        element = driver.findElement(By.xpath("//*[@placeholder='Needle marks']"));
        return element;
    }

    public WebElement tracksCheckbox(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.tracks']"));
        return element;
    }

    public WebElement tracksTextField(){
        element = driver.findElement(By.xpath("//*[@placeholder='Tracks']"));
        return element;
    }

    public WebElement glassesCheckbox(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.glasses']"));
        return element;
    }

    public WebElement glassesTextField(){
        element = driver.findElement(By.xpath("//*[@placeholder='Glasses']"));
        return element;
    }

    public WebElement mustacheCheckbox(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.mustache']"));
        return element;
    }

    public WebElement mustacheTextField(){
        element = driver.findElement(By.xpath("//*[@placeholder='Mustache']"));
        return element;
    }

    public WebElement beardCheckbox(){
        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.beard']"));
//        element = driver.findElement(By.xpath("//*[@ng-model='wizard.report.beard']//following-sibling::span"));
        return element;
    }

    public WebElement beardTextField(){
        element = driver.findElement(By.xpath("//*[@placeholder='Beard']"));
        return element;
    }

    public WebElement previousButton(){
        element = driver.findElement(By.xpath("//*[@ng-click='wizard.go(2)']"));
        return element;
    }

    public WebElement nextButton(){
        element = driver.findElement(By.xpath("//*[@ng-click='wizard.go(4)' and text()='Next']"));
        return element;
    }







}
