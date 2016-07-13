package Sanity_Check;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;

//import java.io.File;

//import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.util.concurrent.TimeUnit;

//import com.sun.jna.platform.FileUtils;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		
		//Step1: Open Chrome
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		
		//Step2: Go to fits-alfa URL 
		wd.get("http://qabidder.net/fits-alfa/");
		
		//Wait until load
		Thread.sleep(5000);
		//wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//Random rand = new Random();
		//int  n = rand.nextInt(1000) + 5;	
		
		//Step3: Enter Username: samiurkov+1@gmail.com
		wd.findElement(By.id("exampleInputEmail1")).sendKeys(new String[]{"samiurkov+1@gmail.com"});
		
		//Step4: Enter Password: test777
		wd.findElement(By.id("exampleInputPassword1")).sendKeys(new String[]{"test777"});
		
		//Step5: Click on "Login" button
		wd.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();

		//Wait until load
		Thread.sleep(5000);
		
		//Step 6: Verify text "Reports" present
		if(wd.getPageSource().contains("Reports")){
			System.out.println("Test Case for Login - Pass");
		}else{
			System.out.println("Text not present");
		}
				
		//Step7:Create random variable
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 1;
		
		//Step 8: Take a screenshot		
		File scr = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File("C:/Users/komandaa/Desktop/screenshot_login_" +n+ ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		//Step 9: Create LOGS
		
		//Step 10: Close browser
		wd.close();

	}

}
