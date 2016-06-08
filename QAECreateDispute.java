package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class QAECreateDispute {

	public static void main(String[] args) {
		//invoke browser and open bidqa.com
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://test.bidqa.com/");
		
		//manage timeouts
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		//log in
		  driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		  driver.findElement(By.xpath("//*[@id='log']")).sendKeys("dezlozada");
		  driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("dennislozada21");
		  driver.findElement(By.xpath("//*[@id='submits']")).click();
		  
		//Hover to my Account
		  Actions XXX = new Actions(driver);
		  WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		  XXX.moveToElement(myAcc).build().perform();
		  
		//Create disputes
		  driver.findElement(By.linkText("Disputes")).click();
		  driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div[2]/form/div/div[2]/div/textarea")).sendKeys("XYZ");
		  driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div[2]/form/div/div[3]/div/input")).click();
	  
		//Get Text Message
		 String ActualDisputeMessage = driver.findElement(By.xpath("//*[@class='saved_thing']")).getText();
		 
	    //String creation
		 String ExpectedDisputeMessage = "Dispute created.";
		 System.out.println("Expected Result Message: Dispute created." );
		 System.out.println("Actualt Result Message: " + ActualDisputeMessage);
		 
		 //ACTUAL VS EXPECTED 
		 if (ActualDisputeMessage.equals(ExpectedDisputeMessage)){
			 System.out.println("TEST PASSED");
		 }
		 else {
			 System.out.println("TEST FAILED");
		 }
	  
	    //Close browser
		 driver.close();

	}

}
