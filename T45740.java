import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T45740 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Verify that user can do "Refine search" using Price. - Chrome
		
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
		
		//Select price from dropdown
		Select dropdown = new Select (driver.findElement(By.xpath("//select[@name='budgets']")));
		
		//Generate random number between 1 & 13 to put in the dropdown list
		int a = ThreadLocalRandom.current().nextInt(1, 13+1);
		
		//Select from dropdown
		dropdown.selectByIndex(a);
		
		//Click on Refine search
		driver.findElement(By.xpath("//input[@value='Refine Search']")).click();
		
		//Get Project and Budget details
		Thread.sleep(5000);
		
		//Print out the refined search
		System.out.println("Test Case No. T45740");
		int d = driver.findElements(By.xpath("//div[@class='post-title']")).size();
		int c = driver.findElements(By.xpath("//*[@class='post-main-details']/ul/li[1]/h4")).size();
		for (int b=0; b<d; b++)
		{
			String title = driver.findElements(By.xpath("//div[@class='post-title']")).get(b).getText();
			System.out.println(title);
			for (int e=0; e<c; e++)
			{
			System.out.println(driver.findElements(By.xpath("//*[@class='post-main-details']/ul/li[1]/h4")).get(e).getText());
			break;
			}
	}
		driver.quit();

}
}

