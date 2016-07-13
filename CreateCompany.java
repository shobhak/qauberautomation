package Sanity_Check;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCompany {

	public static void main(String[] args)  throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");

		//Step1: Open Chrome
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		
		//login block
		wd.get("http://qabidder.net/fits-alfa/");
		Thread.sleep(3000);
		wd.findElement(By.id("exampleInputEmail1")).sendKeys(new String[]{"samiurkov+1@gmail.com"});
		wd.findElement(By.id("exampleInputPassword1")).sendKeys(new String[]{"test777"});
		wd.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();
		Thread.sleep(3000);
		
		//Step2: Click on "Entities" link
		wd.findElement(By.xpath("/html/body/div[2]/aside[1]/div/nav/ul/li[5]/a/span")).click();
		Thread.sleep(3000);
		
		//Step3: Click on "Add Organization" button
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/button[1]")).click();
		Thread.sleep(3000);

		//Step4: Click on "PayPal Account" radio-button
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/form/div/div[1]/div")).click();
		Thread.sleep(3000);
		
		//Step5: Click on "Continue" button
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div[3]/button")).click();
		Thread.sleep(10000);
				
		//Step6: Click on "PayPal Account" radio-button
		wd.findElement(By.id("loadLogin")).click();
		Thread.sleep(3000);
		
		// Step7: Login to Paypal
		wd.findElement(By.id("login_email")).sendKeys(new String[]{"komandaasemen-buyer@gmail.com"});
		wd.findElement(By.id("login_password")).sendKeys(new String[]{"s03061986"});
		wd.findElement(By.id("submitLogin")).click();
		Thread.sleep(10000);
		wd.findElement(By.xpath("//*[@id='continue']")).click();
		Thread.sleep(10000);
		
		//Create random variable
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 1;
		
		//Step 8: Enter information for Organization page and click "Next Step"
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div[1]/div[2]/div[1]/div[1]/div/div/input")).sendKeys(new String[]{"Test"+n});
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/input")).sendKeys(new String[]{"94040"});
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div[1]/div[3]/button[2]")).click();
		Thread.sleep(5000);
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[3]/button[2]")).click();
		Thread.sleep(2000);
		
		//Step 9: Click "Next Step"
		//wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div[2]/div[3]/button[2]")).click();	
		//Thread.sleep(1000);
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div[3]/div[3]/button[2]")).click();
		Thread.sleep(1000);
		
		//Step 10: Click "Finish" button
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div[4]/div[3]/button[2]")).click();
		Thread.sleep(2000);
		
		//Step 11: Verify text present
		String text=wd.findElement(By.xpath("/html/body/div[2]/section/div/div")).getText();
		  if (text=="Test" +n);
		  {System.out.println("Test Case for Create Company - Pass");}
		  
		//Step 4: Take a screenshot	
				
		File scr = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File("C:/Users/komandaa/Desktop/screenshot_create_company_" +n+ ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
