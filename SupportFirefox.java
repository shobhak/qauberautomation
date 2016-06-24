package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class SupportFirefox {
		
	@Test
  public void T46363Firefox() throws InterruptedException, IOException {
	//Verify that the form of the "Support" page includes all required elements.
		WebDriver driver = new FirefoxDriver();
		Properties SupportProperty = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\testNG\\data.properties");
		SupportProperty.load(file);
	  
		   driver.get(SupportProperty.getProperty("url"));
		  driver.manage().window().maximize();
		  	  
	  //Click on Support
		  WebElement Supporttab = driver.findElement(By.xpath("//*[text()='Support']"));
		  new WebDriverWait(driver, 10)
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Support']")));
		  
		Supporttab.click();			
		//Verify that Name, Email, Subject, Message & Send is displayed
		new WebDriverWait(driver, 10)
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='your-name']")));
		WebElement YourNameField = driver.findElement(By.xpath("//input[@name='your-name']"));
		WebElement YourEmailField = driver.findElement(By.xpath("//input[@name='your-email']"));
		WebElement YourSubjectField = driver.findElement(By.xpath("//input[@name='your-subject']"));
		WebElement YourMessageField = driver.findElement(By.xpath("//textarea[@name='your-message']"));
		WebElement SendButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Send']"));
		System.out.println("T46363Firefox");
		System.out.println("=============");
		System.out.println("Name tab is displayed "+YourNameField.isDisplayed());
		System.out.println("Email tab is displayed "+YourEmailField.isDisplayed());
		System.out.println("Subject tab is displayed "+YourSubjectField.isDisplayed());
		System.out.println("Message tab is displayed "+YourMessageField.isDisplayed());
		System.out.println("Send button is displayed "+SendButton.isDisplayed());
		System.out.println(" ");
			driver.quit();
		  }
  @Test
  public void T46364Firefox() throws IOException
  {
		WebDriver driver = new FirefoxDriver();
		Properties SupportProperty = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\testNG\\data.properties");
		SupportProperty.load(file);
	  
		   driver.get(SupportProperty.getProperty("url"));
		  driver.manage().window().maximize();
		  	  
	  //Click on Support
		  WebElement Supporttab = driver.findElement(By.xpath("//*[text()='Support']"));
		  new WebDriverWait(driver, 10)
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Support']")));
		  
		Supporttab.click();
	  new WebDriverWait(driver, 10)
	  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='your-name']")));
	  //Verify the "Your name" field should not accept special characters
	  driver.findElement(By.xpath("//input[@name='your-name']")).sendKeys(SupportProperty.getProperty("T46364Name"));
		driver.findElement(By.xpath("//input[@name='your-email']")).sendKeys(SupportProperty.getProperty("T46364Email"));
		driver.findElement(By.xpath("//input[@name='your-subject']")).sendKeys(SupportProperty.getProperty("T46364Subject"));
		driver.findElement(By.xpath("//textarea[@name='your-message']")).sendKeys(SupportProperty.getProperty("T46364Message"));
		driver.findElement(By.xpath("//input[@type='submit' and @value='Send']")).click();
		
		new WebDriverWait(driver, 10)
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='alert']")));
		System.out.println("T46364Firefox");
		System.out.println("=============");
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//div[@role='alert']")).getText()+"'");
		System.out.println(" ");
		driver.quit();
  }
  @Test
  public void T46365Firefox() throws IOException{
	  //Verify "Your Email" text field should not accept invalid email format in support page
	  Properties SupportProperty = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		SupportProperty.load(file);
		WebDriver driver = new FirefoxDriver();
		driver.get(SupportProperty.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Support
		driver.findElement(By.xpath("//a[text()='Support']")).click();
		
		//Enter valid name, valid Subject, Invalid email address and valid message
		driver.findElement(By.xpath("//input[@name='your-name']")).sendKeys(SupportProperty.getProperty("T46365Name"));
		driver.findElement(By.xpath("//input[@name='your-email']")).sendKeys(SupportProperty.getProperty("T46365Email"));
		driver.findElement(By.xpath("//input[@name='your-subject']")).sendKeys(SupportProperty.getProperty("T46365Subject"));
		driver.findElement(By.xpath("//textarea[@name='your-message']")).sendKeys(SupportProperty.getProperty("T46365Message"));
		driver.findElement(By.xpath("//input[@type='submit' and @value='Send']")).click();
		
		System.out.println("T46365Firefox");
		System.out.println("=============");
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//span[@role='alert']")).isDisplayed());
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//div[@role='alert']")).getText()+"'");
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//span[@role='alert']")).getText()+"'");
		System.out.println(" ");
		
		driver.quit();
  }
 @Test
 public void T46362Firefox() throws IOException{
	 //Verify that "Your name" text field in "Support" page cannot be left blank
	 Properties SupportProperty = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		SupportProperty.load(file);
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get(SupportProperty.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Support
		driver.findElement(By.xpath("//a[text()='Support']")).click();
		
		//Enter valid name, valid Subject, Invalid email address and valid message
		driver.findElement(By.xpath("//input[@name='your-name']")).sendKeys(SupportProperty.getProperty("T46362Name"));
		driver.findElement(By.xpath("//input[@name='your-email']")).sendKeys(SupportProperty.getProperty("T46362Email"));
		driver.findElement(By.xpath("//input[@name='your-subject']")).sendKeys(SupportProperty.getProperty("T46362Subject"));
		driver.findElement(By.xpath("//textarea[@name='your-message']")).sendKeys(SupportProperty.getProperty("T46362Message"));
		driver.findElement(By.xpath("//input[@type='submit' and @value='Send']")).click();
		
		System.out.println("T46362Firefox");
		System.out.println("=============");
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//span[@role='alert']")).isDisplayed());
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//div[@role='alert']")).getText()+"'");
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//span[@role='alert']")).getText()+"'");
		System.out.println(" ");
		
		driver.quit();
 }
 @Test
public void T46368Firefox() throws IOException{
	 //Verify user cannot submit an empty "feedback form" in Support page
	 Properties SupportProperty = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		SupportProperty.load(file);
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get(SupportProperty.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Support
		driver.findElement(By.xpath("//a[text()='Support']")).click();
		
		//Enter valid name, valid Subject, Invalid email address and valid message
		driver.findElement(By.xpath("//input[@name='your-name']")).sendKeys(SupportProperty.getProperty("T46368Name"));
		driver.findElement(By.xpath("//input[@name='your-email']")).sendKeys(SupportProperty.getProperty("T46368Email"));
		driver.findElement(By.xpath("//input[@name='your-subject']")).sendKeys(SupportProperty.getProperty("T46368Subject"));
		driver.findElement(By.xpath("//textarea[@name='your-message']")).sendKeys(SupportProperty.getProperty("T46368Message"));
		driver.findElement(By.xpath("//input[@type='submit' and @value='Send']")).click();		
		
		System.out.println("T46368Firefox");
		System.out.println("=============");
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//span[@role='alert']")).isDisplayed());
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//div[@role='alert']")).getText()+"'");
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//span[@role='alert']")).getText()+"'");
		System.out.println(" ");
		
		driver.quit();
 }
 @Test
 public void T46366Firefox() throws IOException{
	 //Verify "Subject" text field in "feedback form "cannot be left blank
	 Properties SupportProperty = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		SupportProperty.load(file);
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get(SupportProperty.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Support
		driver.findElement(By.xpath("//a[text()='Support']")).click();
		
		//Enter valid name, valid Subject, Invalid email address and valid message
		driver.findElement(By.xpath("//input[@name='your-name']")).sendKeys(SupportProperty.getProperty("T46366Name"));
		driver.findElement(By.xpath("//input[@name='your-email']")).sendKeys(SupportProperty.getProperty("T46366Email"));
		driver.findElement(By.xpath("//input[@name='your-subject']")).sendKeys(SupportProperty.getProperty("T46366Subject"));
		driver.findElement(By.xpath("//textarea[@name='your-message']")).sendKeys(SupportProperty.getProperty("T46366Message"));
		driver.findElement(By.xpath("//input[@type='submit' and @value='Send']")).click();		
		
		System.out.println("T46366Firefox");
		System.out.println("=============");
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//span[@role='alert']")).isDisplayed());
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//div[@role='alert']")).getText()+"'");
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//span[@role='alert']")).getText()+"'");
		System.out.println(" ");
		
		driver.quit();
 }
 @Test
 public void T46369Firefox() throws IOException{
	 //Verify that the user can send the feedback using 'Support' page.
	 Properties SupportProperty = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\BidQA\\src\\BidQAData.properties");
		SupportProperty.load(file);
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get(SupportProperty.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Support
		driver.findElement(By.xpath("//a[text()='Support']")).click();
		
		//Enter valid name, valid Subject, Invalid email address and valid message
		driver.findElement(By.xpath("//input[@name='your-name']")).sendKeys(SupportProperty.getProperty("T46369Name"));
		driver.findElement(By.xpath("//input[@name='your-email']")).sendKeys(SupportProperty.getProperty("T46369Email"));
		driver.findElement(By.xpath("//input[@name='your-subject']")).sendKeys(SupportProperty.getProperty("T46369Subject"));
		driver.findElement(By.xpath("//textarea[@name='your-message']")).sendKeys(SupportProperty.getProperty("T46369Message"));
		driver.findElement(By.xpath("//input[@type='submit' and @value='Send']")).click();		
		
		System.out.println("T46369Firefox");
		System.out.println("=============");
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		
		System.out.println("Text displayed is: '"+driver.findElement(By.xpath("//div[@role='alert']")).getText()+"'");
		System.out.println(" ");
		
		driver.quit();
 }
  

}
