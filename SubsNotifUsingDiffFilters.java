package fifth;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SubsNotifUsingDiffFilters {

		public WebDriver driver;
		public String URL = "http://test.bidqa.com";

		
		@BeforeTest
		public void setUp() throws Exception{
		
		//invoke browser and open test bidqa
		driver = new FirefoxDriver();
		driver.get(URL);
		
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//manage screen maximize
		driver.manage().window().maximize();
		
		//log in
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
						
		Thread.sleep(3000);
						
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("dezlozada");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
										
		//click on submit
		Actions XXX = new Actions(driver);
		WebElement submit = driver.findElement(By.xpath("//input[@id='submits']"));
		XXX.click(submit).build().perform();
		
		}
	
		
		@AfterTest
		public void tearDown(){
			
		//close browser	
		driver.close();
			
		}
		
		
		@Test
		public void UseCategoryFilter(){
		
		//manage timeout
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		
		//select any category
		Select drop = new Select(driver.findElement(By.xpath("//*[@id='category']")));
		drop.selectByIndex(1);
			
		//click on submit
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='subscribe-form']/button")));
			
		//validation
		WebElement Msg = driver.findElement(By.xpath("//*[@class='alert alert-success']"));
		Assert.assertTrue(Msg.isDisplayed(), "The element is not Displayed.");
		
		
		}
		
		
		@Test
		public void UseLocationFilter() throws Exception{
			
		//select any location 
		Select drop = new Select(driver.findElement(By.xpath(".//*[@id='location']")));
		drop.selectByIndex(5);
		
		//click on submit
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='subscribe-form']/button")));
		
		//wait
		Thread.sleep(2000);
		
		//validation
		WebElement Msg = driver.findElement(By.xpath("//div[text()='Successful! You have created a subscription.']"));		
		Assert.assertTrue(Msg.isDisplayed(), "The element is not Displayed.");	
			
			
		}
	
		@Test
		public void UsePriceFilter() throws Exception{
			
		//select any price
		Select drop = new Select(driver.findElement(By.xpath("//*[@id='subscribe-form']/div[3]/select")));
		drop.selectByIndex(5);

		//click on submit
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='subscribe-form']/button")));
		
		//wait
		Thread.sleep(1000);
		
		//validation
		WebElement Msg = driver.findElement(By.xpath("//div[text()='Successful! You have created a subscription.']"));		
		Assert.assertTrue(Msg.isDisplayed(), "The element is not Displayed.");
		
			
		}
		
		@Test
		public void UseCombinationFilter() throws Exception{
		
		WebElement cat = driver.findElement(By.xpath("//*[@id='category']"));
		WebElement loc = driver.findElement(By.xpath(".//*[@id='location']"));
		WebElement pri = driver.findElement(By.xpath("//*[@id='subscribe-form']/div[3]/select"));
		
		Select drop = new Select(cat);
		drop.selectByIndex(1);
		
		Select drop2 = new Select(loc);
		drop2.selectByIndex(5);
		
		Select drop3 = new Select(pri);
		drop3.selectByIndex(5);
		
		//click on submit
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='subscribe-form']/button")));
				
		//wait
		Thread.sleep(2000);
				
		//validation
		WebElement Msg = driver.findElement(By.xpath("//div[text()='Successful! You have created a subscription.']"));		
		Assert.assertTrue(Msg.isDisplayed(), "The element is not Displayed.");
		
		}
		
		@Test
		public void VerifyToolTip(){
			
			//hover to what is it
			WebElement tooltip = driver.findElement(By.xpath("//*[@id='tooltip']"));
			Actions X = new Actions(driver);
			X.moveToElement(tooltip).build().perform();
			
			//get tooltip value
			String msg = tooltip.getAttribute("data-original-title");
			
			//validation
			String TTmsg = tooltip.getText();
			Assert.assertTrue(tooltip.isDisplayed());
			System.out.println(TTmsg + " = " +msg );


			
			
		}
		
}
