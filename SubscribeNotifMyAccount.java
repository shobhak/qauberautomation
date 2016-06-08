package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SubscribeNotifMyAccount {

	public static void main(String[] args) {
		  //invoke and open bidqa
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://test.bidqa.com/");
		  
		  //manage timeouts
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //log in
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("dezlozada");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		  //get notification emails. click on My Subscription
		  driver.findElement(By.linkText("My Subscriptions")).click();
		  
		  //select category
		  Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='category']")));
		  dropdown.selectByVisibleText("Automation – Mobile");
		  
		  //select location
		  Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id='location']")));
		  dropdown1.selectByVisibleText("Afghanistan");
		  
		  //click subscribe button
		  driver.findElement(By.xpath("//*[@id='subscribe-form']/button")).click();

	}

}
