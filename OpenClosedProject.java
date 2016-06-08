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

public class OpenClosedProject {

	public static void main(String[] args) throws InterruptedException {
		//OPEN A CLOSED PROJECT
		
		//Create Firefox Profile
		FirefoxProfile fp = new FirefoxProfile();
		
		// Accept Untrusted Certificates
		fp.setAcceptUntrustedCertificates(true);
		fp.setAssumeUntrustedCertificateIssuer(false);
		
		//Invoke browser and Open bidqa
		WebDriver driver = new FirefoxDriver(fp);
		String URL = "http://test.bidqa.com/";
		driver.get(URL);
		
		//Manage timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//Log in 
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
		driver.findElement(By.xpath("//input[@id='submits']")).click();
		
		//Click on My Projects
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a")).click();
		
		//Sleep
		Thread.sleep(5000);
		
		//Click on Close Projects
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu_seller']/li[3]/a")).click();
								
		//Sleep
		Thread.sleep(5000);
		
		//Click on the first project
		WebElement firstLine = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[1]/div[1]/div"));										
		firstLine.findElement(By.linkText("My Final Project")).click();
		
		//Click on Report button
		driver.findElement(By.linkText("Repost")).click();
		
		//Click on Project Ending On
		driver.findElement(By.xpath("//input[@id='ending']")).click();
		
		//Set Date
		for(int i=0; i<3; i++)
		{
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/a[2]/span")).click();
		}
		
		//Click on Date
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[5]")).click();
		
		//Click on Done button
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button")).click();
		
		//Sleep
		Thread.sleep(5000);
		
		//Click on Publish Project
		WebElement nextB = driver.findElement(By.xpath("//*[@id='repost-form-submit']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", nextB);
		
		//click on pay via PayPal
		WebElement PP = driver.findElement(By.xpath("//*[@id='content']/div/div/div/table/tbody/tr[17]/td/a[1]"));
		jse.executeScript("arguments[0].click();", PP);
		
		//click on pay with paypal
		Actions xzy = new Actions(driver);
		WebElement PayPal = driver.findElement(By.xpath("//*[@id='loadLogin']"));
		xzy.click(PayPal).build().perform();
						
		//enter email
		WebElement email = driver.findElement(By.xpath("//*[@id='login_email']"));
		email.sendKeys("dezlozada-buyer@yahoo.com");
						
		//enter password
		WebElement password = driver.findElement(By.xpath("//*[@id='login_password']"));
		password.sendKeys("dennisqa123");
						
		//click on login
		WebElement Lbutton = driver.findElement(By.xpath("//*[@id='submitLogin']"));
		xzy.moveToElement(Lbutton).click().build().perform();
				
		Thread.sleep(5000);
				
		//Click Pay Now
		WebElement Now = driver.findElement(By.xpath("//*[@id='continue_abovefold']"));
		jse.executeScript("arguments[0].click();", Now);
				
		Thread.sleep(5000);
				
		//click on "Go to PayPal account overview"
		WebElement link = driver.findElement(By.xpath("//*[@id='doneInfo']/ul/li[1]/span/span/input"));
		xzy.click(link).build().perform();
				
		Thread.sleep(5000);
			
		//Pop-up appears. Manage it
		driver.switchTo().alert().accept();
				
		//Decided to take a screenshot
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
					
			FileUtils.copyFile(SrcFile, new File("D:\\Image-of-the-newly-Opened-Project.png"));
					
			}
				
		catch(IOException e) 
			{
					
			e.printStackTrace();
			}	
				
		//Click on My Projects
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a")).click();
				
		//Click on active projects
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu_seller']/li[2]/a")).click();
				
		Thread.sleep(5000);
				
		//Validation
		WebElement firstLine1 = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[1]/div[1]/div"));
		String Expected = "My Final Project"; 				
		String Actual = firstLine1.findElement(By.linkText("My Final Project")).getText();
		
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
