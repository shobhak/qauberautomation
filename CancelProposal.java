package fourth;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CancelProposal {
	
	public static String URL = "http://test.bidqa.com/";
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{

		//invoke browser and open test.bidqa
		driver = new FirefoxDriver();
		driver.get(URL);
		
		//manage window maximize
		driver.manage().window().maximize();
		
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
	public void tearDown(){
		
		//driver.close();
		
	}
		
	@Test
	public void cancelProp() throws IOException{
		
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on active projects
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu_seller']/li[2]/a")).click();
		
		//click on first project
		driver.findElement(By.xpath("//div[@id='main_wrapper']/div/div[1]/div[1]/div/div[1]/a")).click();
		
		//Take Screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D://proposalBefore.png"));
		
		//click on X button
		WebElement first = driver.findElement(By.xpath("//*[@id='my_bids']/div[1]"));
		first.findElement(By.xpath("//*[@alt='Delete']")).click();
		
		//enter reason
		driver.findElement(By.xpath("//*[@id='main']/div/div[1]/div/div/form/textarea")).sendKeys("I already have employees, sorry.");
		
		//click on yes remove
		WebElement OK = driver.findElement(By.xpath("//input[@value='Yes, Remove!']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", OK);
		
		//Take Screenshot
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("D://proposalAfter.png"));
		
		
		
		
		
		
		
		
		
	}
}
