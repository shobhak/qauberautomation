package FirstRun;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/* TC: Verify "Reports" link is functional https://bidqa.testrail.net/index.php?/cases/view/11859 */
public class C11859 {

    ChromeDriver driver = new ChromeDriver();

    @AfterMethod
    public void ShutDown() {

        //clearing cache
        driver.manage().deleteAllCookies();

        //closing Browser
        driver.quit();
    }
    @Test
    public void VerifyReportsPage() throws InterruptedException {

        //Navigate to login page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(4000);

        //login
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("arkadiy.plekhanov@yahoo.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("qwerty123");
        driver.findElementByXPath("//button[@type='submit']").click();
        Thread.sleep(5000);

        //Navigating out of main page("Reports")
        driver.findElementByXPath("//span[contains(.,'Add Report')]").click();
        Thread.sleep(2000);

        //Checking if link is functional
        driver.findElementByXPath("//span[contains(.,'Reports')]").click();
        Thread.sleep(3000);

        //Verifying if "Reports" page is functional.
        if (driver.findElement(By.xpath("//small[contains(.,'Search and filter results')]")).isDisplayed()) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}