import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class T45823 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//Verify search word from the Project Search is appeared in the Filter Option's Keyword Text field - Chrome
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
		
		//Click on All Projects
		driver.findElement(By.xpath("//a[text()='All Projects']")).click();
		
		//Find search field and key in search criteria
		driver.findElement(By.xpath("//input[@id='my-top-search-input']")).sendKeys(property.getProperty("T45823SearchCriteria"));
		driver.findElement(By.xpath("//input[@id='my-top-submit-input']")).click();
		String a = property.getProperty("T45823SearchCriteria");
		System.out.println("a= "+a);
		
		//Find Filter Option's Keyword text field and get text
		(new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='form-control' and @name='term']")));
		
		System.out.println(driver.findElement(By.xpath("//*[@class='form-control' and @name='term']")).getAttribute("value"));
		String b = driver.findElement(By.xpath("//*[@class='form-control' and @name='term']")).getAttribute("value");
		System.out.println("b= "+b);
		
		Assert.assertEquals(a, b);
		
		//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

		driver.quit();
	}

}
