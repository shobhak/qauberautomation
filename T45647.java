import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T45647 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Verify that "Bid QA" link under "All Categories" navigates user to "Bid QA" home page - Firefox (Working for Firefox)
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		property.load(file);
		
		WebDriver driver = new FirefoxDriver();
		driver.get(property.getProperty("url"));
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys(property.getProperty("ProjOwnUserName"));
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys(property.getProperty("ProjOwnPassword"));
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Click on Show all categories
		driver.findElement(By.linkText("Show All Categories")).click();
		System.out.println("Page is navigated to 'All Categories'. Page title is: "+driver.getTitle());
		driver.findElement(By.xpath("//a[@title='Go to BidQA.']")).click();
		
		System.out.println("Page is navigated back to home. Page title is: "+driver.getTitle());
		
		//Logout
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
						
		driver.quit();
		
			}

}
