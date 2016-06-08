import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class T45432 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Verify that Project Owner can make payments to QA Engineers - Firefox (not Internet Explorer) (Working on Firefox)
//System.setProperty("webdriver.ie.driver", "C:\\Users\\sujai\\Documents\\Portnov\\Vladimir - Selenium\\Eclipse workspace\\IEDriverServer_x64_2.53.0\\IEDriverServer.exe");
WebDriver driver = new FirefoxDriver();

driver.get("http://test.bidqa.com/");

driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[8]/a")).click();
driver.findElement(By.xpath(".//*[@name='log']")).sendKeys("Su");
driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("abcdefgh");
driver.findElement(By.xpath(".//*[@id='submits']")).click();

//My account == Finances
driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[7]/a")).click();
driver.findElement(By.partialLinkText("Finances")).click();

//Print out current balance
System.out.println("Amount before making transfer to Paypal: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());

//Deposit money
driver.findElement(By.partialLinkText("Deposit Money")).click();

//Entering random amount between 25 & 40
String RandomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(25,40+1));
driver.findElement(By.id("amount")).sendKeys(RandomNumber);

driver.findElement(By.name("deposit")).click();

//Switched to Paypal account
System.out.println(driver.getTitle());

driver.findElement(By.id("loadLogin")).click();
driver.findElement(By.id("login_email")).clear();
driver.findElement(By.id("login_email")).sendKeys("srjssmiles-buyer@gmail.com");
driver.findElement(By.id("login_password")).clear();
driver.findElement(By.id("login_password")).sendKeys("abcdefgh");
driver.findElement(By.id("submitLogin")).click();

driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.findElement(By.name("continue")).click();

driver.findElement(By.xpath("//input[@name='merchant_return_link']")).click();

driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

System.out.println("Amount before payment: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());

//Make a payment
driver.findElement(By.partialLinkText("Make Payment")).click();
driver.findElement(By.id("amount")).sendKeys(RandomNumber);

System.out.println("Amount being paid is: "+driver.switchTo().activeElement().getText());

driver.findElement(By.name("username")).sendKeys("RS");
driver.findElement(By.name("payme")).click();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

if (isAlertPresent()) {
    driver.switchTo().alert();
    
    driver.switchTo().alert().accept();
    driver.switchTo().defaultContent();
    
}
		
System.out.println("Balance after payment: "+driver.findElement(By.xpath("//span[@class='balance']")).getText());

//Verify transaction on 'Transactions' page
driver.findElement(By.partialLinkText("Transactions")).click();
System.out.println(driver.findElement(By.xpath("//div[@class='my_box3']")).getText());

driver.quit();

	}

	private static boolean isAlertPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
