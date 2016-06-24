import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class T45825 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Verify "User Profile" link redirects User to the user profile page under Project Search. - Chrome
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
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("QAEnggUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("QAEnggPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Click on Project Search
		driver.findElement(By.xpath("//a[text()='Project Search']")).click();
		
		//Find first User Profile link and click on it.
		System.out.println(driver.findElement(By.xpath("(//a[@class='avatar-posted-by-username'])[1]")));
		String c = driver.findElement(By.xpath("(//a[@class='avatar-posted-by-username'])[1]")).getText();
		driver.findElement(By.xpath("(//a[@class='avatar-posted-by-username'])[1]")).click();
		
		//Find the heading under User profile and get text
		driver.findElement(By.xpath("//div[@class='mm_inn']")).getText();
		String a = driver.findElement(By.xpath("//div[@class='mm_inn']")).getText();
		String b = a.substring(15);
		System.out.println(b);
		
		Assert.assertEquals(c, b);
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

		
		driver.quit();
		
		
		
		
		
	}

}
