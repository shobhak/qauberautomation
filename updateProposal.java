package fourth;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class updateProposal 
		{
		public static String url = "http://test.bidqa.com";
		public WebDriver driver;
		
		
	
		@BeforeMethod
		public void setUp() throws Exception{
		
				//invoke browser and open test.bidqa
				driver = new FirefoxDriver();
				driver.get(url);
				
				//manage wait
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//manage window maximize
				driver.manage().window().maximize();
				
				//Log In
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
	
		@AfterMethod
		public void tearDown(){
		
				//driver close
				driver.close();
	
			}
		
		@Test
		public void Update(){
			
				//manage wait
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//click on my proposals
				driver.findElement(By.xpath("//*[@id='my-account-admin-menu_buyer']/li[5]/a")).click();
				
				//click on one project
				driver.findElement(By.xpath("//div[@id='content']/div[1]/div/div[1]/a")).click();
				
				//click on update proposal
				driver.findElement(By.xpath("//*[@id='submit-proposal-id']")).click();
				
				//Edit description
				driver.findElement(By.xpath("//textarea[@name='description2']")).sendKeys("hey, updated. Thanks");
				
				//click on checkbox agreement
				driver.findElement(By.xpath("//*[@id='submits_crt_check']")).click();
				
				//click place bid
				driver.findElement(By.xpath("//*[@id='submits_crt']")).click();
				
				//validate
				String confirmation = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/div[1]/div")).getText();
				
				Assert.assertEquals(confirmation, "Your bid has been posted.");
				
				System.out.println("Proposal Updated");
				
				
			
			
			
			
			
		}
	
	
		
		
		
		}