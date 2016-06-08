import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45755 {

	public static void main(String[] args) {
	 //Verify that user can sort order listing by "Name" - Chrome
		
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
				
		//Click on Order by: Name
		driver.findElement(By.partialLinkText("Name")).click();
		
		//Print out results
		System.out.println("Test Case No. T45755");
		int d = driver.findElements(By.xpath("//div[@class='post-title']")).size();
		
		for (int e=0; e<d; e++)
		{
			String title = driver.findElements(By.xpath("//div[@class='post-title']")).get(e).getText();
			System.out.println(title);
		}
		
		driver.quit();
	}

}
