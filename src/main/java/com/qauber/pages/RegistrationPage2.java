package com.qauber.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by erikfriedlander on 12/18/16.
 */
public class RegistrationPage2 {
    WebDriver driver;
    Faker faker;
    int sleepTime;

    public RegistrationPage2(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement companyNameField() {
        return driver.findElement(By.xpath("//input[@name='name']"));
    }
    public WebElement contactPhoneField(){
        return driver.findElement(By.xpath("//input[@name='phone']"));
    }
    public WebElement contactEmailField(){
        return driver.findElement(By.xpath("//input[@name='email']"));
    }
    public WebElement companyLogoSelectButton(){
        return driver.findElement(By.xpath("//button[1]/span"));

    }
    public WebElement companyLogoDeleteButton(){
        return driver.findElement(By.xpath("//button[2]"));

    }
    public WebElement countryDropDownMenu(){
        return driver.findElement(By.xpath("//select[@name='country']"));
    }
    public WebElement addressField1(){
        return driver.findElement(By.xpath("//input[@name='address1']"));
    }
    public WebElement addressField2(){
        return driver.findElement(By.xpath("//input[@name='address2']"));
    }
    public WebElement cityField(){
        return driver.findElement(By.xpath("//input[@name='city']"));
    }
    public WebElement stateDropDownMenu(){
        return driver.findElement(By.xpath("//select[@name='state']"));
    }
    public WebElement postalCodeField(){
        return driver.findElement(By.xpath("//input[@name='zip']"));
    }
    public WebElement notesField(){
        return driver.findElement(By.xpath("//textarea"));
    }
    public WebElement finishRegistrationButton() {
        return driver.findElement(By.xpath("//button[@id='registerConfirm']"));
    }

    public void setRandomDataInFields() throws InterruptedException {
        //TODO: implement later? see RegisterAndActivateSAU
        //TODO: replace GenerateRandomSuperAdminUser code for this page with this...
        sleepTime = 5000;
        faker = new Faker(); //(new Locale("en-US"));
        companyNameField().sendKeys(faker.company().name());
        contactPhoneField().sendKeys(faker.phoneNumber().phoneNumber());
        contactEmailField().sendKeys(faker.internet().safeEmailAddress());
        Thread.sleep(sleepTime/2);

        //Default is United States, we don't have to do this
//        getRegistrationPage2().countryDropDownMenu().click();
//        getRegistrationPage2().countryDropDownMenu().sendKeys("United State");
//        Thread.sleep(sleepTime/2);

        addressField1().sendKeys(faker.address().streetAddress());
        cityField().sendKeys(faker.address().city());
        Thread.sleep(sleepTime/2);

//        stateDropDownMenu().click();
//        stateDropDownMenu().sendKeys(faker.address().state());
        Select stateDropDown = new Select(stateDropDownMenu());
        stateDropDown.selectByIndex(faker.number().numberBetween(1, 50));
        Thread.sleep(sleepTime);

        postalCodeField().sendKeys(faker.address().zipCode());
        Thread.sleep(sleepTime);

//        finishRegistrationButton().click();
    }

}
