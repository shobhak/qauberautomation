import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45727 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//Verify that search function is working. - Chrome
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
WebDriver driver = new ChromeDriver();
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Click on Home button
		driver.findElement(By.partialLinkText("Home")).click();
		
		//Click on post your project
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[5]/a")).click();
		
		//Click on Project search
		driver.findElement(By.id("my-top-search-input")).sendKeys(property.getProperty("T45727ProjectSearch")+Keys.ENTER);
		Thread.sleep(5000);
		
	int a = driver.findElements(By.xpath("//div[@class='post-title']")).size();
		for (int x = 0; x<a; x++)
		{
			String text = driver.findElements(By.xpath("//div[@class='post-title']")).get(x).getText();
		
			System.out.println(text);
		}
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

		driver.quit();
		
		
	}

}
