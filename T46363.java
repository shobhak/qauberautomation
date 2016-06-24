import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T46363 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//Verify that the form of the "Support" page includes all required elements. - Chrome
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
		WebDriver driver = new ChromeDriver();
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Support
		driver.findElement(By.xpath("//a[text()='Support']")).click();
				
		//Verify that Name, Email, Subject, Message & Send is displayed
		System.out.println("Name tab is displayed "+driver.findElement(By.xpath("//input[@name='your-name']")).isDisplayed());
		System.out.println("Email tab is displayed "+driver.findElement(By.xpath("//input[@name='your-email']")).isDisplayed());
		System.out.println("Subject tab is displayed "+driver.findElement(By.xpath("//input[@name='your-subject']")).isDisplayed());
		System.out.println("Message tab is displayed "+driver.findElement(By.xpath("//textarea[@name='your-message']")).isDisplayed());
		System.out.println("Send button is displayed "+driver.findElement(By.xpath("//input[@type='submit' and @value='Send']")).isDisplayed());
		
		driver.quit();
		
	}

}
