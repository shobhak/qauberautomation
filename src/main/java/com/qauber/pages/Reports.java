package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 12/14/16.
 */
public class Reports {

    WebDriver driver;

    By containsText = By.xpath("/html/body/div/section/div/div/div/div/div[@class='input-group'][7]/input");

    By publishedOnCheckBox = By.xpath("/html/body/div/section/div/div/div/div/div[@class='input-group'][5]/span/label/span");

    //TODO: make this refer to multiple rows...
    By pictureRow1 = By.xpath("//*/li[@class='list-group-item ng-scope']/a/span[@class='ng-binding']");

    By searchResultsRow; //set in selectReport(int row)

    public Reports(WebDriver driver) {
        this.driver = driver;
    }

    public void setContainsText(String text) {
        driver.findElement(containsText).sendKeys(text);
    }

    public void selectReport(int row) {
        searchResultsRow = By.xpath(".//*//tr["+row+"]//a");
        driver.findElement(searchResultsRow).click();
    }
    public void selectReport() {
        selectReport(1);
    }

    public void clickPublishedOnCheckbox() {
        driver.findElement(publishedOnCheckBox).click();
    }

    public void clickPicture1() { //TODO: general pic get
        driver.findElement(pictureRow1).click();
    }
}