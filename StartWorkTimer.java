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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StartWorkTimer {
	
		//set webdriver and string URL
		public static String Test_BidQA_URL = "http://test.bidqa.com/";
		public WebDriver driver = null;
		
		
@BeforeMethod
public void setup(){
		
		//invoke browser and open test.bidqa
		driver = new FirefoxDriver();
		driver.get(Test_BidQA_URL);
			
		//manage
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//maximize
		driver.manage().window().maximize();
		
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
public void quit(){
		
		//close browser
		driver.close();
			
		}
		
		@Test
		public void Start() throws InterruptedException, IOException{
		
		//manage
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on Projects in Progress
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu_buyer']/li[2]/a")).click();
			
		
		//click on start work timer
		Actions X = new Actions(driver);
		WebElement O = driver.findElement(By.xpath("//div[@id='main_wrapper']/div/div[1]/div[1]"));
		O.findElement(By.xpath("//button[text()='Start work timer']")).click();
		
		WebElement A = driver.findElement(By.xpath("//div[@class='panel-body']"));
		WebElement check = A.findElement(By.xpath("//input[@class='timer_accept']"));
		X.moveToElement(check).click().build().perform();
		
		//click on OK
		A.findElement(By.xpath("//input[@value='ok']")).click();
		
		//sleep
		Thread.sleep(5000);
		
		//screenshot
		File pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pic, new File("D:\\timerWORKING.png"));
		
		O.findElement(By.xpath("//button[text()='Stop work timer']")).click();
		
		//screenshot
		FileUtils.copyFile(pic, new File("D:\\timerSTOP.png"));
		
		
		}
}
