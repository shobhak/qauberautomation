import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45794 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Verify that user can search for "QA Engineer". - Chrome
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
		
		//Click on Projects dropdown
		driver.findElement(By.xpath("//div[@id='dd' and @tabindex='1']")).click();
		
		//Choose QA Engineers
		driver.findElement(By.xpath("//a[text()='QA Engineers']")).click();
		
		//Enter search for QA Engineer
		String QAEnggName = String ("dez");
		driver.findElement(By.xpath(".//*[@id='my-top-search-input']")).sendKeys("dez");
		driver.findElement(By.xpath(".//*[@id='my-top-submit-input']")).click();
		String Text = driver.findElement(By.xpath("//div[@class='user-table-user-info']/h3")).getText();
		String lowercase = Text.toLowerCase();
		System.out.println(driver.findElement(By.xpath("//div[@class='user-table-user-info']/h3")).getText());
		
		if (lowercase.contains("dez"))
		{
			System.out.println("TestCase passed");
		}
		else
		{
			System.out.println("Test Case failed");
		}
		//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

		driver.quit();
	}

	private static String String(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
