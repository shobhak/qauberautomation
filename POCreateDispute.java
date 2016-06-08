package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class POCreateDispute {

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
		  
		  //create dispute
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a")).click();
		  driver.findElement(By.xpath("//*[@id='my-account-admin-menu']/li[6]/a")).click();
		  driver.findElement(By.cssSelector("textarea[class='disput_comment form-control']")).sendKeys("asasasasassa");
		  driver.findElement(By.cssSelector("input[value='Create Dispute']")).click();
		  
		  //close browser
		  driver.close();

	}

}
