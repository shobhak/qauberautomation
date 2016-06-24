import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class T45489 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Verify that Project Owner can see the heading “What do you want to do ?” on Finances page - Chrome
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
		
		WebDriver driver = new ChromeDriver();
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//My account == Finances
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions dce = new Actions(driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		dce.moveToElement(MyAccount).build().perform();
						
		driver.findElement(By.partialLinkText("Finances")).click();
		
		System.out.println("'What do you want to do' is displayed: "+driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[1]")).isDisplayed());
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
				
		driver.quit();
	}

}
