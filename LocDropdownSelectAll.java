package TestSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocDropdownSelectAll {
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
		//driver.close();
		
	}
	
	@Test
	public void SelectAllLoc() throws InterruptedException, IOException{
		
		//manage
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on Post New Project
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[5]/a")).click();
		
		//Go to Select Location
		WebElement sel = driver.findElement(By.xpath("//select[@id='do_input_new']"));
		System.out.println(sel.findElements(By.tagName("option")).size());
		int locs = sel.findElements(By.tagName("option")).size();
		
		for(int i=0; i<locs;i++){
			
			Select drop = new Select(sel);
			drop.selectByIndex(i);
		}
		
		//That will take a while since it has 305 locations. 
		
	
	}
}
