import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.TakesScreenshot;
/*
 * This test case verifies test case #T76670 that the Hamburger Icons are functional.
 * Accordingly, the steps are go to the test wave web-application page, enter email
 *  and password information 
 * click submit, then verify that the hamburger icons are functional and then logout and exit the browser.
 * Presently works on Chrome but can also run on Firefox 
 */


public class HamburgerIconT76670 {
	
	public static void main (String []args) throws Exception{
		    
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\shobha\\chromedriver.exe");        
	
			//WebDriver driver = new FirefoxDriver();
			WebDriver driver = new ChromeDriver();
						
			//webpage
			driver.get("http://testwave.qabidder.net/#/page/login");
			
			//wait
			Thread.sleep(1000);
			
			//email field
	        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();
	        driver.findElement(By.xpath("//input")).sendKeys("dummyemail1938+4@gmail.com");
	      
	        //password field
	        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).clear();
	        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("Thisis4u");
	        //wait
	        Thread.sleep(2000);
	        // submit
	        driver.findElement(By.xpath("//button")).click();
	        Thread.sleep(2000);
	        
	        //Check whether Navigation panel is functional
             new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.nav.ng-scope"))).click();
             Thread.sleep(2000);
	
             // logout  
	        driver.findElement(By.xpath("//ul[2]/li/a")).click();
	        Thread.sleep (1000);
	        
	        //browser quit
	        driver.quit();
	           
	}//main
}//HamburgerIconT76670
