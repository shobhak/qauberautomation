import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class T45339 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Verify that QA Engineer can close the dispute. - Firefox
		
		WebDriver driver = new FirefoxDriver();
		
driver.get("http://test.bidqa.com/");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
				driver.findElement(By.xpath(".//*[@id='log']")).sendKeys("RS");
				driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
				driver.findElement(By.xpath(".//*[@id='submits']")).click();
				
				
				//Creation of object for actions (move mouse over My account)
				
				Actions dce = new Actions(driver);
				WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
				dce.moveToElement(MyAccount).build().perform();
				
				//Click on Disputes
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/ul/li[6]/a")).click();
				
				
				
				//Click on comment for closing this dispute
				driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/div[2]/table/tbody/tr[2]/td[4]/textarea")).sendKeys("ithqiweajbflakdsuhgaiuewrfakjsdlasdf");
				driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/div[2]/table/tbody/tr[2]/td[5]/input[2]")).click();
				
				System.out.println("Dispute has been closed with the comment 'ithqiweajbflakdsuhgaiuewrfakjsdlasdf'");
				driver.quit();

	}

}
