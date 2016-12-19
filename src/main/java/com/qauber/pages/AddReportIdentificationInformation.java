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
    By driverState = By.dropList("driverState");
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
    //*[@class='ng-binding'][text()='Kruger td'] //

    /*public WebElement orgCheckbox(String org) {
        //element = driver.findElement(By.xpath(".//*[@class='ng-binding'][text()='Kruger Ltd']/span"));
        element = driver.findElement(By.xpath(".//*[@class='ng-binding'][text()='"+org+"']/span"));
        return element;
    } */

    public WebElement cityField() {
        element = driver.findElement(By.name("city"));
        return element;
    }

    public WebElement countryField() {
        element = driver.findElement(By.name("country"));
        return element;
    }

    public WebElement stateField() {
        element = driver.findElement(By.name("state"));
        return element;
    }

    public WebElement stateDropList(String strStateUS) {
        driver.findElement(By.xpath(".//select[@ng-show='showStatesDropDown']")).click();
        element = driver.findElement(By.xpath(".//option[@class='ng-binding ng-scope'][text()='"+strStateUS+"']"));
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

    public WebElement driverlicenseDropList(String strState) {
        //driver.findElement(By.xpath(".//*[@ng-model = 'wizard.report.dlState']")).click();
        element = driver.findElement(By.xpath(".//select[@ng-model='wizard.report.dlState']/option[contains(text(),'"+strState+"')]"));
        return element;
    }


    public WebElement otherIDField() {
        element = driver.findElement(By.name("other-id"));
        return element;
    }

    public WebElement otherIDState() {
        element = driver.findElement(By.xpath(".//select[@ng-model='wizard.report.otherIdState']/option[contains(text(),'Nevada')]"));
        return element;
    }

    public WebElement otherIDType() {
        element = driver.findElement(By.xpath(".//input[@ng-model = 'wizard.report.otherIdType']"));
        return element;
    }

    public WebElement schoolNameField() {
        element = driver.findElement(By.name("school-name"));
        return element;
    }

    public WebElement schoolAddress() {
        element = driver.findElement(By.xpath(".//input[@placeholder = 'School Address']"));
        return  element;

    }

    public WebElement schoolCity() {
        element = driver.findElement(By.xpath(".//input[@placeholder = 'School City']"));
        return  element;

    }

    public WebElement schoolStateDropList(String strStatte) {
        element = driver.findElement(By.xpath(".//*[@ng-model = 'wizard.report.schoolState']/option[contains(text(), 'Texas')]"));
        return  element;
    }

    public  WebElement schoolZip(){
        element = driver.findElement(By.xpath(".//*[@placeholder = 'School Zip']"));
        return element;
    }

    public WebElement schoolTelephone(){
        element = driver.findElement(By.xpath("//*[@placeholder = 'School Telephone']"));
        return element;
    }

    //public WebElement

    public WebElement parentNameField() {
        element = driver.findElement(By.name("parent-name"));
        return element;
    }

    public WebElement parentAddressField() {
        element = driver.findElement(By.xpath(".//*[@placeholder = 'Parent Address']"));
        return element;
    }

    public WebElement parentCityField() {
        element = driver.findElement(By.xpath(".//*[@placeholder = 'Parent City']"));
        return element;
    }

    public WebElement parentDropList(String strSttate) {
        element = driver.findElement(By.xpath(".//*[@ng-model = 'wizard.report.parentState']/ option[contains (text(), 'Utah' )]"));
        return element;
    }
    // (".//select[@ng-model='wizard.report.otherIdState']/option[contains(text(),'Nevada')]"));


    public WebElement parentZipField() {
        element = driver.findElement(By.xpath(".//*[@placeholder = 'Parent Zip']"));
        return element;
    }


    public WebElement parentTelephoneField() {
        element = driver.findElement(By.xpath(".//*[@placeholder = 'Parent telephone']"));
        return element;
    }

    public WebElement employerNameField() {
        element = driver.findElement(By.name("employer-name"));
        return element;
    }
    public WebElement employerAddressField() {
        element = driver.findElement(By.xpath(".//*[@placeholder = 'Employer Address']"));
        return element;
    }

    public WebElement employerCityField() {
        element = driver.findElement(By.xpath(".//*[@placeholder = 'Employer City']"));
        return element;
    }

    public WebElement employerStateDropList(String strSState) {
        element = driver.findElement(By.xpath(".//*[@ng-model = 'wizard.report.employerState']/ option[contains (text(), 'Guam' )]"));
        return element;
    }

    public WebElement employerZipField() {
        element = driver.findElement(By.xpath(".//*[@placeholder = 'Employer Zip']"));
        return element;
    }

    public WebElement employerTelephoneField() {
        element = driver.findElement(By.xpath(".//*[@placeholder = 'Employer Telephone']"));
        return element;
    }


    public WebElement nextButton() {
        element = driver.findElement(By.xpath(".//*[@ng-click = 'wizard.go(5)']"));
        return element;
    }

    public WebElement previousButton() {
        element = driver.findElement(By.xpath(".//*[@ng-click = 'wizard.go(3)']"));
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

        //.//label[@class = 'needsclick'][text() = 'Narco']/span
    }
*/







}


