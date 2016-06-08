package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EscrowPayment {

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
		  
		  //click on Finances, Deposit Escrow Payment
		  driver.findElement(By.linkText("Finances")).click();
		  driver.findElement(By.linkText("Deposit Escrow")).click();
		  
		  //enter amount 50
		  driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("50");
		  
		  //select a project 
		  Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='my_proj_sel']")));
		  dropdown.selectByVisibleText("Perfomance Tester Needed");
		  
		  //Enter QA engineer Name
		  driver.findElement(By.xpath("//*[@id='win_providers']/input")).sendKeys("Geeta");
		  
		  //click on Make Escrow
		  WebElement element = driver.findElement(By.xpath("//input[@value='Make Escrow']"));
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", element);

		  String Actual = driver.findElement(By.xpath("//div[@class='saved_thing']")).getText();
		  String Expected = "Your payment has been sent. Redirecting...";
		  
		  
		  //ACTUAL VS EXPECTED
		  if(Actual.equals(Expected)){
			  System.out.println("Test Passed");
		  }
		  else {
			  System.out.println("Test Failed");
		  }
	
		  //close bidqa
		  driver.close();
	}

}
