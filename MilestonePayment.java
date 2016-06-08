package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MilestonePayment {

	public static void main(String[] args) {
		//invoke browser and open site
		  WebDriver driver = new FirefoxDriver();
		  String Url = "http://test.bidqa.com/";
		  driver.get(Url);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		  //log in 
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("lozadadez1");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		  //hover to myAccount
		  Actions XXX = new Actions(driver);
		  WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		  XXX.moveToElement(myAcc).build().perform();
		  
		  //click on finances
		  driver.findElement(By.linkText("Finances")).click();
		  
		  //click on make milestone payment
		  driver.findElement(By.linkText("Milestone Payments")).click();
		  
		  //select project
		  Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id='my_proj_sel']")));
		  dropdown1.selectByVisibleText("Perfomance Tester Needed");
		  
		  //enter amount
		  driver.findElement(By.xpath("//input[@id='amount_text']")).sendKeys("50");
		  
		  //enter QA engineer
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Geeta");
		  
		  //enter description
		  driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Hello, thanks!");
		  
		  //add date
		  driver.findElement(By.xpath("//*[@id='completion_date']")).click();
		  driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/a[2]/span")).click();
		  driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/a[2]/span")).click();
		  driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[6]/td[1]/a")).click();
		  driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
		  
		  //click create Milestone payment
		  WebElement OOO = driver.findElement(By.xpath("//input[@id='submit_milestone']"));
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", OOO);
		  
		  
	}

}
