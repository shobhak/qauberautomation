package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FeaturedRefineSearch {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		  driver.get("http://test.bidqa.com/");
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //log in
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("lozadadez1");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		  //hover to myaccount
		  Actions AAA = new Actions(driver);
		  WebElement myAccount = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		  AAA.moveToElement(myAccount).build().perform();
		  
		  
		  //refine search check featured 
		  driver.findElement(By.linkText("Project Search")).click();
		  driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Automation");
		  driver.findElement(By.xpath("//input[@name='featured']")).click();
		  driver.findElement(By.xpath("//input[@value='Refine Search']")).click();
		  
		  //Verify Featured Project
		  String ExpTag = driver.findElement(By.xpath("//*[@id='post-4127']/div/div[1]/span")).getText();
		  System.out.println("Total Featured Project PerScreen " + driver.findElements(By.className("featured_thing_project2")).size());
		  
		  if (ExpTag.equals("Featured Project"));
		  {
			  System.out.println("Test Passed");
		  }
		    
		  
	}

}
