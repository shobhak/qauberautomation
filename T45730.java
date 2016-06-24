import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45730 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Verify the copyright information on "Project Search" page. - Chrome
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
				
				//Click on Project Search
				driver.findElement(By.partialLinkText("Project Search")).click();
				
				//Get copyright info
				String a = driver.findElement(By.xpath(".//*[@id='site-info-left']/h3")).getText();
				System.out.println(a);
				String b = "Copyright (c) 2016 @QAUBER.com";
	if (a.equals(b))
	{
		System.out.println("'Copyright (c) 2016 @QAUBER.com' exists.");
	}
	else
	{
		System.out.println("Error in Copyright information!");
	}
	
	//Logout
			driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

	driver.quit();
	}

}
