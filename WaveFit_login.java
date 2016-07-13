package mypackage;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaveFit_login {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver" , "C:/Users/Divya/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Step1.Open http://qabidder.net/fits-alfa/#/page/login
		
		String baseUrl = "http://qabidder.net/fits-alfa/#/page/login";
        String expectedTitle = "FITS - FITS Web Application";
        Thread.sleep(3000);
        String actualTitle = "";
        
        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        
        /*
         * compare the actual title of the page witht the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        driver.manage().window().maximize();
        Thread.sleep(2000);
        
        //Step2.Enter email 
        driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("dsharma1410+6@gmail.com");
        System.out.println("Email enter successfully");
        Thread.sleep(2000);
        
        //Step3. Enter Password
        driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("Qabidder");
        System.out.println("Password Enter Successfully");
        Thread.sleep(2000);
        
        //Step4. Click on Login
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000); 
        
        Random rand = new Random();
        int  n = rand.nextInt(1000) + 5;
        
        //Step5. Take a screenshot of the result
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
         FileUtils.copyFile(scr, new File("C:/Users/Divya/Desktop/Automation_login" +n+".jpg"));
        } catch (IOException e) {
         e.printStackTrace();
        }
        
        
        
        

	}

}
