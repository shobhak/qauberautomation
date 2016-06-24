import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class T45411 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Verify that QA Engineer can see all the transaction on transaction page - Firefox (Works for firefox)
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		WebDriver driver = new FirefoxDriver();
		driver.get(property.getProperty("url"));
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("QAEnggUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("QAEnggPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Creating mouse action of moving to My Account
		Actions lmn = new Actions (driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		lmn.moveToElement(MyAccount).build().perform();
		
		//Click on Finances
		driver.findElement(By.partialLinkText("Finances")).click();
		
		//Click on Withdraw money
		driver.findElement(By.partialLinkText("Withdraw Money")).click();
		
		//Enter random integer between 25 & 50 in Withdraw amount tab
		 String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,50+1));
		driver.findElement(By.id("amount")).sendKeys(RandomNumber);
		
		//Enter paypal email
		driver.findElement(By.xpath("//input[@name='paypal']")).clear();
		driver.switchTo().activeElement().sendKeys(property.getProperty("PaypalLoginEmail"));
		
		driver.findElement(By.xpath("//input[@value='Withdraw']")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Verify transaction
		driver.findElement(By.partialLinkText("Transactions")).click();
		
		//Print Transactions page  for reference
		System.out.println(driver.findElement(By.xpath("//div[@class='my_box3']")).getText());
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		
		driver.quit();
	}

}
