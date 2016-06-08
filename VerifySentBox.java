package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class VerifySentBox {

	public static void main(String[] args) {
		  //invoke browser
		  WebDriver driver = new FirefoxDriver();
		  
		  //open bidqa and manage timeouts 
		  driver.get("http://test.bidqa.com/");
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		  //log in
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("lozadadez1");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		  //Hover to myAcc
		  Actions XXX = new Actions(driver);
		  WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		  XXX.moveToElement(myAcc).build().perform();
		  
		  //verify sentbox 
		  driver.findElement(By.linkText("Private Messages")).click();
		  driver.findElement(By.linkText("Sent Items")).click();
		  
		  //print sent item logs
		  String XXXX = driver.findElement(By.xpath("//*[@id='content']/div[3]")).getText();
		  System.out.println(XXXX);
		
	}

}
