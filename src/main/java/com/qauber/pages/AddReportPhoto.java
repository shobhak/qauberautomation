package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Max on 12/16/2016.
 */
public class AddReportPhoto {

    WebDriver driver;
    WebElement element;

    public AddReportPhoto(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement previousButton(){
        element = driver.findElement(By.xpath("//form/div/div[8]/ul/li[1]/a"));
        return element;
    }

    public WebElement nextButton(){
        element = driver.findElement(By.xpath("//form/div/div[8]/ul/li[2]/a"));
        return element;
    }

    public WebElement addPhotoButton() // use .sendKeys() to upload image. TODO it doesn't work.
    {
        element = driver.findElement(By.cssSelector(".upload.btn.btn-primary.btn-labeled"));
        return element;
    }

    public WebElement warningMessage() // only if you upload 5 photos
    {
        element = driver.findElement(By.cssSelector(".text-warning.text-uppercase"));
        return element;
    }

    public WebElement deletePhotoIcon(int number) // Photo number in list
    {
        List<WebElement> list = driver.findElements(By.cssSelector(".fa.fa-trash"));
        element = list.get(number-1);
        return element;
    }

    public WebElement deletePhotoIcon() // By default delete first photo
    {
        deletePhotoIcon(1);
        return element;
    }

}
