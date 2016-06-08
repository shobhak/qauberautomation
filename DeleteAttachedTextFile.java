package TestScripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;

public class DeleteAttachedTextFile {

		public static void main(String[] args) {
			/*NOTE NOTE NOTE to upload your own file
			you need to change the code "browser.sendKeys("C:\\Users\\dezlo\\Desktop\\Notes\\Cloud.txt")"
			to any text file path you want to upload
			*/
			//AND REFER THE RESULT TO THE IMAGE RESULTS on D 
			
			//invoke browser and open bidqa
			WebDriver driver = new FirefoxDriver();
			String Url = "http://test.bidqa.com";
									
			driver.get(Url);
								
			//manage timeouts
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
											
			//click log in
			driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
											
			//enter credentials
			driver.findElement(By.xpath("//input[@id='log']")).sendKeys("lozadadez1");
			driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
									
			//click on submit
			driver.findElement(By.xpath("//input[@id='submits']")).click();
									
			//declare Action class
			Actions XXX = new Actions(driver);
									
			//identify the myAccount element
			WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[7]/a"));
									
			//hover your mouse on myAccount
			XXX.moveToElement(myAcc).build().perform();
									
			//click on private messages
			driver.findElement(By.linkText("Private Messages")).click();
			
			//click on send new message
			driver.findElement(By.xpath("//*[@id='content']/div[1]/div/ul/li[2]/a")).click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//driver.findElement(By.xpath("//input[@id='file_instant']")).click();
			
			//upload file
			WebElement browser = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[2]/div[3]/div[2]/form/table/tbody/tr[4]/td[2]/div[1]/span[1]/input"));
			browser.sendKeys("C:\\Users\\dezlo\\Desktop\\Notes\\Cloud.txt");
			
			//click + button to add file space
			WebElement Plus = driver.findElement(By.xpath("//*[@id='file_instant_row']/td[3]/input"));
			Plus.click();
			
			//upload file
			WebElement browser1 = driver.findElement(By.xpath("html/body/div[3]/div[4]/div/div[2]/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/div[1]/span[1]/input"));
			browser1.sendKeys("C:\\Users\\dezlo\\Desktop\\Notes\\Cloud.txt");
			
			File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				
				FileUtils.copyFile(SrcFile, new File("D:\\FileBeforeScreenshot1.png"));
				
			}
			
			catch(IOException e) {
				
				e.printStackTrace();
			}
			
			//click delete file
			driver.findElement(By.xpath("//*[@id='file_instant_row']/td[2]/div[1]/span[2]")).click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			File SrcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				
				FileUtils.copyFile(SrcFile1, new File("D:\\FileAfterScreenshot2.png"));
				
			}
			
			catch(IOException e) {
				
				e.printStackTrace();
			}
			
			
			driver.close();
			
		}

	}
