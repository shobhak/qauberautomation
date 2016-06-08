import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T45662 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Verify that the user can send a message as a Project Owner - Firefox (Worked on Firefox)
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://test.bidqa.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
				driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("Su");
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
				
				//Select SendTo dropdown
				Select SendToDropdown = new Select (driver.findElement(By.name("projectss[]")));
				SendToDropdown.selectByIndex(1);
				
				//Enter Subject
				driver.findElement(By.id("subject_a")).sendKeys("Testing Private Messaging functionality");
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				//driver.findElement(By.className("mce-content-body ")).sendKeys("Testing Private messaging..... text");
				//Enter message
								
				WebElement Tab = driver.findElement(By.id("subject_a"));
				Tab.sendKeys(Keys.TAB);
				Thread.sleep(1000);
				
				driver.switchTo().activeElement().sendKeys("Testing Private messaging ..... text");
								
				driver.findElement(By.xpath("//input[@class='submit_bottom2']")).click();
				
				//driver.exit();
				

	}

}
