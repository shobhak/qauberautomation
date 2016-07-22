package mypackage;

import java.io.File;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class WaveFit_Add_Report_Divya_T57002 {

	public static void main(String[] args) throws InterruptedException, IOException {

		// *************************************************************//
		// ************** LOGIC FOR LOGGING STARTS *********************//
		// *************************************************************//

		// Date format for Folder
		DateFormat df = new SimpleDateFormat("MM.dd.yyyy");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		System.out.println("Report Date: " + reportDate);

		// Date format for File
		DateFormat df2 = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date today2 = Calendar.getInstance().getTime();
		String reportDate2 = df2.format(today2);
		System.out.println("Report Date: " + reportDate2);

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

		Logger.getRootLogger().addAppender(fa);
		// similarly you can add all appenders.

		Logger logging = Logger.getLogger(WaveFit_Add_Report_Divya_T57002.class);
		BasicConfigurator.configure();

		logging.info("INFO");

		// Trigger to know where chrome driver is located in device
		System.setProperty("webdriver.chrome.driver", "C:/Users/Divya/Drivers/chromedriver_win32/chromedriver.exe");
		
			// Chrome browser open
			logging.info("Chrome Opened");
			WebDriver driver1 = new ChromeDriver();
			
			try {
			// Step2. Go to fits-alfa URL
			driver1.get("http://qabidder.net/fits-alfa/");

			// Wait until load
			Thread.sleep(5000);

			// Getting the OS information
			logging.info("OS Name :" + System.getProperty("os.name"));

			// Getting Browser information
			Capabilities caps = ((RemoteWebDriver) driver1).getCapabilities();
			logging.info("Browser Name : " + caps.getBrowserName());
			logging.info("Browser Version : " + caps.getVersion());

			// Step3. Enter email
			logging.info("Step3: Email enter");
			driver1.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("dsharma1410+7@gmail.com");
			Thread.sleep(2000);
			logging.info(System.getProperty("os.name."));
			
			// ----------------------Email Enter-----------------//

			// Step4. Enter Password
			driver1.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("Qabidder");
			Thread.sleep(2000);
			logging.info(System.getProperty("os.name."));

			// ----------------Password Enter--------------//

			// Step5. Click on Login
			driver1.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();
			driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			

			// -------------Click on Login Button--------------//

			// Step6. Click on Add Report
			driver1.findElement(By.xpath("html/body/div[2]/aside[1]/div/nav/ul/li[3]/a/span")).click();
			Thread.sleep(2000);
			
			// ------------Click on Add Report---------------//

			// Step7. Click on Appearance
			driver1.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/ol/li[1]/h4")).click();
			Thread.sleep(2000);
			logging.info(System.getProperty("os.name."));

			// -------------Click on Appearance------------//

			// Step8. Enter First name Under Appearance
			driver1.findElement(By.xpath(".//*[@name='first-name']")).sendKeys("Michael");
			logging.info(System.getProperty("os.name."));

			// ------------First name enter------------//

			// Step9. Enter Middle name Under Appearance
			driver1.findElement(By.xpath(".//*[@name='middle-name']")).sendKeys("Steve");
			logging.info(System.getProperty("os.name."));

			// --------------Middle name enter ----------//

			// Step10. Enter Last name Under Appearance
			driver1.findElement(By.xpath(".//*[@name='last-name']")).sendKeys("Job");
			logging.info(System.getProperty("os.name."));

			// ------------last name enter -------------//

			// Step11. Select suspect field under Appearance
			driver1.findElement(By.xpath(
					"html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[4]/div/div/select"));

			// Step12 .Select suspect from drop down list under Appearance
			driver1.findElement(By.xpath(
					"html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[4]/div/div/select/option[2]"));
			logging.info(System.getProperty("os.name."));

			// ----------------Select suspect--------------//

			// Step13. Select date of birth under appearance
			driver1.findElement(By
					.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[2]/div[1]/div/div/p/input"))
					.sendKeys("10-August-2005");
			logging.info(System.getProperty("os.name."));

			// --------------- date of birth Selected -------------//

			// Step14. Select NickName
			driver1.findElement(By.xpath(".//*[@name='Nickname']")).sendKeys("Haveli");
			logging.info(System.getProperty("os.name."));

			// ----------------- NickName Enter --------------//

			// Step15. Select Race box and select Race from drop-down list
			driver1.findElement(By.xpath(
					"/html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[2]/div[3]/div/div/select"));
			driver1.findElement(By.xpath(
					"html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[2]/div[3]/div/div/select/option[3]"));

			// ----------------Race-------------//

			// Step16. Enter Height under Appearance
			driver1.findElement(By.xpath(".//*[@name='Height']")).sendKeys(" 5'2 ");

			// -----------------Height--------------//

			// Step17. Enter Weight under Appearance
			driver1.findElement(By.xpath(".//*[@name='Weight']")).sendKeys("120");

			// -----------------------Weight----------------------------//

			// Step18. click on next button under appearance
			driver1.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[1]/ul/li/a")).click();

			// -----------------click on next button-----------//

			// Step19. Click on special signs under 'Special signs'
			driver1.findElement(By.xpath("//input[@type='checkbox']")).click();

			// ----------------Click on special signs------------//

			// Step19.Click on next button under Special signs
			driver1.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[2]/ul/li[2]/a")).click();

			// -------------------Click next button-------------//

			// Step20.Enter primary language under "Contacts"
			driver1.findElement(By.xpath(".//*[@name='primary-language']")).sendKeys("English");

			//----------------Enter primary language--------------//

			// Step21.Click on next button
			driver1.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[3]/ul/li[2]/a")).click();

			// Step22.Click on Robbery in Gang unit under "Environment"
			driver1.findElement(By
					.xpath("/html/body/div[2]/section/div/div/div/form/div/div[4]/fieldset/div[2]/div[2]/div/label/span"))
					.click();
			Thread.sleep(2000);
			//----------------------Click on Robbery----------------//
			
			//Step23.Click on next button under "Environment"
			driver1.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[4]/ul/li[2]/a")).click();
			
			//Step24.Click on Driver under "Vehicle"
			driver1.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[5]/fieldset/div[1]/div[3]/div/label/span")).click();
			Thread.sleep(2000);
			//----------------------------------//
			
			//Step25.Click on next button under "Vehicle"
			driver1.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[5]/ul/li[2]/a")).click();
			//----------------------------------//
			
			//Step26.Click on next button under "Photo"
			driver1.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[6]/ul/li[2]/a/span")).click();
			//-----------------------------------//
			
			//Step27.Click on open report
			driver1.findElement(By.xpath("/html/body/div[2]/section/div/div/div/form/div/div[7]/div/p[2]/a[1]")).click();
			//------------------------------------//
			
			// Step. Take a screenshot of the result

			File scr = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scr,
						new File(reportDate + "/Screenshots_" + reportDate + "/" + "ss_" + reportDate2 + ".jpg"));
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
			File scre = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scre,
						new File(reportDate + "/Screenshots_" + reportDate + "/"  +"ss_Error" + reportDate + n + ".jpg"));
			} catch (Exception er) {
				er.printStackTrace();
			}
            
		}
   }
}
