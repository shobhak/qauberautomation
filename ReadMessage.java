package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadMessage {

	public static void main(String[] args) {
		  //invoke browser
		  WebDriver driver = new FirefoxDriver();
		  
		  //log in open bidqa.com
		  driver.get("http://test.bidqa.com/");
		 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("lozadadez1");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		  //read message
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a")).click();
		  driver.findElement(By.linkText("Private Messages")).click();
		  driver.findElement(By.linkText("Read")).click();
		  
		  //show message
		  String Message = driver.findElement(By.xpath("//div[@class='box_content']")).getText();
		  System.out.println("Message: " + Message);
		  
	}

}
