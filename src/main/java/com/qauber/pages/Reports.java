package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 12/15/16.
 * Modified by Ala on 12/20/16.
 */
public class Reports {

    WebDriver driver;
    Select select;

    public Reports(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement lastNameField()
    {
        return driver.findElement(By.xpath("//input[@ng-model='slnSearchKey']"));
    }

    public WebElement firstNameField()
    {
        return driver.findElement(By.xpath("//input[@ng-model='sfnSearchKey']"));
    }

    public WebElement caseIdField()
    {
        return driver.findElement(By.xpath("//input[@ng-model='ciSearchKey']"));
    }

    public void suspectType(String type) //Set suspect type: "", "R/P", "Suspect", "Victim", "Witness", "Other"
    {
        select = new Select(driver.findElement(By.xpath("//select[@ng-model='stSearchKey']")));
        select.selectByValue(type);
    }

    public WebElement publishedOnCheckBox()
    {
        return driver.findElement(By.xpath("//input[@ng-model='enablePublishedOn']"));
    }

    public WebElement containsTextField()
    {
        return driver.findElement(By.xpath("//input[@ng-model='ctSearchKey']"));
    }

    public WebElement pagination(String numberOfPage) // To return last page in pagination type "last"
    {
        if (numberOfPage.equals("last"))
        {
            ArrayList<WebElement> list = new ArrayList<WebElement>(paginationSum());
            return list.get(list.size()-1);
        }
        else
        {
            return driver.findElement(By.linkText(numberOfPage));
        }
    }

    public WebElement selectReport(int row) // Set the position of row, to select last report on the page type "last"
    {
            return driver.findElement(By.xpath("//tr[" + row + "]//a"));
    }
    public WebElement selectReport(String last) {
        if (last.equals("last")) {
            ArrayList<WebElement> list = new ArrayList<WebElement>(reportsRows());
            return list.get(list.size() - 1);
        } else
        {
            return selectReport();
        }
    }
    public WebElement selectReport()
    {
        return selectReport(1);
    }

    public WebElement exportReportsListButton()
    {
        return driver.findElement(By.cssSelector(".pull-right.btn.btn-info.btn-sm"));

    }

    public void publishedDateFromIcon(String startMonth, String startDay, String startYear) // Example of Date format ("January", "01", "2000")
    {
        driver.findElement(By.xpath("//button[@ng-click='openedSearchFrom=true']")).click();
        calendar(startMonth, startDay, startYear);
    }

    public void publishedDateFromIcon(String keyWord) // Set name of button: "Close", "Clear", "Today"
    {
        driver.findElement(By.xpath("//button[@ng-click='openedSearchFrom=true']")).click();
        driver.findElement(By.xpath("//button[text()='"+keyWord+"']")).click();
    }

    public void publishedDateToIcon(String endMonth, String endDay, String endYear) // Example of Date format ("January", "01", "2000")
    {
        driver.findElement(By.xpath("//button[@ng-click='openedSearchTo=true']")).click();
        calendar(endMonth, endDay, endYear);
    }

    public void publishedDateToIcon(String keyWord) // Set name of button: "Close", "Clear", "Today"
    {
        driver.findElement(By.xpath("//button[@ng-click='openedSearchTo=true']")).click();
        driver.findElement(By.xpath("//button[text()='"+keyWord+"']")).click();
    }

    public void createdDateFromIcon(String startMonth, String startDay, String startYear) // Example of Date format ("January", "01", "2000")
    {
        driver.findElement(By.xpath("//button[@ng-click='openedCreatedFrom=true']")).click();
        calendar(startMonth, startDay, startYear);
    }

    public void createdDateFromIcon(String keyWord) // Set name of button: "Close", "Clear", "Today"
    {
        driver.findElement(By.xpath("//button[@ng-click='openedCreatedFrom=true']")).click();
        driver.findElement(By.xpath("//button[text()='"+keyWord+"']")).click();

    }

    public void createdDateToIcon(String endMonth, String endDay, String endYear) // Example of Date format ("January", "01", "2000")
    {
        driver.findElement(By.xpath("//button[@ng-click='openedCreatedTo=true']")).click();
        calendar(endMonth, endDay, endYear);
    }

    public void createdDateToIcon(String keyWord) // Set name of button: "Close", "Clear", "Today"
    {
        driver.findElement(By.xpath("//button[@ng-click='openedCreatedTo=true']")).click();
        driver.findElement(By.xpath("//button[text()='"+keyWord+"']")).click();
    }

    public void calendar(String Month, String Day, String Year)
    {
        driver.findElement(By.xpath("//th[@colspan='6']/button")).click();
        driver.findElement(By.xpath("//th[@colspan='1']/button")).click();
        driver.findElement(By.xpath("//span[text()='" + Year.substring(2, 4) + "']")).click();
        driver.findElement(By.xpath("//span[text()='" + Month + "']")).click();
        driver.findElement(By.xpath("//span[text()='" + Day + "']")).click();
    }

    // added on 12/20/16
    public WebElement clearButton(){
        return driver.findElement(By.cssSelector(".btn.btn-labeled.btn-primary"));
    }

    //added on 12/22/16
    public WebElement searchReportResultID(int rowNumber){
        return driver.findElement(By.xpath("//tr["+rowNumber+"]//div[@class='row'][1]/div[@class='col-lg-12']/h4[@class='ng-binding']"));
    }

    public WebElement searchResultPhoto(int rowindex){
        return driver.findElement(By.xpath("//tr[@class='ng-scope'][" + rowindex + "]/td/div/a/img"));
    }

    //added on 12/26/2016
    public WebElement searchReportResultPublishedDate(String startMonth, String startDay, String startYear)
    {
        return driver.findElement(By.xpath("//span[text()='"+startMonth.substring(0,3)+" "+startDay+", "+startYear+"']"));
    }

    public WebElement activePagination()
    {
        return driver.findElement(By.xpath("//li[@class='ng-scope active']/a"));
    }

    public List<WebElement> reportsRows()
    {
        return driver.findElements(By.cssSelector(".btn.btn-info.btn-sm.ng-scope"));
    }

    public List<WebElement> paginationSum()
    {
        return driver.findElements(By.xpath("//a[@ng-click='setCurrent(pageNumber)']"));
    }

    public WebElement caseIdResult(int reportNumber)
    {
        List<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.xpath("//div[@class='col-sm-1']/span")));
        return list.get(reportNumber-1);
    }

    public WebElement searchReportResultPublishedDate(int reportNumber)
    {
        List<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.xpath("//div[@class='col-sm-3 text-right']/span")));
        return list.get(reportNumber-1);
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

    public void clickPublishedOnCheckbox() {
        driver.findElement(publishedOnCheckBox).click();
    }

    public void clickPicture1() { //TODO: general pic get
        driver.findElement(pictureRow1).click();
    }

}