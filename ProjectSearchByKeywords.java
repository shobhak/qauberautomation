package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ProjectSearchByKeywords {

	public static void main(String[] args) {
		  // invoke browser and open bidqa.com
		WebDriver driver = new FirefoxDriver();
		  driver.get("http://test.bidqa.com/");
		
		  //manage timeouts  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //log in
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("lozadadez1");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		  //hover to myaccount
		  Actions XXX = new Actions (driver);
		  WebElement myAccount = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		  XXX.moveToElement(myAccount).build().perform();
		  
		  //click to project search
		  driver.findElement(By.linkText("Project Search")).click();
		  
		  //type keywords to keyword field
		  driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Automation");
		  
		  //click Refine Search
		  driver.findElement(By.xpath("//input[@value='Refine Search']")).click();
	}

}
