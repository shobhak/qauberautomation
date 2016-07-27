package mypackage;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

//implement Interface

public class WaveFit_login_New implements Variables_ {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		    // *************************************************************//
			// ************** LOGIC FOR LOGGING STARTS *********************//
			// *************************************************************//

			

			// Logj properties declaration and for each day log create new folder
			FileAppender fa = new FileAppender();
			fa.setFile(reportDate + "/logs_" + reportDate + "/" + "LOG_" + reportDate2 + ".log");
			fa.setLayout(new PatternLayout("%C{1} %L [%t] %d{dd MMM,yyyy HH:mm:ss.SSS} %-5p - %m%n"));
			fa.setThreshold(Level.ALL);
			fa.setAppend(true);
			fa.activateOptions();

			// *************************************************************//
			// ************** LOGIC FOR LOGGING ENDS ***********************//
			// *************************************************************//


			// similarly you can add all appenders.
			Logger.getRootLogger().addAppender(fa);
			Logger logging = Logger.getLogger(WaveFit_login_New.class);
		    BasicConfigurator.configure();

			logging.info("INFO");
			
		    // Trigger to know where chrome driver is located in device
		    System.setProperty("webdriver.chrome.driver", "C:/Users/Divya/Drivers/chromedriver_win32/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			//Getting the OS information
		    logging.info("OS Name :" + System.getProperty("os.name"));
			
		    try {
			//Getting Browser information
		     Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
		     logging.info("Browser Name : " + caps.getBrowserName());
		     logging.info("Browser Version : " + caps.getVersion());


			//expected title in WaveFit page
			String expectedTitle = "FITS - FITS Web Application";
			Thread.sleep(3000);
			
			String actualTitle = "";
			

			// launch Chrome and direct it to the Base URL
			driver.get(baseUrl);

			// get the actual value of the title
			actualTitle = driver.getTitle();

			/*
			 * compare the actual title of the page with the expected one and
			 * print the result as "Passed" or "Failed"
			 */
			if (actualTitle.contentEquals(expectedTitle)) {
				System.out.println("Test Passed!");
			} else {
				System.out.println("Test Failed");
			}

			driver.manage().window().maximize();
			Thread.sleep(2000);

			// Step2.Enter email
			driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("dsharma1410+6@gmail.com");
			Thread.sleep(2000);
			
			
			// Step3. Enter Password
			driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("Qabidder");
			Thread.sleep(2000);
			
			
			// Step4. Click on Login
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			// Step. Take a screenshot of the result

			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(scr,new File(reportDate + "/Screenshots_" + reportDate + "/" + "ss_" + reportDate2 + ".jpg"));
					} catch (IOException e) {
							e.printStackTrace();
					}
					}
					
			// When Error has occured give message
			    catch (Exception e) {
				logging.error("ERROR HAS OCCURED : " + e.getMessage());
				logging.error("---------------------------------------ERROR OCCURED-----------------------------------------");
						
				Random rand = new Random();
			    int  n = rand.nextInt(1000) + 5;
						
			// Catch screenshot when error occurs, label the screenshot as "Failed..."
				File scre = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					try {
					FileUtils.copyFile(scre,new File(reportDate + "/Screenshots_" + reportDate + "/"  +"ss_Error" + reportDate + n + ".jpg"));
						} catch (Exception er) {
						  er.printStackTrace();
						}
			            
					}
			
		    driver.quit();
	
		}

}
