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

public class SubscribeNotifsInAllPages {
	
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
			
		driver.close();
			
		}
		
		@Test
		public void SubscribeMyAccountPage() throws Exception{
		
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on my account
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu']/li[1]/a")).click();
		
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
		public void SubscribeFinancesPage() throws Exception{
			
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			
		//hover on myaccount
		Actions X = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		X.moveToElement(myAcc).build().perform();
			
		//click on Finances
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/ul/li[2]/a")).click();
			
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
		public void SubscribePrivateMesssagePage() throws Exception{
			
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			
		//hover on myaccount
		Actions X = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		X.moveToElement(myAcc).build().perform();
			
		//click on private message
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/ul/li[3]/a")).click();
		
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
		public void SubscribePersonalInfoPage() throws Exception{
			
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
				
		//hover on myaccount
		Actions X = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		X.moveToElement(myAcc).build().perform();	
		
		//click on personal info
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/ul/li[4]/a")).click();
		
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
		public void SubscribeFandRPage() throws Exception{

		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
					
		//hover on myaccount
		Actions X = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		X.moveToElement(myAcc).build().perform();
		
		//click on feedbacks and reviews
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu']/li[6]/a")).click();
										
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
		public void SubscribeDisputesPage() throws Exception{

		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
						
		//hover on myaccount
		Actions X = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		X.moveToElement(myAcc).build().perform();
		
		//click on disputes
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/ul/li[6]/a")).click();
		
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
		public void zFilterSubscriptionBar() throws Exception{
			
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
							
		//hover on myaccount
		Actions X = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		X.moveToElement(myAcc).build().perform();	
		
		//click on my subscription
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu']/li[2]/a")).click();
		
		//enter keyword in the filter bar
		driver.findElement(By.xpath("//*[@id='filter']")).sendKeys("black box");
		
		//sleep
		Thread.sleep(3000);
		
		//validation
		String Result = driver.findElement(By.xpath("//*[@id='my_subscribtions']/tbody/tr[62]/td[3]")).getText();
		
		Assert.assertTrue(Result.contains("Black Box"), "Error: Filter function does not work.");
			
	
		}
		
}
