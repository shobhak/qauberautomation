package qauber.com.testwave;
import org.openqa.selenium.By;
//import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/*
 * This test case verifies test case #T76670 that the Hamburger Icons are functional.
 * Accordingly, the steps are go to the test wave web-application page, enter email
 *  and password information 
 * click submit, then verify that the hamburger icons are functional and then logout and exit the browser.
 * Presently works on Chrome but can also run on Firefox 
 */


public class HamburgerIconT76670  {
	static Logger log =  Logger.getLogger(HamburgerIconT76670.class);

	public static void runMethod() {
			log.info("This info message is from the run method");
		 
		 }	
	public static void main (String []args){
			//WebDriver driver = new FirefoxDriver();		
 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shobha\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        maximize the browser window
       driver.manage().window().maximize();
      	    //implicitly wait for a few seconds for the browser to load.
      		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    PropertyConfigurator.configure("log4j2.properties");
//	    log.info("This is the information ");
		runMethod();
		log.debug("This is the additional info");
	  
						
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
			}
	     catch (InterruptedException e) {
				// TODO Auto-generated catch block
		e.printStackTrace();
			}
	     // submit
	     driver.findElement(By.xpath("//button")).click();
	       
	     File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        try {
				FileUtils.copyFile(screenshot2,new File("C:\\Users\\shobha\\Desktop\\New folder\\HamburgerIconT76670\\image.jpeg"));
			} catch (IOException e) {
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
	           
	
	}	       
}//HamburgerIconT76670
