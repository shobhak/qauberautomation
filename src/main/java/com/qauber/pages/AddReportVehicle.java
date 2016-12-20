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
    public WebElement previousButton;

    //Constructor
    public AddReportVehicle(WebDriver driver){

        this.driver = driver;

    }

    public WebElement pedestrianButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[1]/div[1]/div/label/span"));
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

    public WebElement passengerVehicleLicenseField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[1]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleColorField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[5]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleMakeField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[2]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleYearField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[6]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleModelField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[3]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleOdditiesField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[7]/div/div/input"));
        return element;
    }

    public WebElement passengerVehicleBodyStyleField() {
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

    public WebElement driverVehicleLicenseField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[1]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleColorField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[5]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleMakeField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[2]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleYearField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[6]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleModelField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[3]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleOdditiesField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[7]/div/div/input"));
        return element;
    }

    public WebElement driverVehicleBodyStyleField() {
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
    By passengerVehicleModelField = By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[2]/div[3]/div/div/input");
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


