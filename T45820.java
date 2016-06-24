import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T45820 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
// Verify that Page Number is listing correctly when the user selects the exact page from all posted Project Search. - Chrome
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", property.getProperty("SystemSetPropertyChrome"));
		WebDriver driver = new ChromeDriver();
		
				
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
				
		//Find the pages tab and count number of pages
		int NoOfPages = (driver.findElements(By.xpath("//div[@class='div_class_div']/a")).size()-2);
		
		//Click on any number from above list
		int a = (ThreadLocalRandom.current().nextInt(1, NoOfPages+1));//Generate random number to click on
		System.out.println("The page chosen is pg."+a);
		String Xpath = ("//*[text()="+a+"]");
		System.out.println(Xpath);
		driver.findElement(By.xpath(Xpath)).click();
		
		new WebDriverWait(driver, 10)
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("activees")));
		//Get the page number 
		String b = (driver.findElement(By.id("activees")).getText());
		int number = Integer.parseInt(b);
		System.out.println(driver.findElement(By.id("activees")).getText());
		if(a == number)
		{
			System.out.println("Page chosen is listed correctly");
		}
		else
		{
			System.out.println("Page number is not listed correctly");
		}
		//Logout
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

	driver.quit();
	}
	
	

}
