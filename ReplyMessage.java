package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ReplyMessage {

	public static void main(String[] args) {
		//invoke browser and open site
		  WebDriver driver = new FirefoxDriver();
		  String Url = "http://test.bidqa.com/";
		  driver.get(Url);
		  //manage timeouts
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //log in 
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("lozadadez1");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  //hover to myaccount
		  Actions XXX = new Actions(driver);
		  WebElement myAccount = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
		  XXX.moveToElement(myAccount).build().perform();
		  //Reply to message
		  driver.findElement(By.linkText("Private Messages")).click();
		  driver.findElement(By.linkText("Inbox")).click();
		  driver.findElement(By.linkText("Read")).click();
		  driver.findElement(By.linkText("Reply")).click();
		  //enter message reply
		  driver.findElement(By.xpath("//*[@id='subject_a']")).sendKeys("Reply");
		  //click button
		  WebElement XXX1 = driver.findElement(By.xpath("//*[@id='subject_a']"));
		  XXX1.sendKeys(Keys.TAB);
		  driver.switchTo().activeElement().sendKeys("Finally, i sent my message!");
		  driver.findElement(By.xpath("//input[@value='Send Message']")).click();
		  
		  //view confirmation
		  String ConMess = driver.findElement(By.xpath("//*[@id='content']/div[3]/div")).getText();
		  System.out.println("Confirmation message: " + ConMess);
		  
		  
		  
	}

}
