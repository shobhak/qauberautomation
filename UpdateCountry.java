package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UpdateCountry {

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
		  
		  //update country
		  Actions XXX = new Actions(driver);
		  WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		  XXX.moveToElement(myAcc).build().perform();
		  
		  driver.findElement(By.linkText("Personal Info")).click();
		  
		  //Select Country
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='user_city']")));
		  dropdown.selectByIndex(5);
		  
		  
		  //clicking save button using JavascriptExecutor
		  WebElement element = driver.findElement(By.xpath("//input[@name='save-info']"));
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", element);

	}

}
