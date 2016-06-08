import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45727 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Verify that search function is working. - Chrome
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
		
		//Click on post your project
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[5]/a")).click();
		
		//Click on Project search
		driver.findElement(By.id("my-top-search-input")).sendKeys("bc"+Keys.ENTER);
		Thread.sleep(5000);
		
	int a = driver.findElements(By.xpath("//div[@class='post-title']")).size();
		for (int x = 0; x<a; x++)
		{
			String text = driver.findElements(By.xpath("//div[@class='post-title']")).get(x).getText();
		
			System.out.println(text);
		}
		driver.quit();
		
		
	}

}
