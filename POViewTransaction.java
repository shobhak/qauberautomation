package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class POViewTransaction {

	public static void main(String[] args) {
		//invoke browser and log in
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://test.bidqa.com/");
		 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //Log in
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("lozadadez1");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		  //view transactions
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a")).click();
		  driver.findElement(By.linkText("Finances")).click();
		  driver.findElement(By.linkText("Transactions")).click();
		  System.out.println(driver.getTitle());

	}

}
