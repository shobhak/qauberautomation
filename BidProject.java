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
import org.testng.annotations.Test;

public class BidProject {

	@Test
	public void bid() throws InterruptedException, IOException{
		// QA ENGINEER BID TO PROJECT
		
		//Invoke browser and Open Bidqa
		WebDriver driver = new FirefoxDriver();
		String URL = "http://test.bidqa.com/";
		driver.get(URL);
		
		//Manage timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		
		//Click on All Projects
		driver.findElement(By.linkText("All Projects")).click();
		
		//Sleep
		Thread.sleep(5000);
		
		//Type Automation KeyWord unto Search field
		driver.findElement(By.xpath("//input[@id='my-top-search-input']")).sendKeys("My Final Project");
		
		//Click on Search Icon/Logo
		driver.findElement(By.xpath("//input[@id='my-top-submit-input']")).click();
		
		//Sleep
		Thread.sleep(5000);
		
		//Select First Search Result
		WebElement search = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[1]/div[1]/div"));
														
		//click on project
		for(int i=0; i<6; i++)
		{
			search.sendKeys(Keys.TAB);
		}

		driver.switchTo().activeElement().click();
		
		//click on Submit a Proposal
		driver.findElement(By.xpath("//a[@id='submit-proposal-id']")).click();
		
		//Enter bid amount, days to finish and description
		driver.findElement(By.xpath("//input[@id='bid']")).sendKeys("10" + Keys.TAB + "10" + Keys.TAB + "I can do it!" );
		
		//click on checkbox agreement
		WebElement check = driver.findElement(By.xpath("//*[@id='submits_crt_check']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", check);
		
		//Click on Submit 
		WebElement submit1 = driver.findElement(By.xpath("//input[@value='Place Bid']"));
		jse.executeScript("arguments[0].click();", submit1);
		
		//Sleep
		Thread.sleep(5000);
		
		//Decided to take a screenshot
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
		FileUtils.copyFile(SrcFile, new File("D:\\bidding.png"));
					
		//validation
		String Expected = "Your bid has been posted.";
		String Actual = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/div[1]/div")).getText();
		
		if(Expected.equals(Actual))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		//close browser
		driver.close();
	
	}

}
