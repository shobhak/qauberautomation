package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RateUser {

	public static void main(String[] args) {
		//invoke browser
		  WebDriver driver = new FirefoxDriver();
		 
		  //log in
		  driver.get("http://test.bidqa.com/");
		 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("lozadadez1");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		  //feedback//reviews
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a")).click();
		  driver.findElement(By.xpath(".//*[@id='my-account-admin-menu']/li[5]/a")).click();
		  driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]/table/tbody/tr[2]/th[6]/a")).click();
		  
		  //rate the user
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='rating']")));
		  dropdown.selectByVisibleText("5");
		  
		  driver.findElement(By.xpath("//textarea[@class='do_input form-control']")).sendKeys("sasasas");
		  driver.findElement(By.cssSelector("input[class='green_btn']")).click();

	}

}
