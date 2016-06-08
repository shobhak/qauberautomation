import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45395 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Verify Project Owner can see all the transaction on transaction page - Chrome
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
		System.out.println("Balance before withdrawal is: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		
		//Withdraw amount
		//Send Random number generated to 'Withdraw amount' field
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Withdraw Money")).click();
		String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,65));
		driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(RandomNumber);
		driver.findElement(By.xpath("//input[@name='paypal']")).sendKeys("srjssmiles-buyer@gmail.com");
		driver.findElement(By.xpath("//input[@name='withdraw']")).click();
		Thread.sleep(5000);
		System.out.println("Balance after withdrawal & before deposit is: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		
		//Click on Deposit money
				driver.findElement(By.partialLinkText("Deposit Money")).click();
				
				//Deposit money
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				String RandomNumber1 = String.valueOf(ThreadLocalRandom.current().nextInt(25, 55));
				driver.findElement(By.id("amount")).sendKeys(RandomNumber1);
				driver.findElement(By.xpath("//input[@value='Deposit']")).click();
				
				//Paypal site
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.id("loadLogin")).click();
				driver.findElement(By.xpath(".//*[@id='login_email']")).clear();
				driver.findElement(By.xpath(".//*[@id='login_email']")).sendKeys("srjssmiles-buyer@gmail.com");
				driver.findElement(By.xpath(".//*[@id='login_password']")).clear();
				driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
				
				driver.findElement(By.id("submitLogin")).click();
				driver.findElement(By.id("continue_abovefold")).click();
				driver.findElement(By.xpath("//input[@name='merchant_return_link']")).click();
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Balance after deposit is: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
				//Find the transactions
				driver.findElement(By.partialLinkText("Transactions")).click();
				System.out.println(driver.findElement(By.xpath(".//*[@id='content']/div/div[2]")).getText());
				
				driver.quit();
		
	}

}
