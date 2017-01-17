package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by San Jose on 1/10/2017
 */
public class EntitiesDepartmentSetting {

    WebDriver driver;
    WebElement element;
    List<WebElement> elements;


    public EntitiesDepartmentSetting(WebDriver driver) {
        this.driver = driver;
    }


    // Web element for department name field
    public WebElement departmentname(int rowindex){
        element = driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]//input"));
        return element;
    }

    // Web element for update button
    public WebElement departmentUpdatebutton(int rowindex){
        element = driver.findElement(By.xpath("//div[2]/div[1]/form/button[1]"));
        return element;
    }
    // Web element for delite button
    public WebElement departmentDelitebutton(int rowindex){
        element = driver.findElement(By.xpath("//div[2]/div[1]/form/button[2]"));
        return element;
    }
    // Web element for cancel button
    public WebElement departmentCancelbutton(int rowindex){
        element = driver.findElement(By.xpath("//div[2]/div[1]/form/button[3]"));
        return element;
    }
    // Web element for confirm delite subdepartment button in dialog window
    public WebElement departmentConfirmDeliteButton(int rowindex){
        element = driver.findElement(By.xpath("//*[@class=\"ngdialog-content\"]//button[1]"));
        return element;
    }
    // Web element for cancel subdepartment button in dialog window
    public WebElement departmentCancelDeliteButton(int rowindex){
        element = driver.findElement(By.xpath("//*[@class=\"ngdialog-content\"]//button[2]"));
        return element;
    }


}


