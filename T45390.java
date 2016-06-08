import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45390 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Verify Project Owner can close request to withdraw money from the account - Chrome
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
		
		System.out.println("Amount before withdrawal: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		driver.findElement(By.partialLinkText("Withdraw Money")).click();
		
		//Withdraw amount
		//Send Random number generated to 'Withdraw amount' field
				String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,65));
				driver.findElement(By.id("amount")).sendKeys(RandomNumber);
				driver.findElement(By.xpath("//input[@name='paypal']")).sendKeys("srjssmiles-buyer@gmail.com");
				driver.findElement(By.xpath("//input[@name='withdraw']")).click();
				
		//Cancel pending request
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='content']/div[5]/div[2]/table/tbody/tr[1]/td[5]/a")).sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Return to payments")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Amount after cancelling withdrawal: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		
		System.out.println("Withdrawal has been cancelled successfully");
	
		driver.quit();
	}

}
