package qauber.com.testwave;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.github.javafaker.*;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.OutputType;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.TakesScreenshot;

//import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



//import newlogMsg2file.*;

public class registration {
	public static void main (String []args) throws Exception{
		final Logger log = Logger.getLogger(registration.class);

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shobha\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
        // maximize the browser window
         driver.manage().window().maximize();
		//webpage
		//driver.get("http://testwave.qabidder.net/#/page/login");
		driver.get("http://testwave.qabidder.net/#/page/register-sa");
		PropertyConfigurator.configure("log4j2.properties");
		log.debug("This is the additional info");
		  
		//wait
		Thread.sleep(1000);
	    //find registration element and click
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		Faker fake = new Faker();
		String loginName= fake.firstName();
		//keep a check for name length since it has to be atleast 6 alphanumeric chars
		if( loginName.length()<= 2)
			{
		       loginName = loginName + "shil";
			
			}//if 
		else if (loginName.length()<=3)
		{  
			
			loginName = loginName +"shi";
			
		}//elseif
		
		else if (loginName.length()<=4)
		{
			loginName = loginName +"sh";
			
		}
		else if (loginName.length()<=5)
		{
		  loginName = loginName + "ss";	
		
		}
		
		//enter the name field
		driver.findElement(By.name("account_name")).sendKeys(loginName);
		
		Thread.sleep(1000);
		//declaring a string calling method randomEmail . The method is below.
		final String randomEmail = randomEmail();
		//finding the email element and sending randomEmail there
		driver.findElement(By.name("account_email")).sendKeys(randomEmail);
	    	
		Thread.sleep(1000);
		//finding the password element and sending  password
		driver.findElement(By.id("id-password")).sendKeys("Thisis4ema");
		
		Thread.sleep(1000);
		//finding the retype password field and entering the same password in this form
		driver.findElement(By.name("account_password_confirm")).sendKeys("Thisis4ema");
		
		Thread.sleep(3000);
		//click on Continue Registration
		driver.findElement(By.xpath("//button")).click();
		
		Thread.sleep(2000);
		//find the companyName element and send random company name
		String companyName = fake.name();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(companyName);

		Thread.sleep(1000);
		String phoneNum  = fake.phoneNumber();
		driver.findElement(By.name("phone")).sendKeys(phoneNum);
		
		Thread.sleep(1000);
		

		driver.findElement(By.name("email")).sendKeys(randomEmail);
		Thread.sleep(2000);
		//find the address field and enter faker generated address
		String address = fake.secondaryAddress();
		driver.findElement(By.name("address1")).sendKeys(address);

		Thread.sleep(2000);
		//find the city field and enter faker generated city
		String cityField = fake.cityPrefix();
		driver.findElement(By.name("city")).sendKeys(cityField);
		
		//select the state from the drop down list
		Select dropdown= new Select(driver.findElement(By.name("state")));
		dropdown.selectByVisibleText("Texas");
		
		Thread.sleep(1000);
		//declare a string called zip and get faker generated zip code
		String zipCode = fake.zipCode();
		//find the zip code element and enter
		driver.findElement(By.name("zip")).sendKeys(zipCode);
		
		Thread.sleep(1000);
		//click on Finish Registration button
		driver.findElement(By.xpath("//div[3]/button")).click();

		//take a screenshot of the successful registration page 
		File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot2,new File("C:\\Users\\shobha\\Desktop\\New folder\\registration\\image.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//browser quit
        //driver.quit();
	}// mainaccount_name
		
		 private static String randomEmail() {
		        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
		    }

}//registration
