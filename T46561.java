import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T46561 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Verify that Project Owner gets message on screen "Dispute Created" (working for Chrome)
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
		WebDriver driver = new ChromeDriver();
		
		driver.get(property.getProperty("url"));
		
driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@id='log']")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Creation of object for actions (move mouse over My account)
		
		Actions dce = new Actions(driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a"));
		dce.moveToElement(MyAccount).build().perform();
		
		//Click on Disputes
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/ul/li[5]/a")).click();
		
		//Select from Defendant dropdown
		Select defendantdropdown = new Select (driver.findElement(By.name("defendant")));
		defendantdropdown.selectByIndex(0);
		
		//Write comment & click submit
		driver.findElement(By.name("comment")).sendKeys(property.getProperty("T46561Comment"));
		driver.findElement(By.xpath("//*[@value='Create Dispute']")).click();
		
		//To switch to the alert and display the information
		System.out.println(driver.findElement(By.xpath(".//*[@id='content']/div[1]")).getText());
		
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
		
		driver.quit();
		
	}

}
