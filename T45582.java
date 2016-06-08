import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T45582 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Verify that headline reads "Find available QA Engineers and improve your product"
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\chromedriver_win32 (1)\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("http://test.bidqa.com/");
				
				driver.manage().window().maximize();
				
				//In chrome browser, .click()does not work sometimes. You can use .sendKeys(Keys.ENTER) instead
				
				driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[1]/a")).sendKeys(Keys.ENTER);
				System.out.println(driver.findElement(By.xpath("//div[@class='tp-bgimg defaultimg']")).getText());
				
				//driver.quit();
				
				
	}

}
