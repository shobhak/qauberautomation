import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T45808 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Verify the functionality of "Previous" page button for the "Project Search" page. - Chrome
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
		
		//Click on any number from above list
		int a = ThreadLocalRandom.current().nextInt(1, NoOfPages+1);//Generate random number to click on
		String Xpath = ("//*[text()="+a+"]");
		System.out.println(Xpath);
		driver.findElement(By.xpath(Xpath)).click();
		
		//Click on Previous page button to go back one page.
		new WebDriverWait(driver, 10)
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='<< Previous']")));
		
		driver.findElement(By.xpath("//a[text()='<< Previous']")).click();
		
		//Find current element and get page number
		System.out.println(driver.findElement(By.id("activees")).getText());
		String b = driver.findElement(By.id("activees")).getText();
		String c = String(valueOf(b));
		String d = String (a-1);
		if(c==d)
		{
			System.out.println("Previous page functionality is working correctly");
		}
		else
		{
			System.out.println("Previous page functionality if NOT working correctly");
		}
		driver.quit();
		
				
	}

	private static String String(int valueOf) {
		// TODO Auto-generated method stub
		return null;
	}

	private static int valueOf(String b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
