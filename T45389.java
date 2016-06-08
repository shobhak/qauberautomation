import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45389 {

	public static void main(String[] args) throws InterruptedException {
		// Verify Project Owner can withdraw money from the account - Chrome
System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://test.bidqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("Su");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//My account == Finances
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		driver.findElement(By.partialLinkText("Finances")).click();
				
		driver.findElement(By.partialLinkText("Withdraw Money")).click();
		System.out.println("Amount before withdrawal: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		String A = driver.findElement(By.xpath("//span[@class='balance']")).getText();
		
		//Send Random number generated to 'Withdraw amount' field
		String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,65));
		driver.findElement(By.id("amount")).sendKeys(RandomNumber);
		driver.findElement(By.xpath("//input[@name='paypal']")).sendKeys("srjssmiles-buyer@gmail.com");
		driver.findElement(By.xpath("//input[@name='withdraw']")).click();
		
		Thread.sleep(5000);
		System.out.println("Amount before withdrawal: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		String B = driver.findElement(By.xpath("//span[@class='balance']")).getText();
		
		if (A!=B)
		{
			System.out.println("Withdrawal complete");
		}
		else
		{
			System.out.println("Withdrawal has not been done");
		}
		driver.quit();
	}

}
