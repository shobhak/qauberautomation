package log4j;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.log4testng.Logger;

public class Log4j_registration_June {
	static Logger log=Logger.getLogger(Log4j_registration_June.class);
	//PropertyConfigurator.configure("log4j.properties");

 public static void main(String[] args) throws InterruptedException, IOException {
       
//define several varibles for later use	 
	   Date date= new Date();
       SimpleDateFormat dateFormat= new SimpleDateFormat("MM-dd-yyyy");
       String curDate= dateFormat.format(date);
       Random rand = new Random();
       int  n = rand.nextInt(1000) + 5;
  
//start chrome driver
       System.setProperty("webdriver.chrome.driver" , "C:/chromedriver_win32/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       Thread.sleep(3000);
  
//Open http://qabidder.net/fits-alfa/#/page/login
       try{  
        driver.get("http://qabidder.net/fits-alfa/#/page/login");
        Thread.sleep(4000);
        	log.debug("-------------------------------------------------------------------------");
            log.debug("step1. URL is opened successfully.");
            log.debug("-------------------------------------------------------------------------");
          
//Click on Register button
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Enter Name in Register page
         WebElement Name = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[1]/input"));
         Name.clear();
         Name.sendKeys("weixj828"+n);
         log.debug("------------------------------------------------------------------------------------");
         log.debug("Name is entered.");
         log.debug("------------------------------------------------------------------------------------");
        
//Enter Email in Register page
         WebElement Email = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[2]/input"));
         Email.clear();
         Email.sendKeys("weixjj828" +n+"@gmail.com");        
         log.debug("------------------------------------------------------------------------------------");
         log.debug("Email is entered.");
         log.debug("------------------------------------------------------------------------------------");
        
         
//Enter Password in Register Page
         WebElement Password = driver.findElement(By.id("id-password"));
         Password.clear();
         Password.sendKeys("890uiojkl");
         log.debug("-----------------------------------------------------------------------------------------------");
         log.debug("Password is entered");
         log.debug("------------------------------------------------------------------------------------------------");
         
//Reenter password in Register Page
         WebElement RePassword = driver.findElement(By.name("account_password_confirm"));
         RePassword.clear();
         RePassword.sendKeys("890uiojkl");
         log.debug("---------------------------------------------------------------------------------------------------");
         log.debug("Password is re-entered");
         log.debug("----------------------------------------------------------------------------------------------------");
         
//Click on Continue registration
         driver.manage().window().maximize();
         Thread.sleep(2000);
         driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/form/button")).click();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         log.debug("------------------------------------------------------------------------------------");
         log.debug("Clicked 'Continue registration' button.");
         log.debug("------------------------------------------------------------------------------------");
         
        
//Enter Organization Name      
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/input")).sendKeys("Company"+n);
        log.debug("------------------------------------------------------------------------------------");
        log.debug("Company name is entered.");
        log.debug("------------------------------------------------------------------------------------");
         
//Enter Zip Code
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/input")).sendKeys("95051");
        log.debug("------------------------------------------------------------------------------------");
        log.debug("Zip code is entered.");
        log.debug("------------------------------------------------------------------------------------");
         
//Enter Address(1)
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/input")).sendKeys("3560 poinciana drive");
        log.debug("------------------------------------------------------------------------------------");
        log.debug("Address is entered.");
        log.debug("------------------------------------------------------------------------------------");
        
        
//Enter City name
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/input")).sendKeys("Santa clara");
        log.debug("------------------------------------------------------------------------------------");
        log.debug("City name is entered.");
        log.debug("------------------------------------------------------------------------------------");
        
//Enter Phone Number
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/input")).sendKeys("408-234-5432");
        log.debug("------------------------------------------------------------------------------------");
        log.debug("Phone number is entered");
        log.debug("------------------------------------------------------------------------------------");
        
        
//Enter Email address
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div/div/input")).sendKeys("weixj828+"+n+"@gmail.com");
        log.debug("------------------------------------------------------------------------------------");
        log.debug("Email is entered");
        log.debug("------------------------------------------------------------------------------------");
        
       
//Click on Finish Registration
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/button")).click();
        Thread.sleep(8000);
        log.debug("-----------------------------------------------------------------------------------");
        log.debug("Clicked 'Finish Registration' button");
        log.debug("----------------------------------------------------------------------------------");
        Thread.sleep(2000);
        
//Make sure the 'registration successful' page is loaded      
        String registration= driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/a")).getText();
        if(registration == "Login")
        { 
        log.debug("----------------------------------------------------------------------------------");
        log.debug("Registration page is loaded successfully");
        log.debug("----------------------------------------------------------------------------------");}
        else
        {log.debug("test failed");}
        
//System and browser information
        log.debug(System.getProperty("os.name")); 
        Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
        log.debug("Browser Name : " + caps.getBrowserName());
        log.debug("Browser Version : " + caps.getVersion()); 
        
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {    
		FileUtils.copyFile(scr, new File("C:/tmp/"+curDate+"/"+"Screenshots_"+curDate+"/"+curDate+"_"+n+".jpg"));
		        } 
		catch (IOException e) {
		         e.printStackTrace();
		         }
        log.debug("----------------------------------------------------------------------------------------------------");
		log.debug(new Timestamp(date.getTime())+":"+"Step5.Screenshot is captured Successfully");
		log.debug("-----------------------------------------------------------------------------------------------------");          
            
		driver.close();
		log.debug("This is the end.");
		
        File source=new File("C:\\tmp\\log4j_login2.txt");
        File dest=new File("C:/tmp/"+curDate+"/"+"Logs_"+curDate+"/"+"registration_"+"wavefit_registration"+curDate+"_"+n+".txt");
        FileUtils.copyFile(source, dest);}
  
//catch screenshot when error occurs; label the screenshot as "Failed..."  
       catch (Exception e){
	    log.error("------------------------ERROR------------------------------ERROR---------------------------------");
        log.error("Exception has occured: "+ e.getMessage());}
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
	     FileUtils.copyFile(scr, new File("C:/tmp/"+curDate+"/"+"Screenshots_"+curDate+"/"+"Failed_registration_"+curDate+"_"+n+".jpg"));
	     } catch (IOException e) {
	    e.printStackTrace();}
	    driver.close();
	
//Catch log when error occurs; label the log file as "Failed..."
	     log.debug("This test is failed.");
	     File source=new File("C:\\tmp\\log4j_login2.txt");
	     File dest=new File("C:/tmp/"+curDate+"/"+"Logs_"+curDate+"/"+"Failed_registration_"+curDate+"_"+n+".txt");
	     FileUtils.copyFile(source, dest);
	}}	
 
 
 
        
 
  