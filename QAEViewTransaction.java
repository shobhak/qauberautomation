package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class QAEViewTransaction {

	public static void main(String[] args) {
		  // invoke browser
		  WebDriver driver = new FirefoxDriver();
		  //open bidqa
		  driver.get("http://test.bidqa.com/");
		  //manage timeouts
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //log in
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("dezlozada");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		  //hover to my account
		  Actions XXX = new Actions(driver);
		  WebElement myAc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		  XXX.moveToElement(myAc).build().perform();
		  
		  //click on finances
		  driver.findElement(By.linkText("Finances")).click();
		  //click on transaction
		  driver.findElement(By.linkText("Transactions")).click();
		  
		  String Trans = driver.findElement(By.xpath("//div[@class='box_content']")).getText();
		  System.out.println("Transactions: " + Trans);
	}

}
