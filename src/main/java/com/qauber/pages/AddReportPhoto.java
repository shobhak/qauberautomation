package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

    public void addPhotoButton(String absolutePath) throws AWTException, InterruptedException // Use absolute path to upload image: "C:\\file_name.png"
    {
        element = driver.findElement(By.cssSelector(".upload.btn.btn-primary.btn-labeled"));
        element.click();

        Thread.sleep(5000);

        // create a file path with StringSelection and copy it to clipboard
        StringSelection filepath = new StringSelection(absolutePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

        // create a robot object and simulate the pasted action on prompt window
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public WebElement warningMessage() // Only if you upload 5 photos
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
