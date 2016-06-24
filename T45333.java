import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.interactions.Actions;

public class T45333 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Verify that Project Owner can close Dispute. - Chrome
		
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
		
		WebDriver driver = new ChromeDriver();
		driver.get(property.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		Actions dce = new Actions(driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		dce.moveToElement(MyAccount).build().perform();
		
		//Click on Disputes
		driver.findElement(By.partialLinkText("Disputes")).click();
		
				
		//Click on comment for closing this dispute
		driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/div[2]/table/tbody/tr[2]/td[4]/textarea")).sendKeys(property.getProperty("T45333CloseDisputeComment"));
		driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/div[2]/table/tbody/tr[2]/td[5]/input[2]")).click();
		
		System.out.println("Dispute has been closed");
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		
		driver.quit();
	}

}
