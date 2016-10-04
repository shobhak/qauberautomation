import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


	/* This script is testing the Main Navigation of Wave Fit test wave application
	 * specifically testing T76674	Verify "Entities" link is functional. There is 
	 * login, checking the Entities link is functional and then logs out of the 
	 * application and exits the browser. This is on Chrome browser but can also run on Firefox
	/tester- Shobha Vaidyanathan 
	 **/

	public class EntitiesLinkT76674 {
		public static void main (String []args) throws Exception{
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\shobha\\chromedriver.exe");
		   //WeDriver driver = new FirefoxDriver();
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
	     //+++++++++++++++++++++++++++
	
	        // click on Entities
	        driver.findElement(By.xpath("//li[5]/a/span")).click();	        
	        Thread.sleep(2000);
	        
	        //logout
	        driver.findElement(By.xpath("//ul[2]/li/a")).click();
	        //browser quit
	        driver.quit();
	           

	
		}//main
	}//Entities Link
	
	
	
