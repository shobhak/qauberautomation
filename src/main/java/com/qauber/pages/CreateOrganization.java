package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenochka on 22.12.2016.
 */
public class CreateOrganization {
   WebDriver driver;



    public CreateOrganization(WebDriver driver) {

        this.driver = driver;
    }

    WebElement element;

    public WebElement entityNameField() {
        element = driver.findElement(By.xpath(".//input[@name = 'name']"));
        return element;
    }

    public WebElement entityPhoneField() {
        element = driver.findElement(By.xpath(".//input[@name = 'phone']"));
        return element;
    }

    public WebElement entityEmailField() {
        element = driver.findElement(By.xpath(".//input[@name = 'email']"));
        return element;
    }

    public WebElement entityCountryDropDown(String entityCountry) {
        element = driver.findElement(By.xpath(".//select[@name = 'country']/ option [@value = 'AT']"));
        return element;
    }

    public WebElement entityAddress1() {
        element = driver.findElement(By.xpath(".//input[@name = 'address1']"));
        return element;
    }

    public WebElement entityAddress2() {
        element = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[1]/div[1]/form/div[2]/div[1]/div[4]/input"));
        return element;
    }

    public WebElement entityCity() {
        element = driver.findElement(By.xpath(".//input[@name = 'city']"));
        return element;
    }

    public WebElement entityState() {
        element = driver.findElement(By.xpath(".//input[@name = 'state']"));
        //For DropDownMenu in case USA is selected before
        // element = driver.findElement(By.xpath(".//select[@name = 'state']/ option [@value = 'IA']"));
        return element;
    }

    public WebElement entityPostalCode() {
        element = driver.findElement(By.xpath(".//input[@name = 'zip']"));
        return element;
    }

    public WebElement entityNextButtone() {
        element = driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right"));
        return element;
    }


    public WebElement inviteRegularUserEmailField() {
        element = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[1]/div[2]/form/div/div/input"));
        return element;
    }

    public WebElement inviteRegularUserNextButton() {
        element = driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right"));
        return element;
    }

    public WebElement inviteRegularUserDoneButton() {
        element = driver.findElement(By.xpath("//*[@id='ngdialog1']/div[2]/div/button"));
        return element;
    }

    public WebElement inviteAdminUserEmailField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[1]/div[3]/form/div/div/input"));
        return element;
    }

    public WebElement inviteAdminUserNextButton() {
        element = driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right"));
        return element;
    }

    public WebElement inviteAdminUserDoneButton() {
        element = driver.findElement(By.xpath("//*[@id=\"ngdialog2\"]/div[2]/div/button"));
        return element;
    }


    public  WebElement finishButton(){
        element = driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right"));
        return element;
    }

    public WebElement payWithMyPayPal(){

        return driver.findElement(By.xpath("//*[@id='loadLogin']"));
    }

    public WebElement loginField() {
        element = driver.findElement(By.xpath("//*[@id='login_email']"));
        return element;
    }

    public WebElement passwordField() {
        //element = driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/button[2]/span[1]");
        element = driver.findElement(By.xpath("//*[@id='login_password']"));
        return element;
    }

    public WebElement logInButton(){
        element = driver.findElement(By.xpath("//*[@id='submitLogin']"));
        return element;
    }

    public WebElement agreeAndContinueButton(){
        element = driver.findElement(By.xpath("//*[@id='continue']"));
        return element;
    }
}
