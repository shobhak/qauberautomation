package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenochka on 15.12.2016.
 */
public class AddReportIdentificationInformation {
    WebDriver driver;


    /*By primaryLanguage = By.name("primary-language");
    By streetAddress = By.name("street-address");
    By city = By.name("city");
    By country = By.name("country");
    By state = By.name("state");
    By zip = By.name("zip");
    By phone = By.name("phone");
    By email = By.name("email");
    By ssn = By.name("socialSecurity");
    By occupation = By.name("occupation");
    By driverLicense = By.name("driverLicense");
    By otherID = By.name("other-id");
    By schoolName = By.name("school-name");
    By parentName = By.name("parent-name");
    By employerName = By.name("employer-name");
    By previousButton = By.xpath(".//*[@class='previous']/a/span");
    By nextButton = By.xpath(".//*[@class='next']/a");
*/

    //Constructor
    public AddReportIdentificationInformation(WebDriver driver){

        this.driver = driver;

    }

    WebElement element;

    public WebElement primaryLanguageField() {
        element = driver.findElement(By.name("primary-language"));
        return element;
    }

    public WebElement streetAddressField() {
        element = driver.findElement(By.name("street-address"));
        return element;
    }

    public WebElement cityField() {
        element = driver.findElement(By.name("city"));
        return element;
    }

    public WebElement stateField() {
        element = driver.findElement(By.name("state"));
        return element;
    }

    public WebElement zipField() {
        element = driver.findElement(By.name("zip"));
        return element;
    }

    public WebElement phoneField() {
        element = driver.findElement(By.name("phone"));
        return element;
    }

    public WebElement emailField() {
        element = driver.findElement(By.name("email"));
        return element;
    }

    public WebElement ssnField() {
        element = driver.findElement(By.name("socialSecurity"));
        return element;
    }

    public WebElement occupationField() {
        element = driver.findElement(By.name("occupation"));
        return element;
    }


    public WebElement driverLicenseField() {
        element = driver.findElement(By.name("driverLicense"));
        return element;
    }

    public WebElement otherIDField() {
        element = driver.findElement(By.name("other-id"));
        return element;
    }

    public WebElement schoolNameField() {
        element = driver.findElement(By.name("school-name"));
        return element;
    }

    public WebElement parentNameField() {
        element = driver.findElement(By.name("parent-name"));
        return element;
    }

    public WebElement employerNameField() {
        element = driver.findElement(By.name("employer-name"));
        return element;
    }


    public WebElement previousButtonField() {
        element = driver.findElement(By.name(".//*[@class='previous']/a/span"));
        return element;
    }

    public WebElement nextButtonField() {
        element = driver.findElement(By.name(".//*[@class='next']/a"));
        return element;
    }
    /*public void setPrimaryLanguage(String strPrimaryLanguage) {
        driver.findElement(PrimaryLanguage).sendKeys(strPrimaryLanguage);
    }


    public void setStreetAddress(String strStreetAddress) {
        driver.findElement(StreetAddress).sendKeys(strStreetAddress);
    }


    public void setCity(String strCity) {
        driver.findElement(City).sendKeys(strCity);
    }
*/







}


