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
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[1]/div[1]/div/div/span/label/span"));
        return element;
    }

    public WebElement tattoosTextField(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[1]/div[1]/div/div/input"));
        return element;
    }

    public WebElement scarsCheckbox(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[1]/div[2]/div/div/span/label/span"));
        return element;
    }

    public WebElement scarsTextField(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[1]/div[2]/div/div/input"));
        return element;
    }

    public WebElement needleMarksCheckbox(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[1]/div[3]/div/div/span/label/span"));
        return element;
    }

    public WebElement needleMarksTextField(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[1]/div[3]/div/div/input"));
        return element;
    }

    public WebElement tracksCheckbox(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[1]/div[4]/div/div/span/label/span"));
        return element;
    }

    public WebElement tracksTextField(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[1]/div[4]/div/div/input"));
        return element;
    }

    public WebElement glassesCheckbox(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[2]/div[1]/div/div/span/label/span"));
        return element;
    }

    public WebElement glassesTextField(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[2]/div[1]/div/div/input"));
        return element;
    }

    public WebElement mustacheCheckbox(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[2]/div[2]/div/div/span/label/span"));
        return element;
    }

    public WebElement mustacheTextField(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[2]/div[2]/div/div/input"));
        return element;
    }

    public WebElement beardCheckbox(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[2]/div[3]/div/div/span/label/span"));
        return element;
    }

    public WebElement beardTextField(){
        element = driver.findElement(By.xpath("//form/div/div[4]/fieldset/div[2]/div[3]/div/div/input"));
        return element;
    }

    public WebElement previousButton(){
        element = driver.findElement(By.xpath("//form/div/div[4]/ul/li[1]/a/span"));
        return element;
    }

    public WebElement nextButton(){
        element = driver.findElement(By.xpath("//form/div/div[4]/ul/li[2]/a"));
        return element;
    }







}
