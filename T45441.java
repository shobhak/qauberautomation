import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class T45441 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//Verify that QA Engineer and Project Owner can Make Payment - Chrome
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
		
		WebDriver driver = new ChromeDriver();
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		
		//Login as QA Engineer
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("QAEnggUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("QAEnggPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//My account == Finances
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions dce = new Actions(driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		dce.moveToElement(MyAccount).build().perform();
				
		driver.findElement(By.partialLinkText("Finances")).click();
		
		//Make payment
		driver.findElement(By.partialLinkText("Make Payment")).click();
		driver.findElement(By.id("amount")).sendKeys(property.getProperty("T45441PaymentAmount"));
		driver.findElement(By.name("username")).sendKeys(property.getProperty("T45441PayProjectOwner"));
		driver.findElement(By.name("payme")).click();
		
		//Verify the transaction
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Transactions")).click();
		
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/table/tbody/tr[1]")).getText());
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		
		//Login as Project owner
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//My account == Finances
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				Actions cde = new Actions(driver);
				WebElement MyAccount1 = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
				cde.moveToElement(MyAccount1).build().perform();
						
				driver.findElement(By.partialLinkText("Finances")).click();
				
				//Click on Transactions
				driver.findElement(By.partialLinkText("Transactions")).click();
				System.out.println("Amount transfered from QA engineer: "+driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/table/tbody/tr[1]")).getText());
				
				Thread.sleep(5000);
				
				driver.findElement(By.partialLinkText("Finances")).click();
				driver.findElement(By.partialLinkText("Make Payment")).click();
				
				//Making payment
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("amount")).sendKeys(property.getProperty("T45441PayQAEngg"));
				driver.findElement(By.name("username")).sendKeys(property.getProperty("T45441QAEnggName"));
				driver.findElement(By.name("payme")).click();
				
				//Check transactions
				driver.findElement(By.partialLinkText("Transactions")).click();
				System.out.println("Amount transfered from Project Owner: "+driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/table/tbody/tr[1]")).getText());
				
				//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		
				driver.quit();
		
	}

}
