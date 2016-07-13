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

public class AddReport {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");

		//Step1: Open Chrome
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		
		//login block
		wd.get("http://qabidder.net/fits-alfa/");
		Thread.sleep(5000);
		wd.findElement(By.id("exampleInputEmail1")).sendKeys(new String[]{"samiurkov+1@gmail.com"});
		wd.findElement(By.id("exampleInputPassword1")).sendKeys(new String[]{"test777"});
		wd.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();
		Thread.sleep(5000);
		
		//Step2: Click on "Add Report" link
		wd.findElement(By.xpath("/html/body/div[2]/aside[1]/div/nav/ul/li[3]/a/span")).click();
		
		Thread.sleep(5000);
		
		//Step3:Create random variable
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 1;
		
		//Step4: Print on "sam+n" "First name" field
		wd.findElement(By.name("first-name")).sendKeys(new String[]{"sam" +n});;
		
		//Step5: Click on "Next" button
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/ul/li/a")).click();
		
		//Step6: Check and print "truck" in Tattoo field and Click on "Next" button
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[2]/fieldset/div[1]/div[1]/div/div/span/input")).click();
		Thread.sleep(2000);
		wd.findElement(By.name("Tattoos")).sendKeys(new String[]{"Truck"});;
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[2]/ul/li[2]/a")).click();
		
		Thread.sleep(3000);
		
		//Step7: Click on "Next" button
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[3]/ul/li[2]/a/span")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[4]/ul/li[2]/a")).click();
		Thread.sleep(2000);		
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[5]/ul/li[2]/a")).click();
		Thread.sleep(2000);			
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[6]/ul/li[2]/a")).click();
		Thread.sleep(2000);		
		
		//Step8: Click on "Commit report" button
		wd.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[7]/div/p[2]/a[2]")).click();
		Thread.sleep(2000);		
		
		//Step 9: Verify text "sam" +n present
		if(wd.getPageSource().contains("sam" +n)){
			System.out.println("Test Case for Add Report - Pass");
		}else{
			System.out.println("Text not present");}
		
		//Step 8: Take a screenshot		
		File scr = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File("C:/Users/komandaa/Desktop/screenshot_add_report_" +n+ ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Step 9: Close browser
		wd.close();
	}

}
