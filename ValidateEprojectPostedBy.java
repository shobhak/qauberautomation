package TestSuite;

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

public class ValidateEprojectPostedBy {
	
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
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("dezlozada");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
							
		//click on submit
		Actions XXX = new Actions(driver);
		WebElement submit = driver.findElement(By.xpath("//input[@id='submits']"));
		XXX.click(submit).build().perform();	
		
		
	}
	
	@AfterMethod
	public void dQuit(){
		
		//close
		driver.close();

	}

	@Test
	public void validateEProjectPB(){
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on first project
		driver.findElement(By.xpath("//div[@id='main_wrapper']/div/div[1]/div[2]/div/div[1]/a")).click();
		
		//validation
		String exp = driver.findElement(By.xpath("//li[@id='ad-other-details']/h3")).getText();
		String act = "Project Posted By";
		Assert.assertTrue(exp.equals(act), "Sorry, Project Posted By text was not found.");
		
		System.out.println("Element Validated");
		
		
	}

}
