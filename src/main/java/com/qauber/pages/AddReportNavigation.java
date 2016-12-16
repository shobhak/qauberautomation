package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by gaming on 12/15/2016.
 */
public class AddReportNavigation {


    WebDriver driver;
    WebElement element;


    public AddReportNavigation(WebDriver driver){
        this.driver = driver;
    }

    public WebElement organizationTab() {
        element = driver.findElement(By.xpath("//h4/div[@title='Organization']"));
        return element;
    }


    public WebElement subjectInformationTab() {
        element = driver.findElement(By.xpath("//h4/div[@title='Subject Information']"));
        return element;
    }


    public WebElement identifiersTab() {
        element = driver.findElement(By.xpath("//h4/div[@title='Identifiers']"));
        return element;
    }

    public WebElement identificationInformationTab() {
        element = driver.findElement(By.xpath("//h4/div[@title='ID Information']"));
        return element;
    }

    public WebElement environmentTab() {
        element = driver.findElement(By.xpath("//h4/div[@title='Environment']"));
        return element;
    }

    public WebElement vehicleTab() {
        element = driver.findElement(By.xpath("//h4/div[@title='Vehicle']"));
        return element;
    }

    public WebElement photoTab() {
        element = driver.findElement(By.xpath("//h4/div[@title='Photo']"));
        return element;
    }

    public WebElement previewTab() {
        element = driver.findElement(By.xpath("//h4/div[@title='Preview']"));
        return element;
    }


}
