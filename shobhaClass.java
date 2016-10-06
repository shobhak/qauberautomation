import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
/*
 * This test case verifies the login and logout functionality of the testwave 
 * web application on a Chrome Browser using Eclipse IDE for Selenium Webdriver with Java. 
 * Accordingly, the steps are go to the login page, enter email and password information 
 * click submit and then logout and exit the browser.
 */

public class shobhaClass {

	public static void main (String []args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shobha\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		//webpage
		driver.get("http://testwave.qabidder.net/#/page/login");
		//wait
		Thread.sleep(1000);
		
		//email field
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();
        driver.findElement(By.xpath("//input")).sendKeys("dummyemail1938+4@gmail.com");
         //take screenshot and save it in a file
         File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //copy the file to the required path
        FileUtils.copyFile(screenshot,new File("C:\\Users\\shobha\\Desktop\\New folder.jpeg"));

        //password field
        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).clear();
        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("Thisis4u");

        File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot2,new File("C:\\Users\\shobha\\Desktop\\New folder.jpeg"));
        //wait
        Thread.sleep(2000);
        // submit
        driver.findElement(By.xpath("//button")).click();

        Thread.sleep(2000);
        //logout
        driver.findElement(By.xpath("//ul[2]/li/a")).click();
        //browser quit
        driver.quit();
           
	
	}  
	}

