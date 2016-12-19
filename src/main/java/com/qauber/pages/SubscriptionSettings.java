package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Maksim on 12/19/2016.
 */
public class SubscriptionSettings {

    WebDriver driver;

    public SubscriptionSettings(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement cancelSubscriptionButton()
    {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.cancelSub()']"));
    }

    public WebElement changeSubscritionButton()
    {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.changeSub()']"));
    }

    public WebElement closeButton()
    {
        return driver.findElement(By.xpath("//button[@ng-click='closeThisDialog()']"));
    }

    public void slider(int x) // TODO Doesn't work !!!
    {
        WebElement slider = driver.findElement(By.className("slider slider-horizontal"));
        int width=slider.getSize().getWidth();
        Actions move = new Actions(driver);
        move.moveToElement(slider, ((width*x)/40), 0).click();
        move.build().perform();
    }
}
