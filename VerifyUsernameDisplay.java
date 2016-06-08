package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class VerifyUsernameDisplay {

	public static void main(String[] args) {
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
		
		//verify Username
		String ActualUN = driver.findElement(By.xpath("//input[@name='new_user_name']")).getAttribute("value");
		String ExpectedUN = "lozadadez1";
		
		if(ActualUN.equals(ExpectedUN))
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
