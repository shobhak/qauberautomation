import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45733 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Verify that user can do "Refine search" using keywords. - Chrome
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
		
		//Find Keyword tab and send keys
		driver.findElement(By.xpath("//input[@name='term']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@value='Refine Search']")).click();
		
		Thread.sleep(5000);
		//Print out the refined search
		System.out.println("Test case no. T45733");
		int a = driver.findElements(By.xpath("//div[@class='post-title']")).size();
		for (int b=0; b<a; b++)
		{   
			String title = driver.findElements(By.xpath("//div[@class='post-title']")).get(b).getText();
			System.out.println(title);
			}
		driver.quit();
			}

}
