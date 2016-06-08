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
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateSealed {

	@Test
	public void sealedBidding() throws InterruptedException, IOException{
		
		//ADD sealed bidding PROJECT 
		
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
				
		//CREATE A PROJECT**
				
		//Click on Post New 
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
		loc.selectByValue("5337");
				
		//Enter address
		driver.findElement(By.xpath("//*[@name='project_location_addr']")).sendKeys("123 Olala Avenue, Greece");
		
		//Click Next Step
		WebElement Submit = driver.findElement(By.name("project_submit1"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", Submit);
				
		//Click on Featured Project CheckBox
		driver.findElement(By.xpath("//input[@name='private_bids']")).click();
		
		//Click on Next Step
		WebElement Next = driver.findElement(By.xpath("//input[@name='project_submit2']"));
		jse.executeScript("arguments[0].click();", Next);
				
		//Click on Next Step
		WebElement Next1 = driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div[3]/a[2]"));
		jse.executeScript("arguments[0].click();", Next1);
				
		//Click on Agree CheckBox
		WebElement CheckBox = driver.findElement(By.xpath("//*[@id='cb-payment']"));
		jse.executeScript("arguments[0].click();", CheckBox);
				
		WebElement BBB = driver.findElement(By.xpath("//*[@id='content']/div/div/a[2]"));
		jse.executeScript("arguments[0].click();", BBB);
				
		Thread.sleep(5000);
				
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
		FileUtils.copyFile(SrcFile, new File("D:\\SealedProject.png"));
				
		String SealedLogo = driver.findElement(By.xpath("//*[@class='private_thing_project']")).getText();
		Assert.assertEquals(SealedLogo, "Sealed Bidding");
		System.out.println("Element: " + SealedLogo + " is present");
		
		//close
		driver.close();
		
		/*//Click on My Projects
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a")).click();
				
		//Click on active projects
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu_seller']/li[2]/a")).click();
				
		Thread.sleep(5000);
				
		//Validation
		WebElement firstLine = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[1]/div[1]/div"));
		String Expected = "My Final Project"; 				
		String Actual = firstLine.findElement(By.linkText("My Final Project")).getText();										
				
		if(Expected.equals(Actual))
			{
				System.out.println("Test Passed");
			}
		else
			{
				System.out.println("Test Failed");
			}
				
				
		//close browser
		driver.close();*/
	
		
		
		
	}
	
	
}
