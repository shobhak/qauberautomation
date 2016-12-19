package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by erikfriedlander on 12/15/16.
 */
public class AddReportsOrganization {

    WebDriver driver;

    public AddReportsOrganization(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement nextButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[2]/ul/li/a/span"));
    }


    ///////////Old code, refactor and delete
    //TODO: extend to multiple organizations
    private By Organization1 = By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[2]/fieldset/div[2]/div/div/label/span");

    public void clickOrganization1() {
        driver.findElement(Organization1).click();
    }


}
