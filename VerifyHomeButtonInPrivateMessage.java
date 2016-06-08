package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class VerifyHomeButtonInPrivateMessage {

	public static void main(String[] args) {
		//invoke browser and open bidqa
		WebDriver driver = new FirefoxDriver();
		String Url = "http://test.bidqa.com";
		
		driver.get(Url);
		
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//click log in
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
				
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
		
		//click on submit
		driver.findElement(By.xpath("//input[@id='submits']")).click();
		
		//declare Action class
		Actions XXX = new Actions(driver);
		
		//identify the myAccount element
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		
		//hover your mouse on myAccount
		XXX.moveToElement(myAcc).build().perform();
		
		//click on private messages
		driver.findElement(By.linkText("Private Messages")).click();
		
		//click on inbox
		driver.findElement(By.xpath("//*[@id='content']/div[1]/div/ul/li[3]/a")).click();
		
		String inboxURL = driver.getCurrentUrl();
		
		//click on home messaging
		driver.findElement(By.xpath("//*[@id='content']/div[1]/div/ul/li[1]/a")).click();
		
		String homeURL = driver.getCurrentUrl();
		
		if(inboxURL.equals(homeURL))
		{
			System.out.println("Test Failed");
		}
		
		else
		{
			System.out.println("Test Passed");
		}
		
		
		//close browser
		driver.close();
		

	}

}