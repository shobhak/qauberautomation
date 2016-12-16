package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by erikfriedlander on 12/14/16.
 */
public class AddReportVehicle {

    WebDriver driver;
    WebElement element;

    //Constructor
    public AddReportVehicle(WebDriver driver){

        this.driver = driver;

    }

    public WebElement pedestrianButton() {
        element = driver.findElement(By.xpath("//span[contains(@class,'fa fa-circle firepath-matching-node')]"));
        return element;
    }

    public WebElement pedestrianNextButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[2]/a"));
        return element;
    }

    public WebElement pedestrianPreviousButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[1]/a/span"));
        return element;
    }



    public WebElement passengerButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[1]/div[2]/div/label/span"));
        return element;
    }

    public WebElement passengerVehicleLicenseButton() {
        element = driver.findElement(By.xpath("//input[contains(@placeholder,'Vehicle License')])"));
        return element;
    }

    public WebElement passengerVehicleColorButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[5]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleMakeButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[2]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleYearButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[6]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleModelButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[3]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleOdditiesButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[7]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleBodyStyleButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[4]/div/div/input"));
        return element;
    }

    public WebElement passengerPreviousButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[1]/a/span"));
        return element;
    }

    public WebElement passengerNextButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[2]/a"));
        return element;
    }

    public WebElement driverButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[1]/div[3]/div/label/span"));
        return element;
    }

    public WebElement driverVehicleLicenseButton() {
        element = driver.findElement(By.xpath("//input[contains(@placeholder,'Vehicle License')])"));
        return element;
    }

    public WebElement driverVehicleColorButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[5]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleMakeButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[2]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleYearButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[6]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleModelButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[3]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleOdditiesButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[7]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleBodyStyleButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[4]/div/div/input"));
        return element;
    }

    public WebElement driverPreviousButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[1]/a/span"));
        return element;
    }

    public WebElement driverNextButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[2]/a"));
        return element;
    }

    ////////////////////// Old

    By pedestrianButton = By.xpath("//span[contains(@class,'fa fa-circle firepath-matching-node')]");
    By pedastrianNextButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[2]/a");
    By pedestrianPreviousButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[1]/a/span");

    By passengerButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[1]/div[2]/div/label/span");
    By passengerVehicleLicenseButton = By.xpath("//input[contains(@placeholder,'Vehicle License')])");
    By passengerVehicleColorButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[5]/div/div/input");
    By passengerVehicleMakeButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[2]/div/div/input");
    By passengerVehicleYearButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[6]/div/div/input");
    By passengerVehicleModelButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[3]/div/div/input");
    By passengerVehicleOdditiesButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[7]/div/div/input");
    By passengerVehicleBodystyleButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[4]/div/div/input");
    By passengerPriviousButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[1]/a/span");
    By passengerNextButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[2]/a");

    By driverButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[1]/div[3]/div/label/span");
    By driverVehicleLicenseButton = By.xpath("//input[contains(@placeholder,'Vehicle License')])");
    By driverVehicleColorButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[5]/div/div/input");
    By driverVehicleMakeButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[2]/div/div/input");
    By driverVehicleYearButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[6]/div/div/input");
    By driverVehicleModelButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[3]/div/div/input");
    By driverVehicleOdditiesButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[7]/div/div/input");
    By driverVehicleBodystyleButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[4]/div/div/input");
    By driverPriviousButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[1]/a/span");
    By driverNextButton = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[2]/a");


}


