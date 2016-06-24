import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class T45405 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//Verify that QA Engineer can withdraw money from the account - Chrome
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
		
		WebDriver driver = new ChromeDriver();
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("QAEnggUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("QAEnggPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//My account == Finances
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions dce = new Actions(driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		dce.moveToElement(MyAccount).build().perform();
				
				driver.findElement(By.partialLinkText("Finances")).click();

				//Withdraw money
				
				driver.findElement(By.partialLinkText("Withdraw Money")).click();
				
				System.out.println("Balance before withdrawal: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
				String Before= driver.findElement(By.xpath("//span[@class='balance']")).getText();
				//Enter withdrawal amount and paypal account
				String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,40+1));
				driver.findElement(By.xpath(".//*[@id='amount']")).sendKeys(RandomNumber);
				driver.findElement(By.xpath("//input[@name='paypal']")).clear();
				driver.switchTo().activeElement().sendKeys(property.getProperty("PaypalLoginEmail"));
				
				driver.findElement(By.xpath("//input[@name='withdraw']")).click();
				
				Thread.sleep(10000);//Sleep here helps the page refresh... or else getting before and after balances same.
				driver.switchTo().activeElement();
				
				System.out.println("Balance after withdrawal: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());
				String After = driver.findElement(By.xpath("//span[@class='balance']")).getText();
				System.out.println(driver.findElement(By.xpath(".//*[@id='content']/div[5]")).getText());
				
				if(Before!=After)
				{
					System.out.println("Withdrawal complete!");
				}
				//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

				
				driver.quit();
	}

}
