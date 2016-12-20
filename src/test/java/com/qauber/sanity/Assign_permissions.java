package com.qauber.sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by gaming on 12/13/2016.
 */
public class Assign_permissions {
    WebDriver driver = new ChromeDriver();
    public String loginPage = "http://testwave.qabidder.net/#/page/login";
    //admin account//:
    public String Email = "wave1@mailinator.com";
    public String Pswrd = "2328824";
    //super admin account:
//    public String Email = "";
//    public String Pswrd = "";

    public String UserName = "New Name";
    public String Rights = "Regular user"; // "Admin" or "Select Role"

    @BeforeTest
    public void login() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(loginPage);
        Thread.sleep(2500);
        WebElement element = driver.findElement(By.id("exampleInputEmail1"));
        element.sendKeys(Email);
        element = driver.findElement(By.id("exampleInputPassword1"));
        element.sendKeys(Pswrd);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@type='submit' and text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //commented out with slow internet
        //Assert.assertTrue(driver.findElement(By.cssSelector("button.btn.btn-labeled.btn-primary.btn-sm")).isEnabled());
        System.out.println("Logged in!");
    }
    @AfterTest
    public void logOut() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(900);//extra wait for slow internet
        driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//button[@ng-click='app.logout()']")).click();
        driver.quit();
    }

    @Test
    public void assign_permissions() throws InterruptedException, AWTException {
        //click Entities on left tab
        driver.findElement(By.xpath("//a[@title='Entities']")).click();

        //check Entities page open(header says Entities) with timeout 10sec
        Thread.sleep(500);//extra wait for slow internet
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Entities')]")).isDisplayed());

        // looking for list of "Assign permission" buttons.
        List<WebElement> list = driver.findElements(By.xpath("//button[@ng-show='!entity.locked']"));
        list.get(0).click();  //click first button for the first organization by number(diffrnt x-path to choose title)

        // looking for UserName and getting its number(listNo) into list of all users:
        int listNo = 0;
        list = driver.findElements(By.xpath("//div[text()= '"+UserName+"']"));
        for (int i=0; i<list.size(); i++){
            if(list.get(i).getText().equals(UserName))
            {
                listNo = i;
                break;
            }
        }
        // RIGHTS for listNo(found by USERNAME):
        list = driver.findElements(By.xpath("//select[@ng-model='user.assignedRole']"));
        //list.get(listNo).click();

        //dropdown menu for listNo(found by UserName):
        Select dropdown = new Select(list.get(listNo));

        //already selected into dropdown option(text) compared to Rights(new)
        if (((dropdown.getFirstSelectedOption()).getText()).equals(Rights)) {
            System.out.println("Rights already assigned!");
            //verifying dialox box opened
            // Thread.sleep(500);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ngdialog-overlay']")).isDisplayed());

        }
        else {
            System.out.printf("Assigning rights...");
            // choose Rights from dropdown list for same user
            dropdown.selectByVisibleText(Rights);

            //clicking  first active(orange) SAVE BUTTON
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//button[@class='btn btn-sm mr-sm btn-warning']")).click();

            //verify SAVE button for same user is not active(grey)
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            list = driver.findElements(By.xpath("//button[@class='btn btn-sm mr-sm']"));
            Assert.assertTrue(list.get(listNo).isDisplayed());
            System.out.println("DONE!");


        }
        //close dialog box by clicking ESC button
        Thread.sleep(1100);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
//        WebElement element = driver.findElement(By.id("//div[@class='ngdialog-close']"));
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", element);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//div[@class='ngdialog-content']")).click();
        //driver.findElement(By.xpath("//div[@class='wrapper ng-scope']")).click();
        //driver.findElement(By.cssSelector("pseudo:before")).click();
        //driver.findElement(By.cssSelector("ngdialog-close::before")).click();
//        driver.switchTo().frame("ngdialog1");
//        driver.findElement(By.id("//div[@class='ngdialog-close']")).click();
        //driver.switchTo().defaultContent();
        //((JavascriptExecutor) driver).executeScript("arguments[0].click()", ecrButton);
        //driver.findElement(By.xpath("//div[@class='ngdialog-close']")).click();



    }


}

