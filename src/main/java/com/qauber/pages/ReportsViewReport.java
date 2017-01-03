package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Alya on 12/20/2016.
 */
public class ReportsViewReport {

    private WebDriver driver;

    public ReportsViewReport(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement downloadAsPDFButton() {
        return driver.findElement(By.xpath("//button[text()='Download as PDF']"));
    }

    public WebElement useAsTemplateButton() {
        return driver.findElement(By.xpath("//button[text()='Use as template']"));
    }

    public WebElement reportID(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[1]/div[2]/strong"));
    }

    // added on 12/26/2016
    public WebElement caseID(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[2]/div[2]/strong"));
    }
    //added on 12/29/2016
    public WebElement suspectName(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[3]/div[2]/strong"));
    }

    public WebElement stopLocation(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[3]/div[2]/form/div[24]/div[2]/strong"));
    }
}