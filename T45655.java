import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class T45655 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Verify that the user can send a message - Chrome 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
driver.get("http://test.bidqa.com/");
driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
				driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("RS");
				driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
				driver.findElement(By.xpath(".//*[@id='submits']")).click();
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//Moving mouse to My Account
				Actions xyz= new Actions(driver);
				WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a"));
				xyz.moveToElement(MyAccount).build().perform();
				
				//Click on Private Message
				driver.findElement(By.partialLinkText("Private Messages")).click();
				
				//Click on Send new message
				driver.findElement(By.partialLinkText("Send New Message")).click();
				
				driver.findElement(By.xpath(".//*[@id='to_as']")).sendKeys("Su");
				
				//Enter Subject
				driver.findElement(By.id("subject_a")).sendKeys("Testing Private Messaging functionality");
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				//driver.findElement(By.className("mce-content-body ")).sendKeys("Testing Private messaging..... text");
				//Enter message
								
				WebElement Tab = driver.findElement(By.id("subject_a"));
				Tab.sendKeys(Keys.TAB);
				Thread.sleep(1000);
				
				driver.switchTo().activeElement().sendKeys("Testing Private messaging ..... text");
								
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@value='Send Message']")).sendKeys(Keys.ENTER);
				
				
				//driver.quit();
		
	}

}
