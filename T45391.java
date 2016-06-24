import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T45391 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//Verify Project Owner can close request to withdraw money from the account - Firefox (Working in Firefox)
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		WebDriver driver = new FirefoxDriver();

		driver.get(property.getProperty("url"));

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();

		//My account == Finances
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		driver.findElement(By.partialLinkText("Finances")).click();

		//Print out current balance
		System.out.println("Amount before making transfer to Paypal: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());

		//Deposit money
		driver.findElement(By.partialLinkText("Deposit Money")).click();

		//Entering random amount between 25 & 40
		String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,40+1));
		driver.findElement(By.id("amount")).sendKeys(RandomNumber);

		driver.findElement(By.name("deposit")).click();

		//Switched to Paypal account
		System.out.println("Switched to Paypal account. Page title is: "+driver.getTitle());

		driver.findElement(By.id("loadLogin")).click();
		driver.findElement(By.id("login_email")).clear();
		driver.findElement(By.id("login_email")).sendKeys(property.getProperty("PaypalLoginEmail"));
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys(property.getProperty("PaypalPassword"));
		driver.findElement(By.id("submitLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("continue")).click();
		
		driver.findElement(By.xpath("//input[@name='merchant_return_link']")).click();
		
		Thread.sleep(5000);
		driver.switchTo().alert().accept();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("Amount before payment: "+ driver.findElement(By.xpath("//span[@class='balance']")).getText());

		//Withdraw money
		driver.findElement(By.partialLinkText("Withdraw Money")).click();
				
		//Create random number to withdraw
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(RandomNumber);
		//driver.switchTo().activeElement().sendKeys(RandomNumber);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='paypal']")).clear();
		driver.switchTo().activeElement().sendKeys(property.getProperty("PaypalLoginEmail"));
		
		driver.findElement(By.xpath("//input[@name='withdraw']")).click();
		
		System.out.println("Amount after withdrawal is: "+ driver.findElement(By.xpath("//span[@class='balance']")).getText());
		
		System.out.println(driver.findElement(By.xpath(".//*[@id='content']/div[5]")).getText());
		driver.findElement(By.partialLinkText("Close Request")).click();
		
		//Return to payments after cancellation
		driver.findElement(By.partialLinkText("Return to payments")).click();
		
		//Closing balance after cancellation
		System.out.println("Amount after cancellation of withdrawal is: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		
		driver.quit();

	}

}
