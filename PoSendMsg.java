package TestSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PoSendMsg {

		public static String Test_BidQA_URL = "http://test.bidqa.com/";
		public WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		
		//invoke browser and open test.bidqa
		driver = new FirefoxDriver();
		driver.get(Test_BidQA_URL);
				
		//Log In
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		
		Thread.sleep(3000);
		
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
						
		//click on submit
		Actions XXX = new Actions(driver);
		WebElement submit = driver.findElement(By.xpath("//input[@id='submits']"));
		XXX.click(submit).build().perform();
				
		}
			
	@AfterMethod
	public void quit(){
		
		//close browser
		//driver.close();
				
		
		}
		
	@Test
	public void SendMsg(){
		
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on active projects
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu_seller']/li[2]/a")).click();
		
		//click on projects
		WebElement pro = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[1]/div[1]/div"));
		pro.findElement(By.xpath("//*[text()='My Final Project']")).click();
		
		//click on send message
		WebElement send = driver.findElement(By.xpath("//*[@id='my_bids']/div"));
		send.findElement(By.xpath("//*[text()='Send Message']")).click();
		
		//enter message to the field
		WebElement O = driver.findElement(By.xpath("//*[@id='subject_a']"));
		O.sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Hello! How are you?");
		
		//click on submit
		WebElement click = driver.findElement(By.xpath("//*[@id='form5']/table/tbody/tr[5]/td[2]/input"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", click);
		
		//verify
		String Msg = driver.findElement(By.xpath("//*[@id='content']/div[3]/div")).getText();
		Assert.assertEquals(Msg, "Your message to user Dezlozada has been sent.");
		
		System.out.println(Msg);
		
		//close browser
		driver.close();
	}
}
