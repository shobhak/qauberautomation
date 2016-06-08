package bidQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Support {

	public static void main(String[] args) {
		  //invoke browser and open bidqa
		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://test.bidqa.com/");
		  //manage timeouts
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //Click support
		  driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a")).click();
		  // Enter Name
		  driver.findElement(By.xpath("//*[@id='wpcf7-f146-p1315-o1']/form/p[2]/span/input")).sendKeys("Dennis");
		  //enter email
		  driver.findElement(By.xpath("//*[@id='wpcf7-f146-p1315-o1']/form/p[3]/span/input")).sendKeys("dezlozada+1@gmail.com");
		  //enter subject
		  driver.findElement(By.xpath("//*[@id='wpcf7-f146-p1315-o1']/form/p[4]/span/input")).sendKeys("idk");
		  //Enter message
		  driver.findElement(By.xpath("//*[@id='wpcf7-f146-p1315-o1']/form/p[5]/span/textarea")).sendKeys("my message");
		  //click
		  driver.findElement(By.xpath("//*[@id='wpcf7-f146-p1315-o1']/form/p[6]/input")).click();
		  
		  

	}

}
