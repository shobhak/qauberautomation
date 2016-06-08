package TestSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RateUserPO {
	//set webdriver and string URL
	public static String Test_BidQA_URL = "http://test.bidqa.com/";
	public WebDriver driver = null;
	
	
	@BeforeMethod
	public void setup(){
		//invoke browser and open test.bidqa
		driver = new FirefoxDriver();
		driver.get(Test_BidQA_URL);
		
		//Log In
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
				
		//enter credentials
		driver.findElement(By.xpath("//input[@id='log']")).sendKeys("dezlozada");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("dennislozada21");
				
		//click on submit
		Actions XXX = new Actions(driver);
		WebElement submit = driver.findElement(By.xpath("//input[@id='submits']"));
		XXX.click(submit).build().perform();
		
	}
	
	@AfterMethod
	public void quit(){
		//close browser
		driver.close();
		
	}
	
	@Test
	public void RateTest() throws InterruptedException{
		//manage timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//hover to myAccount
		Actions XXX = new Actions(driver);
		WebElement myAcc = driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/a"));
		XXX.moveToElement(myAcc).build().perform();
		
		//click on Feedback/Reviews
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cssmenu']/ul/li[6]/ul/li[5]/a")));
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[6]/ul/li[5]/a")).click();
		
		//click on rate user
		WebElement Rate = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]/table/tbody/tr[2]/th[6]"));
		Rate.findElement(By.tagName("a")).click();
		
		//select rating from 1-5
		Select drop = new Select(driver.findElement(By.xpath("//select[@name='rating']")));
		drop.selectByVisibleText("3");
		
		//enter comments/reviews
		driver.findElement(By.xpath("//textarea[@name='commenta']")).sendKeys("Perfect!!");
		
		//click Submit rating
		WebElement sub = driver.findElement(By.xpath("//input[@value='Submit Rating']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", sub);
		
		//WebElement confirmation = driver.findElement(By.xpath("//*[@id='content']/div/div/div"));
		//Assert.assertEquals(confirmation.getText(), );
		
		String Actual = driver.findElement(By.xpath("//*[@id='content']/div/div/div")).getText();
		Assert.assertEquals(Actual, "Your rating has been posted. Return to Feedback/Reviews page");
		System.out.println("Message: " + Actual);
		
		
		
	}
}
