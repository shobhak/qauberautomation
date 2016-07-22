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

   public class Wavefit_AddReport_June {
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
//Open URL
        driver.get("http://qabidder.net/fits-alfa/#/page/login");
        Thread.sleep(3000);
        log. debug(new Timestamp(date.getTime()) + ":" + "URL is opened Successfully");
        log.debug("--------------------------------------------------------------------------------------------------");
        
		driver.manage().window().maximize();
		Thread.sleep(2000);

//Enter email address
		driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("weixj828@hotmail.com");
		Thread.sleep(2000);
		
		log.debug(new Timestamp(date.getTime()) + ":" + "Email is entered successfully");
		log.debug("--------------------------------------------------------------------------------------------------");
		Thread.sleep(2000);
		
//Enter Password
		driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("890uiojkl");
		Thread.sleep(2000);
		log.debug(new Timestamp(date.getTime()) + ":"+"Password is Entered Successfully");
		Thread.sleep(2000);
		log.debug("----------------------------------------------------------------------------------------------------------------");
		
//Click on Login
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         Thread.sleep(2000);
         log.debug(new Timestamp(date.getTime())+":"+"Click on login Successfully");
         log.debug("------------------------------------------------------------------------------------------------------------------");
         Thread.sleep(2000); 
         
//Click on Add Report
         driver.findElement(By.xpath("/html/body/div[2]/aside[1]/div/nav/ul/li[3]/a/span")).click();
         Thread.sleep(2000);
//Enter information
         driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[1]/div/div/input")).sendKeys("weixj828");
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[3]/div/div/input")).sendKeys("Wave");
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[4]/div/div/select")).click();
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[4]/div/div/select/option[2]")).click();
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[2]/div[1]/div/div/p/input")).sendKeys("08-29-1985");
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[2]/div[2]/div/div/input")).sendKeys("Fit");
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[2]/div[3]/div/div/select")).click();
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[2]/div[3]/div/div/select/option[3]")).click();
         Thread.sleep(1500);
         driver.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/ul/li/a")).click();
         Thread.sleep(4000);
         driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[2]/fieldset/div[1]/div[1]/div/div/span/input")).click();
         Thread.sleep(1500);
         driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[2]/ul/li[2]/a")).click();
         Thread.sleep(4000);
         driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[3]/fieldset/div[1]/div[1]/div/div/input")).sendKeys("English");
         Thread.sleep(4000);
         driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[3]/ul/li[2]/a")).click();
         Thread.sleep(4000);
         driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[4]/ul/li[2]/a")).click();
         Thread.sleep(4000);
         driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[5]/ul/li[2]/a")).click();
         Thread.sleep(4000);
         driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/ul/li[2]/a")).click();
         Thread.sleep(4000);
         driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/div/p[2]/a[1]")).click();
         Thread.sleep(6000);
         String text=driver.findElement(By.xpath(".//*[@id='ngdialog1-aria-labelledby']")).getText();
         log.debug("----------------------------------------------------"+text+"---------------------------------------------------------");
         
         if (text.contentEquals("Report ID")) {
        	 log.debug("-------------------------------------------------------------------------------------------------------------------");
        	 log.debug("This test case is passed.");
        	 log.debug("-------------------------------------------------------------------------------------------------------------------");
         }
         
         
//Take a screenshot of the result
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {    
		FileUtils.copyFile(scr, new File("C:/tmp/"+curDate+"/"+"Screenshots_"+curDate+"/"+curDate+"_"+n+".jpg"));
		        } 
		catch (IOException e) {
		         e.printStackTrace();
		         }
		log.debug(new Timestamp(date.getTime())+":"+"Step5.Screenshot Capture Successfully");
		log.debug("-----------------------------------------------------------------------------------------------------");       
		
//Get information of os and browser
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
    	  log.error("--------------------------------ERROR----------------------------------------------ERROR-------------------------------------");
    	  log.error("Exception has occured : " + e.getMessage());
    	  }
    
//Catch screenshot when error occurs, label the screenshot as "Failed..."
    	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
    	 FileUtils.copyFile(scr, new File("C:/tmp/"+curDate+"/"+"Screenshots_"+curDate+"/"+"Failed_AddReport"+curDate+"_"+n+".jpg"));
    	} catch (IOException e) {
    	 e.printStackTrace();
    	}
    	driver.close();
//Catch log when error occurs, label the log file as "Failed..."
    	log.debug("This test is failed.");
    	File source=new File("C:\\tmp\\log4j_login2.txt");
    	File dest=new File("C:/tmp/"+curDate+"/"+"Logs_"+curDate+"/"+"Failed_AddReport"+curDate+"_"+n+".txt");
    	FileUtils.copyFile(source, dest);
    	}}	
  