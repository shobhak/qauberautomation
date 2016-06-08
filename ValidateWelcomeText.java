package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidateWelcomeText {

	public static void main(String[] args) throws InterruptedException {
		// invoke browser and open site
		WebDriver driver = new FirefoxDriver();
		String URL = "http://test.bidqa.com/";
		driver.get(URL);
		
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
												
		//click log in
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
												
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
										
		//click on submit
		driver.findElement(By.xpath("//input[@id='submits']")).click();
		
		Thread.sleep(5000);
		
		//making variables for exp and act 
		//String Expected= "Welcome lozadadez1";
		//String Actual = d.findElement(By.xpath("//*[@id='header']/div/div/div[4]")).getText();
		
		//validation
		WebElement X = driver.findElement(By.xpath("//*[@id='header']/div/div/div[4]"));
		
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
