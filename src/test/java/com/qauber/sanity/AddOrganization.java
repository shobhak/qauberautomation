package com.qauber.sanity;

import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLSelectElement;
import com.github.javafaker.Faker;
import com.sun.jmx.snmp.tasks.ThreadService;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by lenochka on 07.12.2016.
 */


public class AddOrganization{
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //Faker elenasFaker = new Faker();

        driver.get("http://testwave.qabidder.net");
        //maximize the screen
        driver.manage().window().maximize();


        String password = "12345Qwer";
        String login = "bukreeva.e@gmail.com";


        Thread.sleep(3000);// automatically added throws InterruptedException
        //driver.findElement(By.id("exampleInputEmail1")).click();
        //driver.findElement(By.id("exampleInputEmail1")).sendKeys(login);

        driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).click();
        driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys(login);
        Thread.sleep(3000);

        //Thread.sleep(6000);// similar to click and wait
        driver.findElement(By.id("exampleInputPassword1")).click();
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        Thread.sleep(3000);


        driver.findElement(By.cssSelector("button.btn.btn-block.btn-primary.mt-lg")).click();
        Thread.sleep(2000);

        // click on entities
        //driver.findElement(By.xpath("/html/body/div[2]/aside[1]/div/nav/ul/li[2]/a/span")).click();
        driver.findElement(By.cssSelector("ul.nav.ng-scope > li:nth-child(2) > a > span")).click();
        Thread.sleep(2000);

        //Check for "The Name" organizaton

        //var myLink = driver.FindElementSafe(By.Id("myId"));
        /*if (myLink.Exists)
        {
            myLink.Click();
        }

*/
        //driver.findElement(By.xpath("//A[@class='a.ng-bindings'][text()='The Name']")).click();
        //if (driver.findElement(By.xpath("//A[@class='a.ng-bindings'][text()='The Name']")) == null){
            // Delete org
            //driver.findElement(By.xpath("//a[@href ='mailto:mail@mail.ru']")).click();

        //
        //click on add organization
        driver.findElement(By.cssSelector("button.pull-right.btn.btn-info.btn-sm.mt-sm.ng-binding")).click();
        Thread.sleep(1000);


        //Name field, click and enter data
        driver.findElement(By.name("name")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("name")).sendKeys("Theegvetrr Name");
        Thread.sleep(1000);

        //Phone field, click and enter data
        driver.findElement(By.name("phone")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        Thread.sleep(1000);

        //Email filed, click and enter data
        driver.findElement(By.name("email")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("mail@mail.com");
        Thread.sleep(1000);

        //Country field, select one
        driver.findElement(By.name("country")).sendKeys("Togo" + Keys.ENTER);
        driver.findElement(By.name("country")).click();
        Thread.sleep(1000);

        //Address field, select one
        driver.findElement(By.name("address1")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("address1")).sendKeys("123 Elm Street");
        Thread.sleep(2000);

        //City field, select one
        driver.findElement(By.name("city")).click();
        //Thread.sleep(1000);
        driver.findElement(By.name("city")).sendKeys("Elm City");
        driver.findElement(By.name("city")).sendKeys(Keys.PAGE_DOWN);
        //driver.findElement(By.name("city")).wait(5);
        Thread.sleep(1000);

        //State field, select one
        driver.findElement(By.cssSelector("input.form-control.state-control-animated.ng-pristine.ng-untouched.ng-empty.ng-invalid.ng-invalid-required")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.form-control.state-control-animated.ng-pristine.ng-untouched.ng-empty.ng-invalid.ng-invalid-required")).sendKeys("VAVA");;


        // Postal Code field, select one
        driver.findElement(By.name("zip")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("zip")).sendKeys("23998");

        //Click on the Next Step button
        driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right")).click();
        Thread.sleep(3000);

        //Invite regular users
        //driver.findElement(By.cssSelector("ng-pristine.ng-valid.ng-valid-own-email.ng-valid-multi-emails > "))
        //driver.findElement(By.xpath(".//*[@class='bootsrap-tagsinput']/input")).click();

        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[1]/div[2]/form/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div[1]/div[2]/form/div/div/input")).sendKeys("mail@mmail.cru");
        Thread.sleep(6000);



        //Click on the Next Step button (invite admin users)
        driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right")).click();
        Thread.sleep(6000);
        //driver.findElement(By.xpath("//A[@class='ng-binding'][text()='Next Step']")).click();

        // Click on the Done button
        driver.findElement(By.xpath("//*[@id='ngdialog1']/div[2]/div/button")).click();
        Thread.sleep(6000);

        //Click on the Next Step button (invite regular users)
        //driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right")).click();
        //Thread.sleep(2000);

        // Invite admin users
        driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[1]/div[3]/form/div/div/input")).click();
        driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[1]/div[3]/form/div/div/input")).sendKeys("adminuser@user.com");
        Thread.sleep(5000);


        //Click on the Next Step button (invite admin users)
        driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right")).click();
        Thread.sleep(2000);
        //Click on the second Done button
        driver.findElement(By.xpath("//*[@id='ngdialog2']/div[2]/div/button")).click();
        //driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(6000);


        //Click on the Finish button
        driver.findElement(By.cssSelector("button.btn.btn-info.btn-labeled > span.btn-label.btn-label-right")).click();
        Thread.sleep(2000);


        driver.quit();
    }


}
