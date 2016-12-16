package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by erikfriedlander on 12/14/16.
 */
public class Reports {

    WebDriver driver;
    WebElement element;
    Select select;

    public Reports(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement lastNameField()
    {
        element = driver.findElement(By.xpath("//input[@ng-model='slnSearchKey']"));
        return element;
    }

    public WebElement firstNameField()
    {
        element = driver.findElement(By.xpath("//input[@ng-model='sfnSearchKey']"));
        return element;
    }

    public WebElement caseIdField()
    {
        element = driver.findElement(By.xpath("//input[@ng-model='ciSearchKey']"));
        return element;
    }

    public Select suspectType()
    {
        select = new Select(driver.findElement(By.xpath("//select[@ng-model='stSearchKey']")));
        return select;
    }

    public WebElement publishedOnCheckBox()
    {
        element = driver.findElement(By.xpath("//input[@ng-model='enablePublishedOn']"));
        return element;
    }

    public WebElement containsTextField()
    {
        element = driver.findElement(By.xpath("//input[@ng-model='ctSearchKey']"));
        return element;
    }

    public WebElement pagination(String numberOfPage)
    {
        element = driver.findElement(By.linkText(numberOfPage));
        return element;
    }

    public WebElement selectReport(int row)
    {
        element = driver.findElement(By.xpath("//tr["+row+"]//a"));
        return element;
    }

    public void selectReport()
    {
        selectReport(1);
    }

    public WebElement exportReportsListButton()
    {
        element = driver.findElement(By.cssSelector(".pull-right.btn.btn-info.btn-sm"));
        return element;
    }

    public void publishedDateFrom(String startMonth, String startDay, String startYear) // Example of Date format ("January", "01", "2000")
    {
        driver.findElement(By.xpath("//button[@ng-click='openedSearchFrom=true']")).click();
        driver.findElement(By.xpath("//th[@colspan='6']/button")).click();
        driver.findElement(By.xpath("//th[@colspan='1']/button")).click();
        driver.findElement(By.xpath("//span[text()='"+startYear.substring(2,4)+"']")).click();
        driver.findElement(By.xpath("//span[text()='"+startMonth+"']")).click();
        driver.findElement(By.xpath("//span[text()='"+startDay+"']")).click();
    }

    public void publishedDateFrom(String keyWord) // Variants of keyWord: "Close", "Clear", "Today"
    {
        driver.findElement(By.xpath("//button[@ng-click='openedSearchFrom=true']")).click();
        driver.findElement(By.xpath("//button[text()='"+keyWord+"']")).click();

    }

    public void publishedDateTo(String endMonth, String endDay, String endYear) // Example of Date format ("January", "01", "2000")
    {
        driver.findElement(By.xpath("//button[@ng-click='openedSearchTo=true']")).click();
        driver.findElement(By.xpath("//th[@colspan='6']/button")).click();
        driver.findElement(By.xpath("//th[@colspan='1']/button")).click();
        driver.findElement(By.xpath("//span[text()='"+endYear.substring(2,4)+"']")).click();
        driver.findElement(By.xpath("//span[text()='"+endMonth+"']")).click();
        driver.findElement(By.xpath("//span[text()='"+endDay+"']")).click();
    }

    public void publishedDateTo(String keyWord) // Variants of keyWord: "Close", "Clear", "Today"
    {
        driver.findElement(By.xpath("//button[@ng-click='openedSearchTo=true']")).click();
        driver.findElement(By.xpath("//button[text()='"+keyWord+"']")).click();
    }





    //Old code below for compatibility purposes
    //TODO: refactor and delete code at end

    By lastName = By.xpath("//input[@ng-model='slnSearchKey']");
    By firstName = By.xpath("//input[@ng-model='sfnSearchKey']");
    By CaseID = By.xpath("//input[@ng-model='ciSearchKey']");
    By suspectType = By.xpath("//select[@ng-model='stSearchKey']");
    By publishedOnCheckBox = By.xpath("//input[@ng-model='enablePublishedOn']");
    By containsText = By.xpath("//input[@ng-model='ctSearchKey']");
    By pagination = By.linkText("");
    By pictureRow1 = By.xpath("//*/li[@class='list-group-item ng-scope']/a/span[@class='ng-binding']");
    By searchResultsRow; //set in selectReport(int row)

    public void setContainsText(String text) {
        driver.findElement(containsText).sendKeys(text);
    }

    public void selectReport1(int row) {
        searchResultsRow = By.xpath(".//*//tr["+row+"]//a");
        driver.findElement(searchResultsRow).click();
    }
    public void selectReport1() {
        selectReport(1);
    }

    public void clickPublishedOnCheckbox() {
        driver.findElement(publishedOnCheckBox).click();
    }

    public void clickPicture1() { //TODO: general pic get
        driver.findElement(pictureRow1).click();
    }
}