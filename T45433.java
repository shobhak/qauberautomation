import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T45433 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Verify Project Owner can deposit escrow for a selected project (working for Firefox)
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get(property.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@id='log']")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Create an object for actions
		Actions abc = new Actions(driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a"));
		abc.moveToElement(MyAccount).build().perform();
		
		//Find finances and click on it
		driver.findElement(By.partialLinkText("Finances")).click();
		System.out.println(driver.getTitle());
		
		System.out.println("Balance before escrow deposit: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		String A = driver.findElement(By.xpath("//span[@class='balance']")).getText();
		
		driver.findElement(By.partialLinkText("Deposit Escrow")).click();
		Thread.sleep(5000);
		//Entering random amount between 25 & 40
				String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,40+1));
				driver.findElement(By.id("amount")).sendKeys(RandomNumber);
		
		//selection of project for escrow
		Select escrowdropdown = new Select(driver.findElement(By.xpath(".//*[@id='my_proj_sel']")));
		escrowdropdown.selectByIndex(1);
		driver.findElement(By.xpath("//input[@value='Make Escrow']")).sendKeys(Keys.ENTER);
	
		//Thread.sleep(5000);
		
		String B = driver.findElement(By.xpath("//span[@class='balance']")).getText();
	
	System.out.println("Balance after escrow deposit: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		
		if (A!=B)
		{
			System.out.println("Deposit complete!");
		}
		else
		{
			System.out.println("Deposit not complete");
		}
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		
		driver.quit();
		
	
			}
}
