package TestSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class QaeMarkProjDelivered {

	@Test
	public void bid() throws InterruptedException, IOException{
	// QA ENGINEER BID TO PROJECT
		
	//Invoke browser and Open Bidqa
	WebDriver driver = new FirefoxDriver();
	String URL = "http://test.bidqa.com/";
	driver.get(URL);
		
	//Manage timeouts
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	//Log In
	driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		
	//enter credentials
	driver.findElement(By.xpath("//input[@id='log']")).sendKeys("dezlozada");
	driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
	
	//click on submit
	Actions XXX = new Actions(driver);
	WebElement submit = driver.findElement(By.xpath("//input[@id='submits']"));
	XXX.click(submit).build().perform();
	
	//click on mark as delivered
	WebElement firstLine = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[1]/div[2]/div"));
	firstLine.findElement(By.xpath("//*[text()='Mark Delivered']")).click();
	
	//click on Yes, mark as delivered
	WebElement YES = driver.findElement(By.xpath("//input[@value='Yes, Mark Delivered!']"));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", YES);
	
	//validation
	String delivered = driver.findElement(By.xpath("//span[@class='zbk_zbk']")).getText();
	String Expected = "Awaiting buyer response.Marked as delivered on: 06-Jun-2016 14:54:36";
	if(delivered.equals(Expected)){
		
		System.out.println("Test Passed");
	}
	else
	{
		System.out.println("Test Failed");
	}
	
	//close
	driver.close();
	}
}
