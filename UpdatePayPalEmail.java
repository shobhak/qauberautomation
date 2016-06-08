package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class UpdatePayPalEmail {

	public static void main(String[] args) throws InterruptedException {
		// invoke browser
		WebDriver driver = new FirefoxDriver();
						
		//open site
		String URL = "http://test.bidqa.com";
		driver.get(URL);
						
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
										
		//click log in
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
										
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
								
		//click on submit
		driver.findElement(By.xpath("//input[@id='submits']")).click();
						
		//hover to my account
		Actions XXX = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		XXX.moveToElement(myAcc).build().perform();
						
		//click on personal info
		driver.findElement(By.linkText("Personal Info")).click();
		
		
		
		//webElement paypal email class
		WebElement payPal1 = driver.findElement(By.xpath("//input[@name='paypal_email']"));
		
		String EmailBefore = payPal1.getText();
		
		payPal1.clear();
		payPal1.sendKeys("dezlozada-buyer@gmail.com");
		
		
		//WebElement Save button class
		WebElement button = driver.findElement(By.xpath("//input[@value='Save']"));
		JavascriptExecutor X = (JavascriptExecutor) driver;
		X.executeScript("arguments[0].click();", button);
		
		//Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		
		WebElement payPal2 = driver.findElement(By.xpath("//input[@name='paypal_email']"));
		
		String EmailAfter = payPal2.getText();
		
		if(EmailBefore!=EmailAfter)
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		
		payPal2.clear();
		payPal2.sendKeys("dezlozada-buyer@yahoo.com");
		
		
		//WebElement Save button class
		WebElement button1 = driver.findElement(By.xpath("//input[@value='Save']"));
		JavascriptExecutor X1 = (JavascriptExecutor) driver;
		X1.executeScript("arguments[0].click();", button1);
		
		//close browser
		driver.close();
	}

}
