import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T46554 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Verify that QA Engineer gets message on screen "Dispute Created" (Working on Chrome)
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://test.bidqa.com/");
		
driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
		driver.findElement(By.xpath(".//*[@id='log']")).sendKeys("RS");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
		driver.findElement(By.xpath(".//*[@id='submits']")).click();
		
		//Creation of object for actions (move mouse over My account)
		
		Actions dce = new Actions(driver);
		WebElement MyAccount = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a"));
		dce.moveToElement(MyAccount).build().perform();
		
		//Click on Disputes
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/ul/li[6]/a")).click();
		
		//Select from Defendant dropdown
		Select defendantdropdown = new Select (driver.findElement(By.name("defendant")));
		defendantdropdown.selectByIndex(0);
		
		//Write comment & click submit
		driver.findElement(By.name("comment")).sendKeys("fjwaeoihrjkrgnaoirtakdngfjadhsfoijkdlsf");
		driver.findElement(By.xpath("//*[@value='Create Dispute']")).click();
		
		//To switch to the alert and display the information
		System.out.println(driver.findElement(By.xpath(".//*[@id='content']/div[1]")).getText());
		
		//driver.quit();

	}

}
