package login1;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver
//import org.openqa.selenium.Keys
public class login_wave {

	public static void main(String[] args)throws Exception{
		
		// open Chrome browser
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
      //  driver.manage().deleteAllCookies();
        driver.get("http://www.testwave.qabidder.net/");
        Thread.sleep(2000);
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("smi16p+55@gmail.com");   
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("test123");
         Thread.sleep(1000);      
        // click on the login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul/li[2]/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/div[1]/div[1]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/div[1]/div[1]/input")).sendKeys("suri");
        driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/div[1]/div[2]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/div[1]/div[2]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/div[1]/div[2]/input")).sendKeys("smi");
        Thread.sleep(1000);
        System.out.println("success");
       
        // click on view button
        driver.findElement(By.xpath("//tr[1]/td/div/div/div/div[6]/a")).click();
        Thread.sleep(1000);
        // click on add report
        driver.findElement(By.xpath("//span[contains(.,'Add Report')]")).click();
        Thread.sleep(1000); 
        // select radio button for organization
        driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[2]/fieldset/div[1]/div/div/label")).click();
       // driver.findElement(By.("ng-binding")).click();
        Thread.sleep(1000);
        System.out.println("printing");
                //element.click();
        
         // click on next button
        driver.findElement(By.xpath("//div/div[2]/ul/li/a/span")).click();
        Thread.sleep(1000);
        // appearance page 
        // Click on First  name
        driver.findElement(By.xpath("//input[contains(@name,'first-name')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@name,'first-name')]")).sendKeys("priya");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@name,'last-name')]")).click(); 
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@name,'last-name')]")).sendKeys("dutt"); 
        Thread.sleep(1000);
         driver.findElement(By.xpath("//input[contains(@name,'last-name')]")).click(); 
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[contains(.,'Suspect')]")).click();  
        Thread.sleep(1000);
        
         
        
        //Signinbutton.click();
        // close the browser
        driver.close();
        System.out.println("test script execute successfully.");
        // terminate the program
//        System.exit(0);      

               
		
		
		
	}

}
