import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T45827 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//Verify the select Project's Category contains the same search Category selection from the Filter Options section. - Chrome
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
		
		//Click on Home button
				driver.findElement(By.partialLinkText("Home")).click();
						
				//Click on Project Search
				driver.findElement(By.partialLinkText("Project Search")).click();
				
				//Select Location from dropdown
						Select dropdown = new Select (driver.findElement(By.xpath("//select[@name='project_cat_cat']")));
						
						//Get the count of items in dropdown
						int a = driver.findElements(By.xpath("//select[@name='project_location_cat']")).size();
						
						//Generate random number between 1 & int a (above) to put in the dropdown list
								int b = ThreadLocalRandom.current().nextInt(1, a+1);
								
						//Select from dropdown
						dropdown.selectByIndex(b);
								
						//Click on Refine search
						driver.findElement(By.xpath("//input[@value='Refine Search']")).click();
						
						//Print Category chosen
						Thread.sleep(5000);
						driver.findElement(By.partialLinkText("Read More")).click();
						System.out.println("Category :"+driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/div/div/div[1]/ul/li[4]/p")).getText());
						driver.navigate().back();
						
						//Print out the refined search
						int d = driver.findElements(By.xpath("//div[@class='post-title']")).size();
						
						for (int e=0; e<d; e++)
						{
							String title = driver.findElements(By.xpath("//div[@class='post-title']")).get(e).getText();
							System.out.println(title);
						}
						
						//Logout
						driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();

						driver.quit();
	}

}
