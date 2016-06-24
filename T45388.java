import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T45388 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//Verify Project Owner can deposit escrow for a selected project - Chrome
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();

		//My account == Finances
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		driver.findElement(By.partialLinkText("Finances")).click();
		
		System.out.println("Balance before escrow deposit: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		String A = driver.findElement(By.xpath("//span[@class='balance']")).getText();
		
		driver.findElement(By.partialLinkText("Deposit Escrow")).click();
		
		//Entering random amount between 25 & 40
		String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,40+1));
		driver.findElement(By.id("amount")).sendKeys(RandomNumber);
				
		//selection of project for escrow
		Select escrowdropdown = new Select(driver.findElement(By.xpath(".//*[@id='my_proj_sel']")));
		escrowdropdown.selectByIndex(1);
		
		driver.findElement(By.name("escrowme")).click();
		if (isAlertPresent()) {
		    driver.switchTo().alert();
		    driver.switchTo().alert().accept();
		    driver.switchTo().defaultContent();
		}
				
		System.out.println("Balance after escrow deposit: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		String B = driver.findElement(By.xpath("//span[@class='balance']")).getText();
		
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

	private static boolean isAlertPresent() {
		// TODO Auto-generated method stub
		return false;
				}
		
	}


