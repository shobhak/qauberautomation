package fourth;

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

public class VerifyWonProject {
		
		public static String URL = "http://test.bidqa.com";
		public WebDriver driver;
		
		@BeforeMethod
		public void setup(){
		
			driver = new FirefoxDriver();
			driver.get(URL);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Log In
			driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
			
			//enter credentials
			driver.findElement(By.xpath("//input[@id='log']")).sendKeys("dezlozada");
			driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
			
			//click on submit
			Actions XXX = new Actions(driver);
			WebElement submit = driver.findElement(By.xpath("//input[@id='submits']"));
			XXX.click(submit).build().perform();
			
		}
		
		@AfterMethod
		public void tearDown(){
			
			driver.close();
			
		}
		
		@Test
		public void verifyWonP() throws InterruptedException, IOException{
			
			//manage timeouts
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//click on projects I've won
			driver.findElement(By.xpath("//*[@id='my-account-admin-menu_buyer']/li[1]/a")).click();
			
			//get title
			System.out.println(driver.getTitle());
			String pageTitle = driver.getTitle();
			Assert.assertTrue(pageTitle.equals("BidQA | Projects I’ve Won"));
			
			//click on first project
			driver.findElement(By.xpath("//div[@class='padd10']/div[1]/a")).click();
			
			//wait 5sec
			Thread.sleep(5000);
			
			WebElement bidflag = driver.findElement(By.xpath("//i[@class='bid-flag']"));
			
			Assert.assertTrue(bidflag.isDisplayed(),"Error, you didn't win this project.");
			
			//get screenshot
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("D://ProjectWinnerElementvalidation.png"));
			
			
			
			
		}
}
