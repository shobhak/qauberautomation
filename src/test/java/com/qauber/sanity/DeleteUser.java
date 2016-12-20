package com.qauber.sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by lenochka on 07.12.2016.
 */


public class DeleteUser {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net");

        String password = "12345Qwer";
        String login = "bukreeva.e@gmail.com";

        Thread.sleep(5000);// automatically added throws InterruptedException
        driver.findElement(By.id("exampleInputEmail1")).click();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(login);

        Thread.sleep(2000);// similar to click and wait
        driver.findElement(By.id("exampleInputPassword1")).click();
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        //Thread.sleep(6000);
        driver.findElement(By.cssSelector("button.btn.btn-block.btn-primary.mt-lg")).click();

        Thread.sleep(3000);// similar to click and wait

        //click on Users
        driver.findElement(By.xpath(".//*[@class='ng-binding'][text()='Users']")).click();
        Thread.sleep(4000);

        String userName = "manyusers@mail.ru";
        // If the user exist then delete the user
        if( !driver.findElements(By.xpath(".//*[@ng-href='mailto:"+userName+"']")).isEmpty()){
            //click on the Delete button
            driver.findElement(By.xpath(".//*[@ng-href='mailto:"+userName+"']/ancestor::*[5]/td[2]/button[4]")).click();
            Thread.sleep(3000);

            //driver.findElement(By.xpath("//*[@id='ngdialog2']/div[2]/div/button[1]")).click();
            driver.findElement(By.xpath(".//*[@class='btn btn-danger mr'][text()='Delete']")).click();
        }
        else {
            System.out.println("User not found!");
        }


        /*//click on the Delete button
        driver.findElement(By.xpath(".//*[@ng-href='mailto:'"+userName+"']/ancestor::*[5]/td[2]/button[4]")).click();
        Thread.sleep(3000);

        //driver.findElement(By.xpath("//*[@id='ngdialog2']/div[2]/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@class='btn btn-danger mr'][text()='Delete']")).click();*/



        Thread.sleep(20000);
        driver.close();
        driver.quit();


    }
}
