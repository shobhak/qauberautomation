import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T45743 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//Verify that user can do "Refine search" using Location. - Chrome
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("http://test.bidqa.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("Su");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Click on Home button
		driver.findElement(By.partialLinkText("Home")).click();
				
		//Click on Project Search
		driver.findElement(By.partialLinkText("Project Search")).click();
		
		//Select Location from dropdown
		Select dropdown = new Select (driver.findElement(By.xpath("//select[@name='project_location_cat']")));
		
		//Get the count of items in dropdown
		int a = driver.findElements(By.xpath("//select[@name='project_location_cat']")).size();
		
		//Generate random number between 1 & int a (above) to put in the dropdown list
				int b = ThreadLocalRandom.current().nextInt(1, a+1);
				
		//Select from dropdown
		dropdown.selectByIndex(b);
				
		//Click on Refine search
		driver.findElement(By.xpath("//input[@value='Refine Search']")).click();
		
		Thread.sleep(5000);
		//Print Location chosen
		driver.findElement(By.partialLinkText("Read More")).click();
		System.out.println("Location :"+driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/div/div/div[1]/ul/li[3]/p")).getText());
		driver.navigate().back();
		
		//Get Project details
		System.out.println("List of Projects");
							
			List<WebElement> listOfOptions = driver.findElements(By.xpath("//div[@class='post-title']"));
			for (WebElement titles: listOfOptions)
			{
				System.out.println(titles.getText());
			}
			
			driver.quit();
		
		
	}	
}
