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

    public WebElement publishReportButton() {
        return driver.findElement(By.xpath("//a[@ng-click= \"wizard.commitReport()\"]"));
    }

    public WebElement previousButton() {
        return driver.findElement(By.name("//form/div/div[9]/ul/li[1]/a"));
    }
}

