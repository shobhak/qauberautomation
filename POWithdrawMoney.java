package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class POWithdrawMoney {

	public static void main(String[] args) {
		  //invoke browser open site
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://test.bidqa.com/");
		  
		  //manage timeouts
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
		  
		  //click on finace
		  driver.findElement(By.linkText("Finances")).click();
		  
		  //click on withdraw money
		  driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/ul/li[4]/a")).click();
		  
		  //enter amount
		  driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("60");
		  
		  //click button
		  driver.findElement(By.xpath("//*[@id='form1']/div/div[3]/div/input")).click();
		  

	}

}
