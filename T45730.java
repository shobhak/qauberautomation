import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45730 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Verify the copyright information on "Project Search" page. - Chrome
		
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
	driver.quit();
	}

}
