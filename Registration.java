package Sanity_Check;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.TakesScreenshot;

public class Registration {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		
		//Step1: Open Chrome
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		
		//Step2: Go to fits-alfa URL 
		wd.get("http://qabidder.net/fits-alfa/");
		
		//Wait until load
		Thread.sleep(5000);
		
		//Step3: Click on "Register Now" button
		wd.findElement(By.linkText("Register Now")).click();	
		
		//Wait until load
		Thread.sleep(5000);
		
		//Step4:Create random variable
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 5;		
				
		//Step5: Enter Username: sam_test"n"
		wd.findElement(By.name("account_name")).sendKeys(new String[]{"sam_test" + n});
		
		//Step6: Enter Email: samiurkov+n@gmail.com
		wd.findElement(By.name("account_email")).sendKeys(new String[]{"amiurkov+" + n + "@gmail.com"});
		
		//Step7: Enter Password: test777
		wd.findElement(By.id("id-password")).sendKeys(new String[]{"test777"});	
		
		//Step8: Confirm Password: test777
		wd.findElement(By.name("account_password_confirm")).sendKeys(new String[]{"test777"});
		
		//Step9: Click on "Continue registration" button
		wd.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/form/button")).click();	
		
		//Step10: Click on "Finish registration" button
		wd.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/button")).click();		

		Thread.sleep(5000);
		
		//Step 11: Verify text "Registration successful" present
		if(wd.getPageSource().contains("Registration successful.")){
			System.out.println("Test Case for Registration - Pass");
		}else{
			System.out.println("Text not present");
		}

		//Step 12: Take a screenshot
		File scr = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File("C:/Users/komandaa/Desktop/screenshot_registration_" +n+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		//Step 13: Create LOGS
		
		

		//Step14: Close browser
		wd.close();
	}

}
