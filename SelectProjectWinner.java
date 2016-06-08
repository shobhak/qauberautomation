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
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class SelectProjectWinner {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Create Firefox Profile  
		FirefoxProfile profile = new FirefoxProfile();  
		// Accept Untrusted Certificates  
		profile.setAcceptUntrustedCertificates(true); 
		profile.setAssumeUntrustedCertificateIssuer(false);
				
		//Invoke browser
		WebDriver driver = new FirefoxDriver(profile);
		String URL = "http://test.bidqa.com/";
		driver.get(URL);
				
		//Manage timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//Log in 
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
		driver.findElement(By.xpath("//input[@id='submits']")).click();
		
		//click mouse over MyAccount
		Actions XXX = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		XXX.click(myAcc).build().perform();
		
		//Sleep
		Thread.sleep(5000);
		
		//click on first project
		WebElement firstLine = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[1]/div[2]/div/div[1]/a"));
		firstLine.click();
		
		//click on Select as a Winner
		driver.findElement(By.linkText("Select as Winner")).click();
		
		//Sleep
		Thread.sleep(5000);
		
		//click on Choose a winner 
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement choose = driver.findElement(By.xpath("//input[@value='choose a winner']"));
		jse.executeScript("arguments[0].click()", choose);
		
		//Take a screenshot
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("D://ProjectWinner.png"));
		
		//validation
		String Expected = "Project Winner";
		String Actual = driver.findElement(By.xpath("//*[@id='my_bids']/div/div[6]")).getText();
		
		if(Expected.equals(Actual))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		driver.close();
	}

}
