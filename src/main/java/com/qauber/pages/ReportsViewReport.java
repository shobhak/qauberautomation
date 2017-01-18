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
        return driver.findElement(By.xpath("//*[text()='Report ID']//following::div[1]"));
    }

    public WebElement lastName(){
        return driver.findElement(By.xpath("//*[text()='Last Name']//following::div[1]"));
    }

    public WebElement firstName() {
        return driver.findElement(By.xpath("//*[text()='First Name']//following::div[1]"));
    }

    public WebElement caseID(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[2]/div[2]/strong"));
    }

    public WebElement suspectName(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[3]/div[2]/strong"));
    }

    public WebElement suspectType(){
        return downloadAsPDFButton().findElement(By.xpath("//*[text()='Suspect Type']//following::div[1]"));
    }

     public WebElement dob() {
         return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[5]/div[2]/strong"));
     }

     public WebElement nickName(){
         return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[6]/div[2]/strong"));
    }

    public WebElement raceHeightWeight(){
         return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[7]/div[2]/strong"));
    }

    public WebElement hairColorHairLengthHairStyle(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[8]/div[2]/strong"));
    }

    public WebElement sexBuildEyeColor(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[9]/div[2]/strong"));
    }

    public WebElement complexionTeethHandPreference(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[10]/div[2]/strong"));
    }

    public WebElement dateTime(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[11]/div[2]/strong"));
    }

    public WebElement stopLocation(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[3]/div[2]/form/div[24]/div[2]/strong"));
    }
}