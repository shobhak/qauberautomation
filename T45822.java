import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class T45822 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//Verify the number of visits is calculated correctly when User visits the project. - Chrome
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
		
		
		//Pick first project, get title &  Number of visits
		driver.findElement(By.xpath("(//div[@class='post-title'])[1]/a")).getText();
		System.out.println("The project selected is: "+driver.findElement(By.xpath("//div[@class='post-title']")).getText());
		System.out.println("Number of visits is: "+driver.findElement(By.xpath("//div[@class='post-main-details']/ul/li[5]/h4")).getText());
		String Before = driver.findElement(By.xpath("//div[@class='post-main-details']/ul/li[5]/h4")).getText();
		String BeforeV = Before.substring(9);
		int BeforeVisit = Integer.parseInt(BeforeV);
			
		
		//Click on above project chosen
		
		driver.findElement(By.xpath("(//div[@class='post-title'])[1]/a")).sendKeys(Keys.ENTER);
		
		//Get the number of times the project is viewed
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//div[@id='right-sidebar']/ul/li[4]/ul/li[2]/p")).getText());
		
		String After = driver.findElement(By.xpath("//div[@id='right-sidebar']/ul/li[4]/ul/li[2]/p")).getText();
		String AfterV = After.substring(0, 2);
		int AfterVisit = Integer.parseInt(AfterV);
		
		
				
		if (BeforeVisit+1 == AfterVisit)
		{
			System.out.println("Number of visits is calculated correctly");
		}
		else
		{
			System.out.println("Number of visits is NOT calculated correctly");
		}
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

		driver.quit();
	}

}
