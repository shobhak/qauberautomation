package TestSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteUnpubProject {

	public static void main(String[] args) throws InterruptedException {
		
		// DELETE UNPUBLISHED PROJECT
		
		//Invoke browser and Open Bidqa
		WebDriver driver = new FirefoxDriver();
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
		
		//Click on Unpublished project
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu_seller']/li[4]/a")).click();
		
		Thread.sleep(5000);
		
		//Click on delete
		WebElement unPublished = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[1]/div[1]/div"));
		unPublished.findElement(By.linkText("Delete")).click();
		
		//Click on Confirm Delete
		driver.findElement(By.xpath("//input[@value='Confirm Deletion']")).click();
		
		//Validation
		String Actual = driver.findElement(By.xpath("//*[@id='content']/div/div/div")).getText();
		String Expected = "The project has been deleted. Return to your account.";
		
		System.out.println(Actual);
		
		if(Actual.equals(Expected))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		//Close browser
		driver.close();
	}

}
