import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class T45721 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//Change Password - Firefox (Works in Firefox)
		
		//For this test, I have changed the password two times: first to check changed password and second, to change it back so that other scripts will run.
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get(property.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("QAEnggUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("QAEnggPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Creating mouse action of moving to My Account
		Actions lmn = new Actions (driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		lmn.moveToElement(MyAccount).build().perform();
		
		//Click on Personal info
		driver.findElement(By.partialLinkText("Personal Info")).click();
		
		//Type in new password and repeat new password
		driver.findElement(By.name("password")).sendKeys(property.getProperty("T45721NewPassword"));
		driver.findElement(By.name("reppassword")).sendKeys(property.getProperty("T45721NewPassword"));
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@type='submit' and @name='save-info']")).sendKeys(Keys.ENTER);;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("QAEnggUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("T45721NewPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		System.out.println("Password changed successfully!");
		
		Actions lmno = new Actions (driver);
		WebElement MyAccount1 = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		lmno.moveToElement(MyAccount1).build().perform();
		
		driver.findElement(By.partialLinkText("Personal Info")).click();
		
		//Type in original password and repeat original password
		driver.findElement(By.name("password")).sendKeys(property.getProperty("QAEnggPassword"));
		driver.findElement(By.name("reppassword")).sendKeys(property.getProperty("QAEnggPassword"));
		
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='submit' and @name='save-info']")).click();
				
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("QAEnggUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("QAEnggPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		System.out.println("Password changed to original password.");
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
			
		driver.quit();
	}

	private static Object WebDriverWait(WebDriver driver, int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
