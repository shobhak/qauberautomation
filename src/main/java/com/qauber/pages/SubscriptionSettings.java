package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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

    public void slider(int x) // type value that you want to get
    {
        WebElement slider = driver.findElement(By.cssSelector(".slider-handle.min-slider-handle.round"));
        WebElement element = driver.findElement(By.xpath("//div[@class='slider-handle min-slider-handle round']"));
        Actions move = new Actions(driver);
        Action action;
        int i = 0;
        if (Integer.parseInt(element.getAttribute("aria-valuenow"))<=x)
        {
            while (Integer.parseInt(element.getAttribute("aria-valuenow")) != x) {
                action = move.dragAndDropBy(slider, i, 0).build();
                action.perform();
                i++;
            }
        }
        else
        {
            while (Integer.parseInt(element.getAttribute("aria-valuenow")) != x) {
                action = move.dragAndDropBy(slider, i, 0).build();
                action.perform();
                i--;
            }
        }
    }
}
