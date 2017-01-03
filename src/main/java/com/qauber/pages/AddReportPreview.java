package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Alya on 12/19/2016.
 */
public class AddReportPreview {

    private WebDriver driver;

    public AddReportPreview(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement editPencilIcon() {
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[9]/div[2]/div[1]/div[2]/div[2]/div[1]/em"));
    }

    public WebElement caseIDField() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.caseIdEdited\"]"));
    }

    public WebElement saveCaseIDButton (){
        return driver.findElement(By.cssSelector(".text-success.fa.fa-check"));
    }

    public WebElement cancelCaseIDButton (){
        return driver.findElement(By.cssSelector(".text-danger.fa.fa-times.ml"));
    }

    public WebElement publishReportButton() {
        return driver.findElement(By.xpath("//a[@ng-click= \"wizard.commitReport()\"]"));
    }

    public WebElement previousButton() {
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[9]/ul/li[1]/a"));
    }

    public WebElement reportIdElement(){
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[9]/div[2]/div[1]/div[1]/div[2]/strong"));
    }
    public WebElement suspectName(){
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[9]/div[2]/div[1]/div[3]/div[2]/strong"));
    }

    public WebElement stopLocation(){
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[9]/div[3]/div[2]/div[24]/div[2]/strong"));
    }
}

