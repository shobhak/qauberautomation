import java.io.FileInputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T45400 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//Verify that Project Owner can create a Milestone Payment - Chrome (Works for Chrome)
		
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
				
				//Click on milestone payments
				driver.findElement(By.partialLinkText("Milestone Payments")).click();
				
				//Create milestone payments
				//Select project tab
				Select Projectdropdown = new Select(driver.findElement(By.id("my_proj_sel")));
				Projectdropdown.selectByIndex(1);;
				Thread.sleep(5000);
				
				//Generating random number, rounding it to 2 decimal places, converting it to String format and sending keys
				int RandomNumber = (ThreadLocalRandom.current().nextInt(5, 11));
				DecimalFormat f = new DecimalFormat("##.00");
				f.setRoundingMode(RoundingMode.HALF_UP);
				//double roundOff = (double)Math.round(RandomNumber);
				String a=String.valueOf(f.format(RandomNumber));
				driver.findElement(By.id("amount_text")).sendKeys(a);
				
				driver.findElement(By.id("description")).sendKeys(property.getProperty("T45400MilestonePaymentDesc"));
				
				driver.findElement(By.id("completion_date")).click();
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				driver.findElement(By.partialLinkText("20")).click();
				driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
				
				driver.findElement(By.id("submit_milestone")).click();
				
				System.out.println(driver.findElement(By.xpath(".//*[@id='content']/div[3]/div")).getText());
				
				//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
				
				driver.quit();
				
	}

	

}
