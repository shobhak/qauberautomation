package TestSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CloseProject {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Close Project
		
		//Invoke browser and open bidqa
		WebDriver driver = new FirefoxDriver();
		String URL = "http://test.bidqa.com";
		driver.get(URL);
		
		//Manage timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//Log in 
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
		driver.findElement(By.xpath("//input[@id='submits']")).click();
		
		//Click on active projects
		driver.findElement(By.xpath("//*[@id='my-account-admin-menu_seller']/li[2]/a")).click();
		
		//Click on one of the projects
		Actions XXX = new Actions(driver);
		WebElement Pro = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[1]/div[1]/div/div[1]/a"));
		XXX.click(Pro).build().perform();
		
		//Sleep
		Thread.sleep(5000);
		
		//click on Close Project
		driver.findElement(By.xpath("//*[@class='orange_btn3']")).click();
		
		//Click on Confirm Close Project
		WebElement conf = driver.findElement(By.xpath("//input[@value='Confirm Close Project']"));
		XXX.click(conf).build().perform();
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D://CloseProject.png"));
		
		//Validation
		String Expected = "The project has been closed. Return to your account.";
		String Actual = driver.findElement(By.xpath("//*[@id='content']/div/div/div")).getText();
		
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
