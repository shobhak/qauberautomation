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

    //Subject Information

    public WebElement caseID(){
        return driver.findElement(By.xpath("//*[text()='Case ID']//following::div[1]"));
    }

    public WebElement suspectType(){
        return downloadAsPDFButton().findElement(By.xpath("//*[text()='Suspect Type']//following::div[1]"));
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

    public  WebElement middleName() {
        return driver.findElement(By.xpath("//*[text()='Middle Name']//following::div[1]"));
    }

    public WebElement nickName(){
        return driver.findElement(By.xpath("//*[text()='Nickname (AKA)']//following::div[1]"));
    }

    public WebElement dob(){
        return driver.findElement(By.xpath("//*[text()='DOB']//following::div[1]"));
    }

    public WebElement age(){
        return driver.findElement(By.xpath("//*[text()='Age']//following::div[1]"));
    }

    public WebElement sex(){
        return driver.findElement(By.xpath("//*[text()='Sex']//following::div[1]"));
    }

    public WebElement race(){
        return driver.findElement(By.xpath("//*[text()='Race']//following::div[1]"));
    }

    public WebElement height(){
        return driver.findElement(By.xpath("//*[text()='Height']//following::div[1]"));
    }

    public WebElement weight(){
        return driver.findElement(By.xpath("//*[text()='Weight']//following::div[1]"));
    }

    public WebElement build(){
        return driver.findElement(By.xpath("//*[text()='Build']//following::div[1]"));
    }

    public WebElement hairColor(){
        return driver.findElement(By.xpath("//*[text()='Hair Color']//following::div[1]"));
    }

    public WebElement hairLength(){
        return driver.findElement(By.xpath("//*[text()='Hair Length']//following::div[1]"));
    }

    public WebElement hairStyle(){
        return driver.findElement(By.xpath("//*[text()='Hair Style']//following::div[1]"));
    }

    public WebElement eyeColor(){
        return driver.findElement(By.xpath("//*[text()='Eye Color']//following::div[1]"));
    }

    public WebElement complexion(){
        return driver.findElement(By.xpath("//*[text()='Complexion']//following::div[1]"));
    }

    public WebElement teeth(){
        return driver.findElement(By.xpath("//*[text()='Teeth']//following::div[1]"));
    }

    public WebElement handPreference(){
        return driver.findElement(By.xpath("//*[text()='Hand Preference']//following::div[1]"));
    }

    public WebElement primaryLanguage(){
        return driver.findElement(By.xpath("//*[text()='Primary Language']//following::div[1]"));
    }

    public WebElement country(){
        return driver.findElement(By.xpath("//*[text()='Country']//following::div[1]"));
    }

    public WebElement streetAddress(){
        return driver.findElement(By.xpath("//*[text()='Street Address']//following::div[1]"));
    }

    public WebElement city(){
        return driver.findElement(By.xpath("//*[text()='City']//following::div[1]"));
    }

    public WebElement state(){
        return driver.findElement(By.xpath("//*[text()='State']//following::div[1]"));
    }

    public WebElement zip(){
        return driver.findElement(By.xpath("//*[text()='Zip']//following::div[1]"));
    }

    public WebElement subjectTelephone(){
        return driver.findElement(By.xpath("//*[text()='Subject Telephone']//following::div[1]"));
    }

    public WebElement subjectEmail(){
        return driver.findElement(By.xpath("//*[text()='Subject Email']//following::div[1]"));
    }

    //Gang Membership Criteria

    public WebElement gangName(){
        return driver.findElement(By.xpath("//*[text()='Gang name']//following::div[1]"));
    }

    //all below doesn't exist from 01/17/2017

    public WebElement suspectName(){
        return driver.findElement(By.xpath("//*[@id='reportBody']/div[2]/div[1]/form/div[3]/div[2]/strong"));
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
}