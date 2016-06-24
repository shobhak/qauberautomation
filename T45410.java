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

public class T45410 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Verify that QA Engineer can close request to withdraw money from the account - Firefox
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get(property.getProperty("url"));
		
		WebElement LoginTab = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a"));
		WebElement Login = driver.findElement(By.xpath(".//*[@name='log']"));
		WebElement Password = driver.findElement(By.xpath(".//*[@id='login_password']"));
		WebElement Submit = driver.findElement(By.xpath(".//*[@id='submits']"));
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		WebElement Finances = driver.findElement(By.partialLinkText("Finances"));
		WebElement WithdrawMoney = driver.findElement(By.partialLinkText("Withdraw Money"));
		WebElement Balances = driver.findElement(By.xpath("//span[@class='balance']"));
		WebElement PaypalAmount = driver.findElement(By.xpath(".//*[@id='amount']"));
		WebElement PaypalLoginName=driver.findElement(By.xpath("//input[@name='paypal']"));
		WebElement Withdraw = driver.findElement(By.xpath("//input[@name='withdraw']"));
		WebElement FirstPendingWithdrawal = driver.findElement(By.xpath(".//*[@id='content']/div[5]/div[2]/table/tbody/tr[1]/td[5]/a"));
		WebElement ReturnToPayments = driver.findElement(By.partialLinkText("Return to payments"));
		WebElement Logout = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a"));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		LoginTab.click();
		Login.sendKeys(property.getProperty("QAEnggUserName"));
		Password.sendKeys(property.getProperty("QAEnggPassword"));
		Submit.click();
		
		//My account == Finances
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions dce = new Actions(driver);
		dce.moveToElement(MyAccount).build().perform();
				
		Finances.click();

		//Withdraw money
		WithdrawMoney.click();
		Thread.sleep(5000);
				
		System.out.println("Balance before withdrawal: "+Balances.getText());
								
		Thread.sleep(5000);
		//Enter withdrawal amount and paypal account
		String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,40+1));
		PaypalAmount.sendKeys(RandomNumber);
		PaypalLoginName.clear();
		driver.switchTo().activeElement().sendKeys(property.getProperty("PaypalLoginEmail"));
				
		Withdraw.click();
				
		Thread.sleep(10000);//Sleep here helps the page refresh... or else getting before and after balances same.
		driver.switchTo().activeElement();
				
		//Find the withdrawal in Pending withdrawals and Close request
		FirstPendingWithdrawal.click();
		ReturnToPayments.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		System.out.println("Balance after cancelling withdrawal: "+Balances.getText());
								
		System.out.println("Cancellation complete");
				
		//Logout
		Logout.click();
				
		driver.quit();
		
	}

}
