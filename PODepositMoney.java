package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class PODepositMoney {

	public static void main(String[] args) throws InterruptedException{
		/*NOTE!!!!!!!! 
		 * before running the script, 
		 * try to first execute the Test Case manually 
		 * and, when you reach to the part where 
		 * you pay with paypal, on the page click on  "stay on thesame window/or something similar"
		 * THANKS! */
	
		
		
		// Create Firefox Profile  
		FirefoxProfile profile = new FirefoxProfile();  
		// Accept Untrusted Certificates  
		profile.setAcceptUntrustedCertificates(true);  
		//Intialize Forfox driver  
		WebDriver driver = new FirefoxDriver(profile);     
	
		String Url = "http://test.bidqa.com/";
		driver.get(Url);
				
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		//click log in
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
				
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
		
		//click on submit
		driver.findElement(By.xpath("//input[@id='submits']")).click();
		
		//hover to myAccount
		Actions XXX = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		XXX.moveToElement(myAcc).build().perform();
		
		//click on finances
		WebElement Finances = driver.findElement(By.linkText("Finances"));
		XXX.click(Finances).build().perform();
		
		Thread.sleep(3000);
		
		String MoneyBefore = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]/span")).getText();
		
		//click on deposit money
		driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/ul/li[1]/a")).click();
		
		//enter the amount of money
		driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("50");
		
		//click deposit
		WebElement button = driver.findElement(By.xpath("//input[@value='Deposit']"));
		XXX.click(button).build().perform();
		
		//wait
		
		Thread.sleep(5000);
		
		
		//click on pay with paypal
		WebElement PayPal = driver.findElement(By.xpath("//*[@id='loadLogin']"));
		XXX.click(PayPal).build().perform();
		
		//enter email
		WebElement email = driver.findElement(By.xpath("//*[@id='login_email']"));
		email.sendKeys("dezlozada-buyer@yahoo.com");
		
		//enter password
		WebElement password = driver.findElement(By.xpath("//*[@id='login_password']"));
		password.sendKeys("dennisqa123");
		
		//click on login
		WebElement Lbutton = driver.findElement(By.xpath("//*[@id='submitLogin']"));
		XXX.moveToElement(Lbutton).click().build().perform();
		
		//manage timeouts
		Thread.sleep(5000);
		
		//click on Pay Now
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		
		//wait
		Thread.sleep(3000);
		
		//open bidqa
		driver.get(Url);
		
		//wait
		Thread.sleep(5000);
		
		//click log in
		//driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
			
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//hover
		//XXX.moveToElement(myAcc).build().perform();
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Finances")).click();
		
		
		//click on Finances linktext
		//driver.findElement(By.linkText("Finances")).click();
		
		//validation
		String MoneyAfter = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]/span")).getText();
		
		if(MoneyBefore.equals(MoneyAfter))
		{
			System.out.println("Test Failed");
		}
		else 
		{
			System.out.println("Test Passed");
		}
		
		
		
		//close browser
		driver.close();
		
	}

}
