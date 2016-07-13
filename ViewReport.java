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

public class ViewReport {

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
		wd.findElement(By.xpath("//html/body/div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td/div/div/a")).click();
		Thread.sleep(3000);
		
		//Step 3: Verify text "Report Information" present
		if(wd.getPageSource().contains("Report Information")){
			System.out.println("Test Case for View Report - Pass");
		}else{
			System.out.println("Text not present");}
		
		//Step 4: Take a screenshot	
		//Create random variable
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 1;
		
		File scr = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File("C:/Users/komandaa/Desktop/screenshot_view_report_" +n+ ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Step 9: Close browser
		wd.close();

	}

}
