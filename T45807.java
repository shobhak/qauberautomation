import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T45807 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Verify the functionality of "Next" page button in the "Project Search" page - Chrome
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("http://test.bidqa.com/");
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("RS");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Click on Project Search
		driver.findElement(By.xpath("//a[text()='Project Search']")).click();
		
		//Find the pages tab and count number of pages
		int NoOfPages = (driver.findElements(By.xpath("//div[@class='div_class_div']/a")).size()-2);
		for(int c=0; c<NoOfPages; c++)
		{
			String b = driver.findElements(By.xpath("//div[@class='div_class_div']/a")).get(c).getText();
			System.out.println(b);
			String XpathPart1 = ("//div[@class='div_class_div']/a");
				String Xpath = (XpathPart1+"["+b+"]");
				System.out.println(Xpath);
				
				new WebDriverWait(driver, 10)
						  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
				
				driver.findElement(By.xpath(Xpath)).click();
				
				new WebDriverWait(driver, 10)
						  .until(ExpectedConditions.presenceOfElementLocated(By.id("activees")));
				System.out.println(driver.switchTo().activeElement().getAttribute("id"));
				//System.out.println(driver.findElement(By.xpath(Xpath)).getAttribute("id"));
					
				/*String ExpectedID = "activees";
				String CurrentID = (driver.switchTo().activeElement().getAttribute("id"));
				if(ExpectedID==CurrentID)
				{
				System.out.println("Page "+b+" is being displayed correctly");	
				}
				else
				{
					System.out.println("Page is NOT being displayed properly");
				}*/
				}
				
		driver.quit();
		
	}

	private static void valueOf(int size) {
		// TODO Auto-generated method stub
		
	}

}
