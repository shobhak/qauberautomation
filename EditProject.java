package TestSuite;

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

public class EditProject {
	
	public static String Test_BidQA_URL = "http://test.bidqa.com/";
	public WebDriver driver = null;

	@BeforeMethod
	public void setUp() throws InterruptedException{
	
	//invoke browser and open test.bidqa
	driver = new FirefoxDriver();
	driver.get(Test_BidQA_URL);
	
	//maximize window
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
	public void quit(){
	
	//close browser
	//driver.close();
			
	}
	
	@Test
	public void Update() throws IOException{
		
	//manage timeouts
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	//select project - first line - click on Edit Project 
	WebElement firstLine = driver.findElement(By.xpath("//*[@id='main_wrapper']/div/div[1]/div[2]"));
	WebElement editBtn = firstLine.findElement(By.xpath("//a[text()='Edit Project']"));
	Actions X = new Actions(driver);
	X.click(editBtn).build().perform();
	
	//Enter any tags into tag fields
	driver.findElement(By.cssSelector("[name='project_tags']")).clear();
	driver.findElement(By.cssSelector("[name='project_tags']")).sendKeys("Automation");
	
	//Click on Sav
	WebElement saveBtn = driver.findElement(By.cssSelector("[value='Save Project']"));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click()", saveBtn);
	
	//validation
	String Msg = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div")).getText();
	String Exp = "Your project has been updated and is live now. Click here to see your project.";
	
	if(Msg.contains(Exp)){
		System.out.println("Test Passed");
	}
	else
	{
		System.out.println("Test Failed");
	}
	
	//click Click here
	driver.findElement(By.xpath("//*[text()='Click here']")).click();
	
	//take screenshot
	File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("D://EditProjectImage.png"));
	
	//close browser
	driver.close();
		
		
	}





}
