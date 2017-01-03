package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    // added on 12/26/2016
    public WebElement pageHeader()
    {
        return driver.findElement(By.xpath("html/body/div[2]/section/div/h3"));
    }


    ///////////Old code, refactor and delete
    //TODO: extend to multiple organizations
    private By Organization1 = By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[2]/fieldset/div[2]/div/div/label/span");

    public List<WebElement> entitiesList() {return  driver.findElements(By.xpath("//label[@class='ng-binding']"));}

    public void clickOrganization1() {
        driver.findElement(Organization1).click();
    }


}
