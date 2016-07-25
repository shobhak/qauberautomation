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

	public class Wavefit_ChangeSubscription {
		
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
	        driver.get("http://testwave.qabidder.net/#/page/login");
	        Thread.sleep(3000);
	        log. debug(new Timestamp(date.getTime()) + ":" + "URL is opened Successfully");
	        log.debug("-----------------------------------------------------------------------------------------------------------------------");
	        
			driver.manage().window().maximize();
			Thread.sleep(2000);

	//Enter email address
			driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("weixj828@hotmail.com");
			Thread.sleep(2000);
			
			log.debug(new Timestamp(date.getTime()) + ":" + "Email is entered successfully");
			log.debug("------------------------------------------------------------------------------------------------------------------------");
			Thread.sleep(2000);
			
	//Enter Password
			driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("890uiojkl");
			Thread.sleep(2000);
			log.debug(new Timestamp(date.getTime()) + ":"+"Password is Entered Successfully");
			log.debug("------------------------------------------------------------------------------------------------------------------------");
			
	//Click on Login
			 driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();
	         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	         Thread.sleep(2000);
	         log.debug(new Timestamp(date.getTime())+":"+"Click on login Successfully");
	         log.debug("-----------------------------------------------------------------------------------------------------------------------");
	         Thread.sleep(2000); 
	         
	//Click on Profile Panel button
	         driver.findElement(By.xpath("html/body/div[2]/header/nav/div[2]/ul[2]/li[2]/a/em")).click();
	         Thread.sleep(5000);
	//Click on one subscription
	         driver.findElement(By.xpath("/html/body/div[2]/aside[2]/nav/div/div/div[1]/div/div/li[3]/a/h4[1]/div")).click();
	         Thread.sleep(6000);
	
	//Change numbers of the subscription
	         driver.findElement(By.xpath("html/body/div[3]/div[2]/div[1]/input")).clear();
	         driver.findElement(By.xpath("html/body/div[3]/div[2]/div[1]/input")).sendKeys(Float.toString(n));
	         
	         Thread.sleep(5000);
	         driver.findElement(By.xpath("html/body/div[2]/aside[2]/nav/div/div/div[1]/div/div/li[3]/a/h4[1]/div")).click();
	         Thread.sleep(3000);
	       
	       log.debug("This test case is passed.");
	       log.debug("-----------------------------------------------------------------------------------------------------------------------");
	       
	//Take a screenshot of the result
	        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {    
			FileUtils.copyFile(scr, new File("C:/tmp/"+curDate+"/"+"Screenshots_"+curDate+"/"+"ChangeSubscription_"+curDate+"_"+n+".jpg"));
			        } 
			catch (IOException e) {
			         e.printStackTrace();
			         }
			log.debug(new Timestamp(date.getTime())+":"+"Screenshot Capture Successfully");
			log.debug("-------------------------------------------------------------------------------------------------------------------------");       
			
	//Get information of os and browser
			log.debug(System.getProperty("os.name"));
			Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
	        log.info("Browser Name : " + caps.getBrowserName());
	        log.info("Browser Version : " + caps.getVersion());
			         
	        driver.close();  
	        log.debug("This is the end.");
	       
	        File source=new File("C:\\tmp\\log4j_login2.txt");
	        File dest=new File("C:/tmp/"+curDate+"/"+"Logs_"+curDate+"/"+"ChangeSubscription_"+curDate+"_"+n+".txt");
	        FileUtils.copyFile(source, dest);

	    }

	//If error happens, catch the error message    
	    catch (Exception e) {
	    	  log.error("-------------------------------ERROR----------------------------------------------ERROR------------------------------");
	    	  log.error("Exception has occured : " + e.getMessage());
	    	  }
	    
	//Catch screenshot when error occurs, label the screenshot as "Failed..."
	    	File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	try {
	    	 FileUtils.copyFile(scr, new File("C:/tmp/"+curDate+"/"+"Screenshots_"+curDate+"/"+"Failed_ChangeSubscription_"+curDate+"_"+n+".jpg"));
	    	} catch (IOException e) {
	    	 e.printStackTrace();
	    	}
	    	driver.close();
	//Catch log when error occurs, label the log file as "Failed..."
	    	log.debug("This test is failed.");
	    	File source=new File("C:\\tmp\\log4j_login2.txt");
	    	File dest=new File("C:/tmp/"+curDate+"/"+"Logs_"+curDate+"/"+"Failed_ChangeSubscription_"+curDate+"_"+n+".txt");
	    	FileUtils.copyFile(source, dest);
	    	}}	