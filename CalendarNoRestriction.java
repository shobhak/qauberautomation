package TestSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarNoRestriction {
	
	public static String URL = "http://test.bidqa.com/";
	public WebDriver driver = null;
	
	@BeforeMethod
	public void setUp(){
		
		driver = new FirefoxDriver();
		driver.get(URL);
		
		//manage
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		//maximize
		driver.manage().window().maximize();
				
		//Log In
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
				
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
							
		//click on submit
		Actions XXX = new Actions(driver);
		WebElement submit = driver.findElement(By.xpath("//input[@id='submits']"));
		XXX.click(submit).build().perform();	
		
	}
	
	@AfterMethod
	public void bQuit(){
		
		//close browser
		driver.close();
		
	}
	
	@Test
	public void noResCalendar() throws InterruptedException, IOException{
		
		//manage
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on post new
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[5]/a")).click();
		
		//click on project ending on
		driver.findElement(By.xpath("//*[@id='ending']")).click();
		
		//click on Next button from the calendar 60 times
		int next = 60;
		
		for(int i=0; i<next; i++){
			
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
		}
		
		//wait for 5 seconds and take screenshot
		Thread.sleep(5000);
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D://calendarNoRestriction.png"));
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Next']")).isEnabled(),"nextBtn is not clickable");
		
	}
}
