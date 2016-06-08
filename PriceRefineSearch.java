package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PriceRefineSearch {

	public static void main(String[] args) {
		  //invoke browser and open bidqa.com
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
		  //click project search
		  driver.findElement(By.linkText("Project Search")).click();
		  //select price
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='budgets_advanced_search form-control']")));
		  dropdown.selectByVisibleText("Per Hour ($1 - $10)");
		  //click button
		  driver.findElement(By.xpath("//input[@value='Refine Search']")).click();

	}

}
