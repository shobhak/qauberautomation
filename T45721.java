import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class T45721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Change Password - Firefox (Works in Firefox)
		
		//For this test, I have changed the password two times: first to check changed password and second, to change it back so that other scripts will run.
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://test.bidqa.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("RS");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Creating mouse action of moving to My Account
		Actions lmn = new Actions (driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		lmn.moveToElement(MyAccount).build().perform();
		
		//Click on Personal info
		driver.findElement(By.partialLinkText("Personal Info")).click();
		
		//Type in new password and repeat new password
		driver.findElement(By.name("password")).sendKeys("abcdefghij");
		driver.findElement(By.name("reppassword")).sendKeys("abcdefghij");
		
		driver.findElement(By.xpath("//input[@name='save-info']")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("RS");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefghij");
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		Actions lmno = new Actions (driver);
		WebElement MyAccount1 = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		lmno.moveToElement(MyAccount1).build().perform();
		
		driver.findElement(By.partialLinkText("Personal Info")).click();
		
		//Type in original password and repeat original password
		driver.findElement(By.name("password")).sendKeys("abcdefgh");
		driver.findElement(By.name("reppassword")).sendKeys("abcdefgh");
		
		driver.findElement(By.xpath("//input[@name='save-info']")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("RS");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//driver.quit();
	}

}
