import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45839 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Verify User is able to sort order listing by "Date". - Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("QAEnggUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("QAEnggPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Click on Project Search
		driver.findElement(By.xpath("//a[text()='Project Search']")).click();
		
		//Sort search results by Date
		driver.findElement(By.xpath("//a[text()='Date']")).click();
		
		//Create a linked list to hold the search results
		//List<WebElement> Dates = new LinkedList<WebElement>();
		
		//Store the dates into the linkedlist
		int Dates = driver.findElements(By.xpath("//*[@title='Start date']//h4")).size();
		for(int i=0;i<Dates;i++){

			System.out.println(driver.findElements(By.xpath("//*[@title='Start date']//h4")).get(i).getText());
				
		}
		//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

		driver.quit();
	
		
		
	}

}
