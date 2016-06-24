import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T46531 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Verify that Project Owner gets message on screen "Dispute Created" - Firefox
		
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		WebDriver driver = new FirefoxDriver();
		driver.get(property.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.id("log")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.id("login_password")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath("//input[@id='submits']")).click();
		
	//Creation of object for actions (move mouse over My account)
		
		Actions dce = new Actions(driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a"));
		dce.moveToElement(MyAccount).build().perform();
		
		//Click on Disputes
		driver.findElement(By.partialLinkText("Disputes")).click();
		
		//Select from Defendant dropdown
		Select defendantdropdown = new Select (driver.findElement(By.xpath(".//*[@id='content']/div[1]/div/div[2]/form/div/div[1]/div/select")));
		defendantdropdown.selectByIndex(0);
		
		//Write comment & click submit
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@name='comment']")).sendKeys(property.getProperty("T46531Comment"));
		driver.findElement(By.xpath("//input[@value='Create Dispute']")).click();
		
		//To switch to the alert and display the information
		System.out.println(driver.findElement(By.xpath(".//*[@id='content']/div[1]")).getText());
		
		//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		
		driver.quit();
	}

}
