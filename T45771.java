import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T45771 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Verify functionality of the "Featured project". - Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("http://test.bidqa.com/");
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("Su");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Click on Home button
		driver.findElement(By.partialLinkText("Home")).click();
		
		//Click on Project Search
		driver.findElement(By.partialLinkText("Project Search")).click();
		
		
		//Click on 'Featured' check box
		//WebElement myDynamicElement = driver.findElement(By.xpath("//input[@name='featured']"));
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='featured']")));
		
		driver.findElement(By.xpath("//input[@name='featured']")).click();
		
		//Click on Refine Search
		driver.findElement(By.xpath("//input[@value='Refine Search']")).click();
		
		//Print out search results 
		System.out.println("Results for Test Case No. T45771");
		
		int d = driver.findElements(By.xpath("//div[@class='post-title']")).size();
		
		for (int e=0; e<d; e++)
		{
			String title = driver.findElements(By.xpath("//div[@class='post-title']")).get(e).getText();
			System.out.println(title);
		}
		driver.quit();
	}

}
