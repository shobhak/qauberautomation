//import java.io.File;
import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.TakesScreenshot;


public class shobhaClass {

	public static void main (String []args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shobha\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://testwave.qabidder.net/#/page/login");
		Thread.sleep(1000);
		//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\shobha\\Desktop.png"));
		//#email field
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();
        driver.findElement(By.xpath("//input")).sendKeys("dummyemail1938+4@gmail.com");
      //  FileUtils.copyFile(scrFile, new File("C:\\Users\\shobha\\Desktop.png"));
        //password field
        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).clear();
        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("Thisis4u");
        //wait
        Thread.sleep(2000);
        // submit
        driver.findElement(By.xpath("//button")).click();

        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//a[contains(text(),'Logout')]")).click();
        driver.findElement(By.xpath("//ul[2]/li/a")).click();
        
        driver.quit();
        
        
	
	}  
	}

