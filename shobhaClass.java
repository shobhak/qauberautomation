import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.*;
import org.openqa.selenium.TakesScreenshot;

public class shobhaClass {

	public static void main (String []args) throws Exception{

		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		driver.get("http://testwave.qabidder.net/#/page/login");
		Thread.sleep(1000);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("C:\\Users\\shobha\\Desktop.png"));
		//#email field
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();
        driver.findElement(By.xpath("//input")).sendKeys("dummyemail1938+3@gmail.com");
        FileUtils.copyFile(scrFile, new File("C:\\Users\\shobha\\Desktop.png"));
        //password field
        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).clear();
        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("Thisis4u");
        //wait
        Thread.sleep(3000);
        // submit
        driver.findElement(By.xpath("//button")).click();

        //passedNavigation test case #1 Verify that the hamburger icon is functional
        //	driver.findElement(By.xpath("//li/a").is_selected()
        //driver.find_element_by_css_selector("a.hidden-xs").is_enabled()

        //passed Navigation test case #2 Verify that the reports button in main navigation works
        //driver.findElement(By.xpath("//a/span").is_selected()

       //    passed Navigation test case #3 verify Add report button in left main navigation works
      //  driver.find_element_by_xpath("//li[3]/a/span").is_selected()

        //#passed Navigation test case #4 Verify users button in main navigation is functional
        //driver.find_element_by_xpath("//li[4]/a/span").is_selected()

        //Navigation test case that the profile panel is functional
        //  driver.findElement(By.xpath("//li[2]/a")).click();
         // driver.findElement(By.xpath("//li[2]/a")).click();

          Thread.sleep(2000);
        // +++ testing logout  functionality
        //  driver.findElement(By.partialLinkText('Logout')).click();

         // Thread.sleep(2000);

	
	
	}  
	}

