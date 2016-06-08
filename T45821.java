import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T45821 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Verify that the 1st & Last Page Number is redirected correctly when the project owner select them from all posted Project Search on BIDQA. - Chrome

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
		
		//Click on All Projects
		driver.findElement(By.xpath("//a[text()='All Projects']")).click();
		
		//Find the pages tab and count number of pages
		
		String NoOfPages = driver.findElement(By.xpath("//span[@class='pages']")).getText();
		System.out.println(NoOfPages);
		String LastPage = NoOfPages.substring(10);
		int Lastpage =Integer.parseInt(LastPage);
		System.out.println(LastPage);
		
				
		//Click on page 5 (pages 1 to 4 don't display "First" page)
		driver.findElement(By.xpath("//*[text()='5']")).sendKeys(Keys.ENTER);
				
		//Go back to first page
		driver.findElement(By.xpath("//a[@class='first']")).sendKeys(Keys.ENTER);
		
		new WebDriverWait(driver, 10)
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='current']")));
		//Get the page number 
		String b = (driver.findElement(By.xpath("//span[@class='current']")).getText());
		int number = Integer.parseInt(b);
		System.out.println("First Page selected is: "+driver.findElement(By.xpath("//span[@class='current']")).getText());
		if (number == 1)
		{
			System.out.println("First page is chosen correctly");
		}
		else
		{
			System.out.println("First page is not chosen correctly");
		}
		
		//Go to last page
		driver.findElement(By.xpath("//a[@class='last']")).sendKeys(Keys.ENTER);
		
		new WebDriverWait(driver, 10)
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='current']")));
		//Get the page number 
		String c = (driver.findElement(By.xpath("//span[@class='current']")).getText());
		int number1 = Integer.parseInt(c);
		System.out.println("Last Page selected is: "+driver.findElement(By.xpath("//span[@class='current']")).getText());
		if (number1 == Lastpage)
		{
			System.out.println("Last page is chosen correctly");
		}
		else 
		{
			System.out.println("Last page is not chosen correctly");
		}
		driver.quit();
				
	}

}
