package TestSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressMatchesWithMapPointer {
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
		
		//Enter Project Title
		driver.findElement(By.xpath("//input[@name='project_title']")).sendKeys("My Final Project");
				
		//Enter Project Description
		driver.findElement(By.xpath("//textarea[@name='project_description']")).sendKeys("Simple Project");
				
		//Select Category
		WebElement XXX = driver.findElement(By.xpath("//textarea[@placeholder='Describe here your project scope.']"));
		XXX.sendKeys(Keys.TAB);
				  
		WebElement YYY = driver.findElement(By.xpath("//*[@id='content']/div/div/div[2]/form/ul/li[6]/div"));
		YYY.sendKeys(Keys.TAB);
		driver.switchTo().activeElement().click();
				
		//Select Skills
		WebElement ZZZ = driver.findElement(By.xpath("//*[@id='content']/div/div/div[2]/form/ul/li[6]/div/label[15]/input"));
		ZZZ.sendKeys(Keys.TAB);
				  
		WebElement AAA = driver.findElement(By.xpath("//*[@id='content']/div/div/div[2]/form/ul/li[9]/div[1]"));
		AAA.sendKeys(Keys.TAB);
		driver.switchTo().activeElement().click();
				  
		//Select Project Budget from dropdown list
		Select drop = new Select(driver.findElement(By.name("budgets")));
		drop.selectByValue("8");
				
		//Set Project Ending Date
		driver.findElement(By.xpath("//input[@id='ending']")).click();
		driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
				
		for(int i=0;i<5;i++)
		{
			driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
				
		//click on date
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[6]/a")).click();
				
		//click done in the calendar
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button")).click();
		
		//Select location by Value
		Select loc = new Select(driver.findElement(By.xpath("//select[@id='do_input_new']")));
		loc.selectByValue("4749");
	
		//Enter address
		driver.findElement(By.xpath("//*[@name='project_location_addr']")).sendKeys("5019 Sonora Court Sunnyvale CA, 94086");

		//Click Next Step
		WebElement Submit = driver.findElement(By.name("project_submit1"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", Submit);

		//Click on Featured Project CheckBox
		driver.findElement(By.xpath("//input[@name='featured']")).click();
				
		//Click on Next Step
		WebElement Next = driver.findElement(By.xpath("//input[@name='project_submit2']"));
		jse.executeScript("arguments[0].click();", Next);
	
		//NO WAY TO USE VALIDATION/ASSERTION HERE SO I JUST TOOK A SCREENSHOT
		//NEED TO TAKE A LOOK AT THE MAP IF IT'S POINTING THE RIGHT LOCATION
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D://MAPshouldMatchwithLoc.png"));
		
		
		
	
	}
	
}
