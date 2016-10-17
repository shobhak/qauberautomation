package qauber.com.testwave;
import java.io.File;
import java.util.*;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


import com.github.javafaker.Faker;



	/* This script is testing the Main Navigation of Wave Fit test wave application
	 * specifically testing T76674	Verify "Entities" link is functional. There is 
	 * login, checking the Entities link is functional and then logs out of the 
	 * application and exits the browser. This is on Chrome browser but can also run on Firefox
	/tester- Shobha Vaidyanathan 
	 **/

	public class EntitiesLinkT76675  {
		static Logger log =  Logger.getLogger(EntitiesLinkT76675.class);

		public static void runMethod() {
				log.info("This info message is from the run method");
			 
			 }	
		public static void main (String []args){
				//WebDriver driver = new FirefoxDriver();		
	 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\shobha\\chromedriver.exe");
		   PropertyConfigurator.configure("log4j3.properties");
		   log.info("This is the information ");
			runMethod();
			log.debug("This is the additional info");
			//WeDriver driver = new FirefoxDriver();
		   WebDriver driver = new ChromeDriver();
		 
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

	     //+++++++++++++++++++++++++++
            Faker faker = new Faker();
        	
            System.out.println(faker.lastName());
            
            
	        // click on Entities
	        driver.findElement(By.xpath("//li[5]/a/span")).click();	        
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        try {
				FileUtils.copyFile(screenshot2,new File("C:\\Users\\shobha\\Desktop\\New folder\\EntitiesLinkT76675\\image.jpeg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        //logout
	        driver.findElement(By.xpath("//ul[2]/li/a")).click();
	        //browser quit
	        driver.quit();
	           

	
		}//main
	}//Entities Link
	
	
	
