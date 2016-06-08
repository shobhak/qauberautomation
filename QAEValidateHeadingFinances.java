package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class QAEValidateHeadingFinances {

	public static void main(String[] args) {
		// invoke browser and open bidqa
		WebDriver driver = new FirefoxDriver();
				
		String Url = "http://test.bidqa.com/";
		driver.get(Url);
				
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		//click log in
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
				
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("dezlozada");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
				
		//click on submit
		driver.findElement(By.xpath("//input[@id='submits']")).click();
		 
		//hover to myAccount
		Actions XXX = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		XXX.moveToElement(myAcc).build().perform();
		
		//click on finances
		driver.findElement(By.linkText("Finances")).click();;
		
		
		//validate heading (Finances)
		WebElement X = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[1]"));
		
		if(X.isDisplayed())
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
