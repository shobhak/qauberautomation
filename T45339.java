import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class T45339 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Verify that QA Engineer can close the dispute. - Firefox
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		WebDriver driver = new FirefoxDriver();
		
driver.get(property.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
				driver.findElement(By.xpath(".//*[@id='log']")).sendKeys(property.getProperty("QAEnggUserName"));
				driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("QAEnggPassword"));
				driver.findElement(By.xpath(".//*[@id='submits']")).click();
				
				
				//Creation of object for actions (move mouse over My account)
				
				Actions dce = new Actions(driver);
				WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
				dce.moveToElement(MyAccount).build().perform();
				
				//Click on Disputes
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/ul/li[6]/a")).click();
				
				
				
				//Click on comment for closing this dispute
				driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/div[2]/table/tbody/tr[2]/td[4]/textarea")).sendKeys(property.getProperty("T45339CloseDisputeComment"));
				driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/div[2]/table/tbody/tr[2]/td[5]/input[2]")).click();
				
				System.out.println("Dispute has been closed with the comment '"+property.getProperty("T45339CloseDisputeComment")+"'");
				
				//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
				
				driver.quit();

	}

}
