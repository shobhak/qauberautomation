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

    public void slider(int x) throws InterruptedException // type value that you want to get (from 5 to 40)
    {
        WebElement slider = driver.findElement(By.cssSelector(".slider-handle.min-slider-handle.round"));
        WebElement element = driver.findElement(By.xpath("//div[@class='slider-handle min-slider-handle round']"));
        Actions move = new Actions(driver);
        Action action;
        int i = 0;
        while (Integer.parseInt(element.getAttribute("aria-valuenow")) != x)
        {
            action = move.dragAndDropBy(slider, i / 3, 0).build();
            action.perform();

            if (Integer.parseInt(element.getAttribute("aria-valuenow")) < x)
            {
                i++;
            }
            else
            {
                i--;
            }
        }
    }

    public void sliderByPercent(int x) throws InterruptedException {
        WebElement slider = driver.findElement(By.cssSelector(".slider-handle.min-slider-handle.round"));
        WebElement element = driver.findElement(By.xpath("//div[@class='slider-handle min-slider-handle round']"));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, -300, 0).build();
        action.perform();
        Thread.sleep(10000);
        Action action2 = (Action) move.dragAndDropBy(slider, x, 0).build();
        action2.perform();
    }
}
