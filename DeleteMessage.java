package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteMessage {

	public static void main(String[] args) throws InterruptedException {
		/*NOTE NOTE NOTE..
		 * the message inbox might run out on this account
		 * make sure when running this script, you need to have 
		 * a message  the inbox
		 */
		
		// invoke browser and open site
		WebDriver driver = new FirefoxDriver();
		String Url = "http://test.bidqa.com";
		driver.get(Url);
		
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						
		//click log in
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
						
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("dezlozada");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
				
		//click on submit
		driver.findElement(By.xpath("//input[@id='submits']")).click();
				
		//hover to myAccount
		Actions XXX = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		XXX.moveToElement(myAcc).build().perform();
		
		Thread.sleep(5000);
		
		
		//click on private messages
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/ul/li[3]/a")).click();
		
		//click on inbox button
		driver.findElement(By.xpath("//*[@id='content']/div[1]/div/ul/li[3]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement DateMessage = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/form/div/table/tbody/tr[2]/td[4]"));
		String DateBefore = DateMessage.getText();
		
		WebElement FirstMessage = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/form/div/table/tbody/tr[2]/td[5]"));
		FirstMessage.findElement(By.linkText("Delete")).click();
		
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//click confirm delete
		driver.findElement(By.xpath("//*[@id='content']/div[3]/div/div[2]/a[3]")).click();
		
		
		Thread.sleep(5000);
		
		
		WebElement DateAfter1 = driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[2]/form/div/table/tbody/tr[2]/td[4]"));
		DateAfter1.getText();
		
		
		if(DateAfter1.equals(DateBefore))
		{
			System.out.println("Test Failed");
		}
		else
		{
			System.out.println("Test Passed");
		}
	
		driver.close();
	}
	
}
