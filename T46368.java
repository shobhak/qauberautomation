import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T46368 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Verify user cannot submit an empty "feedback form" in Support page

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
		
		//Enter valid name, valid Subject, Invalid email address and valid message
		driver.findElement(By.xpath("//input[@name='your-name']")).sendKeys(property.getProperty("T46368Name"));
		driver.findElement(By.xpath("//input[@name='your-email']")).sendKeys(property.getProperty("T46368Email"));
		driver.findElement(By.xpath("//input[@name='your-subject']")).sendKeys(property.getProperty("T46368Subject"));
		driver.findElement(By.xpath("//textarea[@name='your-message']")).sendKeys(property.getProperty("T46368Message"));
		driver.findElement(By.xpath("//input[@type='submit' and @value='Send']")).click();		
		
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//span[@role='alert']")).isDisplayed());
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//div[@role='alert']")).getText()+"'");
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//span[@role='alert']")).getText()+"'");
		
		driver.quit();
	}

}
