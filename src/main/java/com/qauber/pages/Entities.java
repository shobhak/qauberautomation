package com.qauber.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 12/16/16.
 */
public class Entities {

    WebDriver driver;

    public Entities(WebDriver driver) {
        this.driver = driver;
    }

//    public WebElement entityList() {
//        return entityList("Best");
//    }

//    //this is totally broken, don't use it
//    public WebElement entityList(String textTest) {
////        return driver.findElement(By.xpath("//tr[@class='ng-scope']/td[@class='pl-lg']/td[contains (text(), textTest]"));
//      return WebElement driver.findElement(By.xpath("//tr[@class='ng-scope']/td[@class='pl-lg']"));
//
//    }

}
