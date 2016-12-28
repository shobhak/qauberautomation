package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by erikfriedlander on 12/14/16.
 */
public class NavBar {

    WebDriver driver;
    WebElement element;

    //Constructor
    public NavBar(WebDriver driver){

        this.driver = driver;

    }

    public WebElement entitiesButton() {
        element = driver.findElement(By.xpath("//a[@title='Entities']"));
        return element;
    }

    public WebElement usersButton() {
        element = driver.findElement(By.xpath("//a[@title='Users']"));
        return element;
    }

    public WebElement addReportButton() {
        element = driver.findElement(By.xpath("//a[@title='Add Report']"));
        return element;
    }

    public WebElement reportsButton() {
        element = driver.findElement(By.xpath("//a[@title='Reports']"));
        return element;
    }
    public WebElement mainNavigationText() {
        element = driver.findElement(By.xpath("//nav[@class=\"sidebar\"]/ul/li[1]"));
        return element;
    }


    //Old code below for compatibility purposes
    //TODO: refactor and delete code at end

    By entities = By.xpath("/html/body/div/aside/div/nav[@class='sidebar']/ul/li[2]/a/span");
    By users = By.xpath("/html/body/div/aside/div/nav[@class='sidebar']/ul/li[3]/a/span");
    By addReport = By.xpath("/html/body/div/aside/div/nav[@class='sidebar']/ul/li[4]/a/span");
    By reports = By.xpath("/html/body/div/aside/div/nav[@class='sidebar']/ul/li[5]/a/span");




    public void clickEntities(){
        driver.findElement(entities).click();
    }

    public void clickUsers(){
        driver.findElement(users).click();
    }

    public void clickAddReport(){
        driver.findElement(addReport).click();
    }

    public void clickReports(){
        driver.findElement(reports).click();
    }

}
