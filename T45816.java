import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T45816 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Verify that "View User Feedback" link directs User to the page containing user's reviews - Chrome
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
		
		//Get User name
		String UserName = driver.findElement(By.xpath("//div[@class='post-main-details']/ul/li[1]/a[1]")).getText();
		System.out.println(driver.findElement(By.xpath("//div[@class='post-main-details']/ul/li[1]/a[1]")).getText());
		
		//Find View User Feedback and click on it
		WebElement myDynamicElement1 = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='post-main-details']/ul/li[3]/a[1]")));
		driver.findElement(By.xpath("//div[@class='post-main-details']/ul/li[3]/a[1]")).click();
		
		//Get User feedback title
		String UserFeedback = "User Feedback - "+UserName;
		System.out.println(UserFeedback);
		
		(new WebDriverWait(driver, 10))
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mm_inn']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='mm_inn']")).getText());
		String RetrievedUserName = driver.findElement(By.xpath("//div[@class='mm_inn']")).getText();
		
		if(RetrievedUserName.contains(UserName))
		{
			if(RetrievedUserName.contains("User Feedback"))
			{
			System.out.println("'View User Feedback' link works fine");
		}
		else
		{
			System.out.println("'View User Feedback' does not work properly");
		}
			//Logout
			driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

		driver.quit();
		
		}
	}

	private static String String(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
