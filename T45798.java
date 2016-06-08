import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Verify that "QA Engineer Search" works correctly using "Rating" field  - Chrome
		
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
		
		//Click on QA Engineer search
		driver.findElement(By.partialLinkText("QA Engineer Search")).click();
		
		//Generate random number to send to Rating tab
		String a = String.valueOf(ThreadLocalRandom.current().nextInt(0, 6));
		
		//Click on Rating & send random number between 0 & 5
		driver.findElement(By.xpath("//input[@name='rating_over']")).sendKeys(a);
		
		//Click on Search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		//Get rating details
		System.out.println("The chosen rating is "+a);
		//Get QA Engineer details
		int d = driver.findElements(By.xpath("//div[@class='post-main-details']/ul/li[1]/a[1]")).size();
		System.out.println("There are "+d+" QA Engineers");
		
		try{
		for (int b=0; b<d; b++)
		{
			String QAEngineer = driver.findElements(By.xpath("//div[@class='post-main-details']/ul/li[1]/a[1]")).get(b).getText();
			System.out.println(QAEngineer);
			}
			}
		catch(Exception NoQA)
		{
			System.out.println("No QA Engineers to list");
		}
		driver.quit();
	}

	

}
