package qauber.com.testwave;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;

/*
 * This test case verifies test case #T76670 that the Hamburger Icons are functional.
 * Accordingly, the steps are go to the test wave web-application page, enter email
 *  and password information 
 * click submit, then verify that the hamburger icons are functional and then logout and exit the browser.
 * Presently works on Chrome but can also run on Firefox 
 */


public class HamburgerIconT76670 extends newlogMsg2file {
	
	public static void main (String []args){
		    
		   // System.setProperty("webdriver.chrome.driver", "C:\\Users\\shobha\\chromedriver.exe");        
	
			WebDriver driver = new FirefoxDriver();
			//WebDriver driver = new ChromeDriver();
						
			//webpage
			driver.get("http://testwave.qabidder.net/#/page/login");
			
			//wait
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//email field
	        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();
	        driver.findElement(By.xpath("//input")).sendKeys("dummyemail1938+4@gmail.com");
	      
	        //password field
	        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).clear();
	        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("Thisis4u");
	        //wait
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // submit
	        driver.findElement(By.xpath("//button")).click();
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //take screenshot and save it in a file
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	       
	        Date date = new Date();
	        System.out.println(dateFormat.format(date));
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //copy the file to the required path
            try {
				FileUtils.copyFile(screenshot,new File("C:\\Users\\shobha\\Desktop\\screenshot.jpeg" +dateFormat));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
	        //Check whether Navigation panel is functional
             new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.nav.ng-scope"))).click();
             try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
             // logout  
	        driver.findElement(By.xpath("//ul[2]/li/a")).click();
	        try {
				Thread.sleep (1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        //browser quit
	        driver.quit();
	           
	}//main
}//HamburgerIconT76670
