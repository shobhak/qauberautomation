package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 12/14/16.
 */
public class NavBar {

    WebDriver driver;
    By entities = By.xpath("/html/body/div/aside/div/nav[@class='sidebar']/ul/li[2]/a/span");
    By users = By.xpath("/html/body/div/aside/div/nav[@class='sidebar']/ul/li[3]/a/span");
    By addReport = By.xpath("/html/body/div/aside/div/nav[@class='sidebar']/ul/li[4]/a/span");
    By reports = By.xpath("/html/body/div/aside/div/nav[@class='sidebar']/ul/li[5]/a/span");

    //Constructor
    public NavBar(WebDriver driver){

        this.driver = driver;

    }


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
