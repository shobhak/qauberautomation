package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 12/15/16.
 */
public class AddReportsOrganization {

    WebDriver driver;

    //TODO: extend to multiple organizations
    By Organization1 = By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[2]/fieldset/div[2]/div/div/label/span");
    By NextButton = By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[2]/ul/li/a/span");


    public AddReportsOrganization(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrganization1() {
        driver.findElement(Organization1).click();
    }

    public void clickNextButton() {
        driver.findElement(NextButton).click();
    }

}
