package log4j;

import java.io.File;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;	
import org.openqa.selenium.OutputType;

   public class log4j_login2 {
   static Logger log = Logger.getLogger(log4j_login2.class);
			
   public static void main(String[] args) throws InterruptedException, IOException {
   Date date= new Date();
   SimpleDateFormat dateFormat= new SimpleDateFormat("MM-dd-yyyy");
   String curDate= dateFormat.format(date);
			 			 
   Random rand = new Random();
   int  n = rand.nextInt(1000) + 5;
   
	System.setProperty("webdriver.chrome.driver" , "C:/chromedriver_win32/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
		  
    Thread.sleep(3000);
		   
    try{	
//Step1. Open URL
        driver.get("http://qabidder.net/fits-alfa/#/page/login");
        Thread.sleep(3000);
        log. debug(new Timestamp(date.getTime()) + ":" + "Step1: URL is opened Successfully");
        log.debug("--------------------------------------------------------------------------------------------------");
        
		driver.manage().window().maximize();
		Thread.sleep(2000);

//Step2. Enter email address
		driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("weixj828@hotmail.com");
		Thread.sleep(2000);
		
		log.debug(new Timestamp(date.getTime()) + ":" + "Step2 Email is entered successfully");
		log.debug("--------------------------------------------------------------------------------------------------");
		
//Step3. Enter Password
		driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("890uiojkl");
		log.debug(new Timestamp(date.getTime()) + ":"+"Step3 Password is Entered Successfully");
		Thread.sleep(2000);
		log.debug("---------------------------------------------------------------------------------------------------");
		
//Step4. Click on Login
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         log.debug(new Timestamp(date.getTime())+":"+"Step4.Click on login Successfully");
         log.debug("------------------------------------------------------------------------------------------------------");
         Thread.sleep(2000); 
         
//Step5. Take a screenshot of the result
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {    
		FileUtils.copyFile(scr, new File("C:/tmp/"+curDate+"/"+"Screenshots_"+curDate+"/"+curDate+"_"+n+".jpg"));
		        } 
		catch (IOException e) {
		         e.printStackTrace();
		         }
		log.debug(new Timestamp(date.getTime())+":"+"Step5.Screenshot Capture Successfully");
		log.debug("-----------------------------------------------------------------------------------------------------");       
		
//Step6. Get information of os and browser
		log.debug(System.getProperty("os.name"));
		Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
        log.info("Browser Name : " + caps.getBrowserName());
        log.info("Browser Version : " + caps.getVersion());
		         
        driver.close();  
        log.debug("This is the end.");
       
        File source=new File("C:\\tmp\\log4j_login2.txt");
        File dest=new File("C:/tmp/"+curDate+"/"+"Logs_"+curDate+"/"+curDate+"_"+n+".txt");
        FileUtils.copyFile(source, dest);
    }

//If error happens, catch the error message    
    catch (Exception e) {
    	  log.error("------------ERROR----------------------------------------------ERROR------------------------------");
    	  log.error("Exception has occured : " + e.getMessage());
    	  }
    
//Catch screenshot when error occurs, label the screenshot as "Failed..."
    	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
    	 FileUtils.copyFile(scr, new File("C:/tmp/"+curDate+"/"+"Screenshots_"+curDate+"/"+"Failed_"+curDate+"_"+n+".jpg"));
    	} catch (IOException e) {
    	 e.printStackTrace();
    	}
    	driver.close();
//Catch log when error occurs, label the log file as "Failed..."
    	log.debug("This test is failed.");
    	File source=new File("C:\\tmp\\log4j_login2.txt");
    	File dest=new File("C:/tmp/"+curDate+"/"+"Logs_"+curDate+"/"+"Failed_"+curDate+"_"+n+".txt");
    	FileUtils.copyFile(source, dest);
    	}}	
  